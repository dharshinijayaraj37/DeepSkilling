public class OrderSortingExample {

    // Order class
    static class Order {
        int orderId;
        String customerName;
        double totalPrice;

        public Order(int orderId, String name, double price) {
            this.orderId = orderId;
            this.customerName = name;
            this.totalPrice = price;
        }

        public String toString() {
            return "OrderID: " + orderId + ", Customer: " + customerName + ", Total: $" + totalPrice;
        }
    }

    // Bubble Sort
    static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // swap
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
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

    // Print orders
    static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    // Main method
    public static void main(String[] args) {
        Order[] orders1 = {
            new Order(1001, "Alice", 500.75),
            new Order(1002, "Bob", 250.50),
            new Order(1003, "Charlie", 899.99),
            new Order(1004, "David", 120.00),
            new Order(1005, "Eva", 1500.00)
        };

        // Copy for quick sort
        Order[] orders2 = orders1.clone();

        System.out.println("Original Orders:");
        printOrders(orders1);

        System.out.println("\nSorted by Bubble Sort:");
        bubbleSort(orders1);
        printOrders(orders1);

        System.out.println("\nSorted by Quick Sort:");
        quickSort(orders2, 0, orders2.length - 1);
        printOrders(orders2);
    }
}
