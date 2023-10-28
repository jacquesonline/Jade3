import java.util.ArrayList;

class Pizza extends Meal {

    Pizza(ArrayList<PizzaToppings> toppingsArray) {
        this.toppingsArray = toppingsArray;
    }

    @Override
    public double getCostOfMeal() {
        basePrice = super.getCostOfMeal();
        for (PizzaToppings toppingOnPizza : toppingsArray)
        {
           if (toppingOnPizza.equals(PizzaToppings.SEAFOOD))
            {
                basePrice += 3.50;
            }
            else if (toppingOnPizza.equals(PizzaToppings.PINEAPPLE))
            {
                basePrice += 2.50;
            }
            else
            {
                basePrice += 2.00;
            }
        }
        return basePrice;
    }

    @Override
    public MealType getMealType()
    {
        if (toppingsArray.contains(PizzaToppings.HAM) || toppingsArray.contains(PizzaToppings.SEAFOOD)) {
            return MealType.MEAT;
        } else if (toppingsArray.contains(PizzaToppings.CHEESE)) {
            return MealType.VEGETARIAN;
        } else {
            return MealType.VEGAN;
        }
    }
}








