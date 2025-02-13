public class Product {
    private String productID;
    private String name;
    private int quantity;
    private Location location;

    public Product(String productID, String name, int quantity, Location location) {
        this.productID = productID;
        this.name = name;
        this.quantity = quantity;
        this.location = location;
    }

    public synchronized void adjustQuantity(int change) {
        this.quantity += change;
    }

    public String getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return productID + " - " + name + " | Quantity: " + quantity + " | Location: " + location;
    }
}
