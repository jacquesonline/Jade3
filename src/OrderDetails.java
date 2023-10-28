import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// import Pasta.pastaToppings;

class OrderDetails {

    private String customerName;
    private String customerContactNumber;
    private String customerDeliveryAddress;
    private ArrayList<Meal> foodOrderedArray;

    public OrderDetails() {
        // customerName = "Unknown name";
        // customerContactNumber = "0";
        // customerDeliveryAddress = "Unknown address";
        // foodOrderedArray = new ArrayList<>();
        //
    }

    public OrderDetails(String customerName, String customerContactNumber, String customerDeliveryAddress,
            ArrayList<Meal> foodOrderedArray) {
        // this.customerName = customerName;
        // this.customerContactNumber = customerContactNumber;
        // this.customerDeliveryAddress = customerDeliveryAddress;
        // this.foodOrderedArray = foodOrderedArray;
        // calculateTotalCost();
    }

    public void addMealItems(OrderDetails topping) {

    }

    public ArrayList<Meal> getMealOrderedArray() {
        return foodOrderedArray;
    }

    private void calculateTotalCost() {

    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public String getCustomerContactNumber() {
        return customerContactNumber;
    }

    public void setCustomerNumber(String contactNumber) {
        this.customerContactNumber = contactNumber;
    }

    public String getCustomerDeliveryAddress() {
        return customerDeliveryAddress;
    }

    public void setCustomerDeliveryAddress(String deliveryAddress) {
        this.customerDeliveryAddress = deliveryAddress;
    }

    public void setFoodOrderedArray(FoodSpecification foodSpecification) {
        foodSpecification.add(foodSpecification);
    }

    public void printOrders(ArrayList<OrderDetails> ordersArray) {
        System.out.println("Order Summary");
        System.out.println("Customer Name:" + getCustomerName());
        System.out.println("Customer Number:" + getCustomerContactNumber());
        System.out.println("Customer Delivery Address:" + getCustomerDeliveryAddress());
        // System.out.println("Your order come to a total cost of:" + getCost); // Todo
        // fix get cost of meal
        // System.out.println("Your meal contains:" + getMealType());
    }

    public void takingOrder(ArrayList<OrderDetails> ordersArray) {

        boolean customerDetailCaptured = false;

        while (true) {

            Scanner orderReader = new Scanner(System.in);
            Scanner foodItemReader = new Scanner(System.in);

            if (customerDetailCaptured == false) {

                customerDetailCaptured = true;
                System.out.println("Please enter your name:");
                setCustomerName(orderReader.nextLine());
                System.out.println("Please enter your contact number:");
                setCustomerNumber(orderReader.nextLine());
                System.out.println("Please enter your delivery address:");
                setCustomerDeliveryAddress(orderReader.nextLine());
            }

            System.out.println("What would you like to order?");
            System.out.println("1. Add Pizza to your order.");
            System.out.println("2. Add Pasta to your order.");
            System.out.println("3. Return to main menu.");
            System.out.println("Please select an option and press enter");
            int orderDetailsSelection = orderReader.nextInt();

            if (orderDetailsSelection == 1) {
                System.out.println("Great Choice! You want to order a pizza!");
                System.out.println("Please choose from the following toppings:");
                for (PizzaToppings toppingOnPizza : PizzaToppings.values()) {
                    System.out.println(toppingOnPizza);
                }
                System.out.println(
                        "Please enter toppings with a comma separating them, press enter once for no additional toppings");
                // ArrayList<Pizza> pizza = new ArrayList<>();
                String[] pizzaArray = new String[] {
                        Arrays.toString(foodItemReader.nextLine().split(",")) };
                for (String topping : pizzaArray) {
                    System.out.println("You have ordered a Pizza with: " + topping);
                }

            } else if (orderDetailsSelection == 2) {
                System.out.println("Nice, Pasta it is");
                System.out.println("Please choose from the following pasta toppings:");
                for (Pasta.pastaToppings toppingOnPasta : Pasta.pastaToppings.values()) {
                    System.out.println(toppingOnPasta);
                }
                System.out.println("Please enter one topping only, press enter once for no additional topping");
                String[] pastaArray = new String[] { foodItemReader.nextLine() };
                for (String toppingOnPasta : pastaArray) {
                    System.out.println("You chose" + " " + toppingOnPasta + " " + "as your pasta topping!");
                    // System.out.println("You have ordered Pasta with:" + toppingOnPasta + "Your
                    // meal costs"); // + "Your
                    // meal
                    // type
                    // is:" +
                    // );
                }
            } else if (orderDetailsSelection != 3) {
                System.out.println("That choice is invalid please select an option between 1 and 3");
            }
        }
    }

}
