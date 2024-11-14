import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private String orderId;
    private Date orderDate;
    private List<Garment> garments;
    private double totalAmount;

    public Order(String orderId, Date orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.garments = new ArrayList<>();
        this.totalAmount = 0;
    }

    public void addGarment(Garment garment) {
        garments.add(garment);
        totalAmount += garment.calculateDiscountPrice(0);  // Assuming no discount
    }

    public double calculateTotalAmount() {
        totalAmount = 0;
        for (Garment garment : garments) {
            totalAmount += garment.calculateDiscountPrice(0);  // Assuming no discount
        }
        return totalAmount;
    }

    public void printOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Garments in Order:");
        for (Garment garment : garments) {
            System.out.println("- " + garment.getName() + " (" + garment.getSize() + ", " + garment.getColor() + ")");
        }
        System.out.println("Total Amount: $" + calculateTotalAmount());
    }

    // Getters and setters can be added here
}
