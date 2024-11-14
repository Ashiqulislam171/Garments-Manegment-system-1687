import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Fabric cotton = new Fabric("F001", "Cotton", "White", 10.0);
        Fabric polyester = new Fabric("F002", order"Polyester", "Blue", 8.5);


        Garment tshirt = new Garment("G001", "T-shirt", "Casual T-shirt", "M", "Red", 20.0, 50);
        Garment pants = new Garment("G002", "Pants", "Denim Jeans", "L", "Blue", 40.0, 30);


        Supplier supplier = new Supplier("S001", "ABC Textiles", "123-456-7890");
        supplier.addFabric(cotton);
        supplier.addFabric(polyester);


        System.out.println("Fabrics supplied by " + supplier.getName() + ":");
        for (Fabric fabric : supplier.getSuppliedFabrics()) {
            System.out.println("- " + fabric.getType() + " (" + fabric.getColor() + ")");
        }


        Inventory inventory = new Inventory();
        inventory.addGarment(tshirt);
        inventory.addGarment(pants);


        Garment foundGarment = inventory.findGarment("G001");
        if (foundGarment != null) {
            System.out.println("Found garment in inventory: " + foundGarment.getName() + " - $" + foundGarment.getPrice());
        }


        Customer customer = new Customer("C001", "John Doe", "johndoe@example.com", "555-1234");


        Order order = new Order("O001", new Date());
        order.addGarment(tshirt);
        order.addGarment(pants);

        customer.placeOrder(order);


        System.out.println("Order Total Amount: $" + order.calculateTotalAmount());


        order.printOrderDetails();


        System.out.println("Orders placed by " + customer.getName() + ":");
        for (Order o : customer.viewOrders()) {
            System.out.println("- Order ID: " + o.getOrderId() + ", Date: " + o.getOrderDate());
        }
    }
}
