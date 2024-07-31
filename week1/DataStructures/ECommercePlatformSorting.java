public class ECommercePlatformSorting {

    public static void main(String[] args) {
        Order[] orders = {
            new Order("1", "Alice", 250.0),
            new Order("2", "Bob", 150.0),
            new Order("3", "Charlie", 200.0),
            new Order("4", "Dave", 100.0),
            new Order("5", "Eve", 300.0)
        };

        // Bubble Sort
        System.out.println("Bubble Sort:");
        BubbleSort.sort(orders);
        for (Order order : orders) {
            System.out.println(order);
        }

        // Resetting orders for Quick Sort
        orders = new Order[]{
            new Order("1", "Alice", 250.0),
            new Order("2", "Bob", 150.0),
            new Order("3", "Charlie", 200.0),
            new Order("4", "Dave", 100.0),
            new Order("5", "Eve", 300.0)
        };

        // Quick Sort
        System.out.println("\nQuick Sort:");
        QuickSort.sort(orders, 0, orders.length - 1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

// Order Class
class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

// Bubble Sort Implementation
class BubbleSort {
    public static void sort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}

// Quick Sort Implementation
class QuickSort {
    public static void sort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            sort(orders, low, pi - 1);
            sort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}
