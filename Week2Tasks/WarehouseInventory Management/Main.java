import java.util.*;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        // Initializing inventory
        inventoryManager.addProduct(new Product("P001", "Laptop", 5, new Location(1, 2, 3)));
        inventoryManager.addProduct(new Product("P002", "Phone", 10, new Location(2, 1, 4)));
        inventoryManager.addProduct(new Product("P003", "Headphones", 8, new Location(3, 3, 2)));

        // Creating orders
        List<String> order1Items = Arrays.asList("P001", "P003");
        Order order1 = new Order("O001", order1Items, Order.Priority.EXPEDITED);

        List<String> order2Items = Arrays.asList("P002");
        Order order2 = new Order("O002", order2Items, Order.Priority.STANDARD);

        // Adding orders to queue
        inventoryManager.addOrder(order1);
        inventoryManager.addOrder(order2);

        // Processing orders
        inventoryManager.processOrders();

        // Display final inventory
        System.out.println("\nFinal Inventory:");
        inventoryManager.printInventory();
    }
}
