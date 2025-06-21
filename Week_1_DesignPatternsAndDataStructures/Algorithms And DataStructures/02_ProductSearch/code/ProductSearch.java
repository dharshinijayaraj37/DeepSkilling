import java.util.Arrays;
import java.util.Comparator;

public class ProductSearch {

    // Step 1 & 2: Define Product class
    static class Product {
        int productId;
        String productName;
        String category;

        public Product(int id, String name, String category) {
            this.productId = id;
            this.productName = name;
            this.category = category;
        }

        public String toString() {
            return "ID: " + productId + ", Name: " + productName + ", Category: " + category;
        }
    }

    // Step 3: Linear Search by Product Name
    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // Step 3: Binary Search by Product Name (requires sorted array)
    public static Product binarySearch(Product[] products, String name) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0) return products[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    // Step 5: Main method for testing
    public static void main(String[] args) {
        // Sample inventory
        Product[] inventory = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shirt", "Apparel"),
            new Product(103, "Book", "Stationery"),
            new Product(104, "Phone", "Electronics"),
            new Product(105, "Shoes", "Footwear")
        };

        System.out.println("=== Linear Search (Unsorted) ===");
        Product linearResult = linearSearch(inventory, "Phone");
        System.out.println(linearResult != null ? linearResult : "Product not found.");

        // Sort inventory for binary search
        Arrays.sort(inventory, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("\n=== Binary Search (Sorted by Name) ===");
        Product binaryResult = binarySearch(inventory, "Phone");
        System.out.println(binaryResult != null ? binaryResult : "Product not found.");
    }
}

