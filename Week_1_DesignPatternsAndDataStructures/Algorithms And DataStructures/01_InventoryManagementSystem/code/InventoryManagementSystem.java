import java.util.HashMap;
import java.util.Scanner;

// Product Model
class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int id, String name, int qty, double price) {
        this.productId = id;
        this.productName = name;
        this.quantity = qty;
        this.price = price;
    }

    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Qty: " + quantity + ", Price: $" + price;
    }
}

// Inventory Manager
class Inventory {
    private HashMap<Integer, Product> products = new HashMap<>();

    public void addProduct(Product p) {
        products.put(p.productId, p);
        System.out.println("Product added: " + p.productName);
    }

    public void updateProduct(int id, int qty, double price) {
        if (products.containsKey(id)) {
            Product p = products.get(id);
            p.quantity = qty;
            p.price = price;
            System.out.println("Product updated: " + p.productName);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int id) {
        if (products.remove(id) != null) {
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product p : products.values()) {
                System.out.println(p);
            }
        }
    }
}

// Main Application
public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add\n2. Update\n3. Delete\n4. View All\n5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Quantity, Price: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    int qty = sc.nextInt();
                    double price = sc.nextDouble();
                    inventory.addProduct(new Product(id, name, qty, price));
                    break;
                case 2:
                    System.out.print("Enter ID to update, New Qty, New Price: ");
                    int uid = sc.nextInt();
                    int newQty = sc.nextInt();
                    double newPrice = sc.nextDouble();
                    inventory.updateProduct(uid, newQty, newPrice);
                    break;
                case 3:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    inventory.deleteProduct(did);
                    break;
                case 4:
                    inventory.listProducts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
