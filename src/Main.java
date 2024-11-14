import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Create some Fabrics
        Fabric cotton = new Fabric("F001", "Cotton", "White", 10.0);
        Fabric polyester = new Fabric("F002", "Polyester", "Blue", 8.5);

        // Create some Garments
        Garment tshirt = new Garment("G001", "T-shirt", "Casual T-shirt", "M", "Red", 20.0, 50);
        Garment pants = new Garment("G002", "Pants", "Denim Jeans", "L", "Blue", 40.0, 30);

        // Create a Supplier and add Fabrics to the Supplier
        Supplier supplier = new Supplier("S001", "ABC Textiles", "123-456-7890");
        supplier.addFabric(cotton);
        supplier.addFabric(polyester);

        // Print the fabrics supplied by the supplier
        System.out.println("Fabrics supplied by " + supplier.getName() + ":");
        for (Fabric fabric : supplier.getSuppliedFabrics()) {
            System.out.println("- " + fabric.getType() + " (" + fabric.getColor() + ")");
        }

        // Create an Inventory and add Garments to it
        Inventory inventory = new Inventory();
        inventory.addGarment(tshirt);
        inventory.addGarment(pants);

        // Find a garment in inventory by ID and display it
        Garment foundGarment = inventory.findGarment("G001");
        if (foundGarment != null) {
            System.out.println("Found garment in inventory: " + foundGarment.getName() + " - $" + foundGarment.getPrice());
        }

        // Create a Customer
        Customer customer = new Customer("C001", "John Doe", "johndoe@example.com", "555-1234");

        // Create an Order, add Garments to the Order, and place it for the Customer
        Order order = new Order("O001", new Date());
        order.addGarment(tshirt);
        order.addGarment(pants);

        customer.placeOrder(order);

        // Calculate and print the total amount of the order
        System.out.println("Order Total Amount: $" + order.calculateTotalAmount());

        // Print Order Details
        order.printOrderDetails();

        // View all orders placed by the customer
        System.out.println("Orders placed by " + customer.getName() + ":");
        for (Order o : customer.viewOrders()) {
            System.out.println("- Order ID: " + o.getOrderId() + ", Date: " + o.getOrderDate());
        }
    }
}
