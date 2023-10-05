import java.util.ArrayList;
import java.util.List;

// Class to represent the Bike Inventory
class BikeInventory {
    private List<Bike> bikes;

    public BikeInventory() {
        bikes = new ArrayList<>();
        initializeInventory();
    }

    // Initialize the bike inventory with different categories, brands, and base prices
    private void initializeInventory() {
        bikes.add(new Bike(BikeCategory.ROAD_BIKE, "Huffy", 299.99));
        bikes.add(new Bike(BikeCategory.ROAD_BIKE, "Schwinn", 349.99));
        bikes.add(new Bike(BikeCategory.MOUNTAIN_BIKE, "Santa Cruz", 799.99));
        bikes.add(new Bike(BikeCategory.MOUNTAIN_BIKE, "Maxxis", 699.99));
        bikes.add(new Bike(BikeCategory.ELECTRIC_BIKE, "POC", 1999.99));
        bikes.add(new Bike(BikeCategory.ELECTRIC_BIKE, "POC", 2199.99));
        bikes.add(new Bike(BikeCategory.BMX_BIKE, "Huffy", 199.99));
        bikes.add(new Bike(BikeCategory.BMX_BIKE, "Schwinn", 249.99));
        bikes.add(new Bike(BikeCategory.CRUISER_BIKE, "Huffy", 349.99));
        bikes.add(new Bike(BikeCategory.CRUISER_BIKE, "Schwinn", 399.99));
    }

    // Get the list of all bikes in the inventory
    public List<Bike> getAllBikes() {
        return bikes;
    }

    // Remove a bike from the inventory based on its index
    public void removeBike(int index) {
        bikes.remove(index);
    }
}
