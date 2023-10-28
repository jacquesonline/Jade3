import java.util.ArrayList;

abstract class Meal implements FoodSpecification {

    ArrayList<PizzaToppings> toppingsArray = new ArrayList<>();

    public ArrayList<PizzaToppings> getToppings() {
        return toppingsArray;
    }

    public void setToppings(ArrayList<PizzaToppings> toppingsArray) {
        this.toppingsArray = toppingsArray;
    }

    public Meal() {
        // foodItemName = "unknown food";
        // basePrice = 0;
    }

    protected double basePrice;

    public Meal(String FoodItemName, double basePrice) {
        this.basePrice = 11.50;
    }

    @Override
    public double getCostOfMeal() {
        return basePrice;
    }

    @Override
    public abstract MealType getMealType();

}
