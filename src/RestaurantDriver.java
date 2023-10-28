import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantDriver {

    public static void main(String[] args) {

        ArrayList<OrderDetails> ordersArray = new ArrayList<>();
        
        Scanner reader = new Scanner(System.in);

        while (true) {

            System.out.println("");
            System.out.println("Taste of Tuscany's Take-Away Main Menu");
            System.out.println("----------------------------------------------------------");
            System.out.println("Please select and option: ");
            System.out.println("1 Make an order.");
            System.out.println("2 Deliver an order.");
            System.out.println("3 Display all items and customer details in the order.");
            System.out.println("4 Exit");
            System.out.println("Please Select 1-4 and press enter");

            int mainMenuSelectedNumber = reader.nextInt();

            if (mainMenuSelectedNumber == 1) {
                OrderDetails od = new OrderDetails();
                od.takingOrder(ordersArray);
                // takingOrders(ordersArray);
            } else if (mainMenuSelectedNumber == 2) {
                if (ordersArray.isEmpty()) {
                    System.out.println("No orders to deliver");
                } else {
                    System.out.println("Delivering order");
                    OrderDetails oldestOrder = ordersArray.get(0);
                    oldestOrder.printOrders(ordersArray);
                    ordersArray.remove(0);
                    System.out.println("Order delivered.");
                }
            } else if (mainMenuSelectedNumber == 3) {
                if (ordersArray.isEmpty()) {
                    System.out.println("No orders found");
                } else {
                    for (OrderDetails od : ordersArray) {
                        od.printOrders(ordersArray);
                    }
                }
            } else if (mainMenuSelectedNumber == 4) {
                System.out.println("Bye, thanks you for choosing Tuscany's Take-Away");
                System.exit(0);
            } else {
                System.out.println("That choice is invalid please select an option between 1 and 4");
            }
        }
    }

    public static void takingOrders(ArrayList<OrderDetails> ordersArray) {
        System.out.println(ordersArray);
    }
}