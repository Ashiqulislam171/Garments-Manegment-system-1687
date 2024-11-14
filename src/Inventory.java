import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Garment> garments;

    public Inventory() {
        this.garments = new ArrayList<>();
    }

    public void addGarment(Garment garment) {
        garments.add(garment);
    }

    public void removeGarment(String id) {
        garments.removeIf(garment -> garment.getId().equals(id));
    }

    public Garment findGarment(String id) {
        for (Garment garment : garments) {
            if (garment.getId().equals(id)) {
                return garment;
            }
        }
        return null;  // Return null if garment is not found
    }

    // Additional methods can be added here
}
