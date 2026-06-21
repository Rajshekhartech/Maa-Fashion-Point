import java.util.ArrayList;

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

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product("Shirt", 10, 599));
        products.add(new Product("Jeans", 5, 1299));
        products.add(new Product("T-Shirt", 20, 399));

        System.out.println("=================================");
        System.out.println("      MAA FASHION POINT");
        System.out.println("=================================");

        System.out.println("\nAvailable Products:");

        double totalInventoryValue = 0;

        for (Product p : products) {

            double value = p.quantity * p.price;
            totalInventoryValue += value;

            System.out.println(
                "Product: " + p.name +
                " | Qty: " + p.quantity +
                " | Price: ₹" + p.price +
                " | Value: ₹" + value
            );
        }

        System.out.println("\nTotal Inventory Value: ₹" + totalInventoryValue);

        System.out.println("\nBuild Successful!");
    }
}
}
