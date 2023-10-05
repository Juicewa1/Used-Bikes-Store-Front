import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Class to represent the Bike Store
class Store {
    private BikeInventory inventory;
    private Scanner scanner;

    public Store() {
        inventory = new BikeInventory();
        scanner = new Scanner(System.in);
    }

    // Display the welcome message
    public void welcomeMessage() {
        System.out.println("Welcome to the Bike Store!");
    }

    // Display the current inventory
    private void displayInventory() {
        System.out.println("Current Inventory:");
        List<Bike> bikes = inventory.getAllBikes();
        for (int i = 0; i < bikes.size(); i++) {
            Bike bike = bikes.get(i);
            System.out.println((i + 1) + ". " + bike.getCategory() + ", " + bike.getBrand());
        }
    }

    // Main shopping process
    protected void shop() {
        List<Bike> bikes = inventory.getAllBikes();
        List<Bike> cart = new ArrayList<>();

        while (!bikes.isEmpty()) {
            displayInventory();
            System.out.println("\nEnter the number of the bike you want to buy (or -1 to exit):");
            int bikeNumber = scanner.nextInt();

            if (bikeNumber == -1) {
                break;
            }

            if (bikeNumber >= 1 && bikeNumber <= bikes.size()) {
                int selectedIndex = bikeNumber - 1;
                Bike selectedBike = bikes.get(selectedIndex);

                System.out.println("Selected Bike Details:");
                selectedBike.display();

                cart.add(selectedBike);
                inventory.removeBike(selectedIndex);

                System.out.println("Do you want to continue shopping (yes/no)?");
                String continueShopping = scanner.next().toLowerCase();

                if (continueShopping.equals("no")) {
                    checkout(cart);
                    return;
                }
            } else {
                System.out.println("Invalid bike number. Please enter a valid number.");
            }
        }

        if (cart.isEmpty()) {
            System.out.println("Thank you for visiting the Bike Store!");
        }
    }

    // Calculate and display the total price with tax and handle payment
    private void checkout(List<Bike> cart) {
        double totalPrice = cart.stream().mapToDouble(Bike::getBasePrice).sum();
        double taxAmount = totalPrice * 0.07;
        double totalAmount = totalPrice + taxAmount;

        System.out.println("Total Price with 7% Tax: $" + String.format("%.2f", totalAmount));

        double payment = 0;
        while (payment < totalAmount) {
            System.out.println("Enter the amount to pay: ");
            payment = scanner.nextDouble();
            if (payment < totalAmount) {
                System.out.println("Payment is less than the total price. Please enter a valid amount.");
            }
        }

        double change = payment - totalAmount;
        System.out.println("Change: $" + String.format("%.2f", change));

        System.out.println("\nItems Bought:");
        for (Bike bike : cart) {
            System.out.println(bike.getCategory() + ", " + bike.getBrand() + ", $" + String.format("%.2f", bike.getBasePrice()));
        }

        System.out.println("\nThank you for your patronage!");
    }

    // Main method to start the program
    public static void main(String[] args) {
        Store bikeStore = new Store();
        bikeStore.welcomeMessage();
        bikeStore.shop();
    }
}
