import java.util.*;
import java.util.concurrent.*;

public class InventoryManager {
    private ConcurrentHashMap<String, Product> products;
    private PriorityQueue<Order> orderQueue;

    public InventoryManager() {
        products = new ConcurrentHashMap<>();
        orderQueue = new PriorityQueue<>(new OrderComparator());
    }

    public synchronized void addProduct(Product product) {
        products.put(product.getProductID(), product);
    }

    public synchronized void processOrder(Order order) throws OutOfStockException {
        for (String productId : order.getProductIDs()) {
            Product product = products.get(productId);
            if (product == null || product.getQuantity() <= 0) {
                throw new OutOfStockException("Product " + productId + " is out of stock.");
            }
            product.adjustQuantity(-1);
        }
        System.out.println("Processed " + order);
    }

    public void addOrder(Order order) {
        orderQueue.add(order);
    }
    
    public void processOrders() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            executor.execute(() -> {
                try {
                    processOrder(order);
                } catch (OutOfStockException e) {
                    System.out.println(e.getMessage());
                }
            });
        }
        executor.shutdown();
    }

    public void printInventory() {
        products.values().forEach(System.out::println);
    }
}