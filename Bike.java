// Class to represent a Bike
class Bike {
    protected BikeCategory category;
    protected String brand;
    protected double basePrice;

    public Bike(BikeCategory category, String brand, double basePrice) {
        this.category = category;
        this.brand = brand;
        this.basePrice = basePrice;
    }

    public BikeCategory getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void display() {
        System.out.println("Category: " + category);
        System.out.println("Brand: " + brand);
        System.out.println("Base Price: $" + String.format("%.2f", basePrice));
    }
}
