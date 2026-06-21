import java.util.ArrayList;
import java.util.Scanner;

class Product {
    String name;
    int quantity;
    double price;

    Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}

public class Main {

    static ArrayList<Product> products = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== MAA FASHION POINT =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Sell Product");
            System.out.println("4. Update Stock");
            System.out.println("5. Exit");
            System.out.print("Choose Option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    sellProduct();
                    break;
                case 4:
                    updateStock();
                    break;
                case 5:
                    System.out.println("Thank you for using Maa Fashion Point!");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void addProduct() {
        sc.nextLine();

        System.out.print("Product Name: ");
        String name = sc.nextLine();

        System.out.print("Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Price: ");
        double price = sc.nextDouble();

        products.add(new Product(name, quantity, price));

        System.out.println("Product Added Successfully!");
    }

    static void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n----- INVENTORY -----");

        for (Product p : products) {
            System.out.println(
                "Product: " + p.name +
                " | Quantity: " + p.quantity +
                " | Price: ₹" + p.price
            );
        }
    }

    static void sellProduct() {
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        for (Product p : products) {
            if (p.name.equalsIgnoreCase(name)) {

                System.out.print("Quantity to Sell: ");
                int qty = sc.nextInt();

                if (qty <= p.quantity) {
                    p.quantity -= qty;

                    double bill = qty * p.price;

                    System.out.println("Sale Successful!");
                    System.out.println("Total Bill: ₹" + bill);
                } else {
                    System.out.println("Insufficient Stock!");
                }
                return;
            }
        }

        System.out.println("Product Not Found!");
    }

    static void updateStock() {
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        for (Product p : products) {
            if (p.name.equalsIgnoreCase(name)) {

                System.out.print("Add Quantity: ");
                int qty = sc.nextInt();

                p.quantity += qty;

                System.out.println("Stock Updated Successfully!");
                return;
            }
        }

        System.out.println("Product Not Found!");
    }
}