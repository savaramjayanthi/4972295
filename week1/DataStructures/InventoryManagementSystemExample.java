import java.util.HashMap;
import java.util.Map;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

class InventoryManagementSystem {
    private Map<String, Product> inventory;

    public InventoryManagementSystem() {
        this.inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found.");
        }
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public void displayAllProducts() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}

public class InventoryManagementSystemExample {
    public static void main(String[] args) {
        InventoryManagementSystem inventorySystem = new InventoryManagementSystem();

        Product product1 = new Product("1", "Laptop", 10, 999.99);
        Product product2 = new Product("2", "Smartphone", 20, 499.99);
        inventorySystem.addProduct(product1);
        inventorySystem.addProduct(product2);

        inventorySystem.displayAllProducts();

        product1.setPrice(949.99);
        inventorySystem.updateProduct(product1);

        Product retrievedProduct = inventorySystem.getProduct("1");
        System.out.println("Retrieved Product: " + retrievedProduct);

        inventorySystem.deleteProduct("2");

        inventorySystem.displayAllProducts();
    }
}
