import java.util.*;
import java.util.stream.Collectors;

// Define an interface for items that have a price and meal type.
interface FoodItem {
    double getPrice();
    String getMealType();
}

// Define an enum for pizza toppings.
enum PizzaTopping {
    HAM(2.0), CHEESE(2.0), PINEAPPLE(2.5), MUSHROOMS(2.0), TOMATO(2.0), SEAFOOD(3.5);

    private double price;

    PizzaTopping(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

// Define an enum for pasta toppings.
enum PastaTopping {
    BOLOGNESE(5.20), MARINARA(6.80), PRIMAVERA(0.0), TOMATO(4.0);

    private double price;

    PastaTopping(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

// Define an abstract class for food items (pizza and pasta).
abstract class FoodOrder implements FoodItem {
    List<String> toppings = new ArrayList<>();

    public List<String> getToppings() {
        return toppings;
    }

    public double calculateToppingsPrice() {
        return toppings.stream().mapToDouble(this::getToppingPrice).sum();
    }

    public String getMealType() {
        if (toppings.stream().anyMatch(t -> PizzaTopping.valueOf(t) == PizzaTopping.HAM || PizzaTopping.valueOf(t) == PizzaTopping.SEAFOOD)) {
            return "meat";
        } else if (toppings.stream().anyMatch(t -> PizzaTopping.valueOf(t) == PizzaTopping.CHEESE)) {
            return "vegetarian";
        } else {
            return "vegan";
        }
    }

    abstract double getBasePrice();
    abstract double getToppingPrice(String topping);
}

// Define a class for pizza.
class PizzaOrder extends FoodOrder {
    PizzaOrder(List<String> toppings) {
        this.toppings = toppings;
    }

    @Override
    public double getPrice() {
        return getBasePrice() + calculateToppingsPrice();
    }

    @Override
    public double getBasePrice() {
        return 11.50;
    }

    @Override
    double getToppingPrice(String topping) {
        return PizzaTopping.valueOf(topping).getPrice();
    }
}

// Define a class for pasta.
class PastaOrder extends FoodOrder {
    PastaOrder(List<String> toppings) {
        this.toppings = toppings;
    }

    @Override
    public double getPrice() {
        return getBasePrice() + calculateToppingsPrice();
    }

    @Override
    public double getBasePrice() {
        return 11.50;
    }

    @Override
    double getToppingPrice(String topping) {
        return PastaTopping.valueOf(topping).getPrice();
    }
}

// Define a class for customer orders.
class CustomerOrder {
    private List<FoodItem> foodItems = new ArrayList<>();
    private String customerName;
    private String contactNumber;
    private String deliveryAddress;

    public void addFoodItem(FoodItem foodItem) {
        foodItems.add(foodItem);
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public double getTotalCost() {
        return foodItems.stream().mapToDouble(FoodItem::getPrice).sum();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}

public class Restaurant {
    public static void main(String[] args) {
        List<CustomerOrder> orders = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Restaurant Takeaway Order Management System");
            System.out.println("1. Enter the details of a customer order");
            System.out.println("2. Deliver an order");
            System.out.println("3. Print details of all orders");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Create a new order
                    CustomerOrder order = new CustomerOrder();
                    System.out.print("Enter customer name: ");
                    order.setCustomerName(scanner.next());
                    System.out.print("Enter contact number: ");
                    order.setContactNumber(scanner.next());
                    System.out.print("Enter delivery address: ");
                    order.setDeliveryAddress(scanner.next());

                    // Enter food items
                    int foodOption;
                    do {
                        System.out.println("Select a food item:");
                        System.out.println("1. Pizza");
                        System.out.println("2. Pasta");
                        System.out.println("3. Finish order entry");
                        System.out.print("Enter your choice: ");
                        foodOption = scanner.nextInt();

                        if (foodOption == 1) {
                            List<String> pizzaToppings = new ArrayList<>();
                            int pizzaToppingOption;
                            do {
                                System.out.println("Select pizza toppings:");
                                for (PizzaTopping topping : PizzaTopping.values()) {
                                    System.out.println(topping.name());
                                }
                                System.out.println("0. Finish pizza selection");
                                System.out.print("Enter your choice: ");
                                pizzaToppingOption = scanner.nextInt();
                                if (pizzaToppingOption > 0 && pizzaToppingOption <= PizzaTopping.values().length) {
                                    pizzaToppings.add(PizzaTopping.values()[pizzaToppingOption - 1].name());
                                }
                            } while (pizzaToppingOption != 0);

                            order.addFoodItem(new PizzaOrder(pizzaToppings));
                        } else if (foodOption == 2) {
                            List<String> pastaToppings = new ArrayList<>();
                            int pastaToppingOption;
                            do {
                                System.out.println("Select pasta toppings:");
                                for (PastaTopping topping : PastaTopping.values()) {
                                    System.out.println(topping.name());
                                }
                                System.out.println("0. Finish pasta selection");
                                System.out.print("Enter your choice: ");
                                pastaToppingOption = scanner.nextInt();
                                if (pastaToppingOption > 0 && pastaToppingOption <= PastaTopping.values().length) {
                                    pastaToppings.add(PastaTopping.values()[pastaToppingOption - 1].name());
                                }
                            } while (pastaToppingOption != 0);

                            order.addFoodItem(new PastaOrder(pastaToppings));
                        }
                    } while (foodOption != 3);

                    orders.add(order);
                    break;

                case 2:
                    // Deliver an order (the oldest order)
                    if (!orders.isEmpty()) {
                        CustomerOrder oldestOrder = orders.get(0);
                        System.out.println("Delivering Order:");
                        System.out.println("Customer Name: " + oldestOrder.getCustomerName());
                        System.out.println("Contact Number: " + oldestOrder.getContactNumber());
                        System.out.println("Delivery Address: " + oldestOrder.getDeliveryAddress());
                        System.out.println("Total Cost: $" + oldestOrder.getTotalCost());
                        System.out.println("Meal Type: " + getMealType(oldestOrder.getFoodItems()));
                        orders.remove(0);
                    } else {
                        System.out.println("No orders to deliver.");
                    }
                    break;

                case 3:
                    // Print details of all orders
                    if (!orders.isEmpty()) {
                        System.out.println("All Orders:");
                        for (int i = 0; i < orders.size(); i++) {
                            System.out.println("Order " + (i + 1));
                            System.out.println("Customer Name: " + orders.get(i).getCustomerName());
                            System.out.println("Contact Number: " + orders.get(i).getContactNumber());
                            System.out.println("Delivery Address: " + orders.get(i).getDeliveryAddress());
                            System.out.println("Total Cost: $" + orders.get(i).getTotalCost());
                            System.out.println("Meal Type: " + getMealType(orders.get(i).getFoodItems()));
                            System.out.println();
                        }
                    } else {
                        System.out.println("No orders to display.");
                    }
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);
    }

    private static String getMealType(List<FoodItem> foodItems) {
        boolean hasMeat = false;
        boolean hasVegetarian = false;
        boolean hasVegan = true;

        for (FoodItem item : foodItems) {
            if (item.getMealType().equals("meat")) {
                hasMeat = true;
            } else if (item.getMealType().equals("vegetarian")) {
                hasVegetarian = true;
            } else if (!item.getMealType().equals("vegan")) {
                hasVegan = false;
            }
        }

        if (hasMeat) {
            return "meat";
        } else if (hasVegetarian) {
            return "vegetarian";
        } else if (hasVegan) {
            return "vegan";
        } else {
            return "unknown";
        }
    }
}
