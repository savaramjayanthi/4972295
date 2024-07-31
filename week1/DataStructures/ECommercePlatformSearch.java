import java.util.Arrays;
import java.util.Comparator;

class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

class LinearSearch {
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }
}

class BinarySearch {
    public static Product binarySearch(Product[] products, String targetName) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName));

        int left = 0;
        int right = products.length - 1;

        while (left <= right) 
        {
            int mid = left + (right - left) / 2;
            int result = targetName.compareToIgnoreCase(products[mid].getProductName());

            if (result == 0) {
                return products[mid];
            }

            if (result > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }
}

public class ECommercePlatformSearch {
    public static void main(String[] args) {
        Product[] products = {
            new Product("1", "Laptop", "Electronics"),
            new Product("2", "Smartphone", "Electronics"),
            new Product("3", "Tablet", "Electronics"),
            new Product("4", "Headphones", "Accessories"),
            new Product("5", "Charger", "Accessories")
        };

        String targetName = "Smartphone";

        Product result = LinearSearch.linearSearch(products, targetName);
        if (result != null) {
            System.out.println("Linear Search: Product found: " + result);
        } else {
            System.out.println("Linear Search: Product not found.");
        }

        result = BinarySearch.binarySearch(products, targetName);
        if (result != null) {
            System.out.println("Binary Search: Product found: " + result);
        } else {
            System.out.println("Binary Search: Product not found.");
        }
    }
}
