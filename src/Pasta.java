import java.util.ArrayList;

class Pasta extends Meal {
    private ArrayList<String> pastaArray;
    private Pasta toppingsOnPasta;



    enum pastaToppings {
        BOLOGNESE,
        TOMATO,
        PRIMAVERA,
        MARINARA
    }

    public Pasta() {
        super();

    }

    // @Override
    // public double calculateMealCost() {
    //     double basePrice = 11.50;

    //     for (String toppingOnPasta : pastaArray)
    //     {
    //         if (toppingsOnPasta.equals(Pasta.pastaToppings.BOLOGNESE))
    //         {
    //             basePrice += 4.00;
    //         }
    //         else if (toppingsOnPasta.equals(pastaToppings.TOMATO))
    //         {
    //             basePrice += 4.00;
    //         }
    //         else if (toppingsOnPasta.equals(pastaToppings.PRIMAVERA))
    //         {
    //             basePrice += 5.20;
    //         }
    //         else if (toppingsOnPasta.equals(pastaToppings.MARINARA))
    //         {
    //             basePrice += 6.80;
    //         }
    //     }
    //     return basePrice;
    // }

    // @Override
    // public MealType findMealType() {
    //     if (pastaArray.contains(pastaToppings.BOLOGNESE) || pastaArray.contains(pastaToppings.MARINARA)) {
    //         setMealType(MealType.MEAT);
    //         return MealType.MEAT;
    //     } else if (pastaArray.contains(pastaToppings.PRIMAVERA)) {
    //         setMealType(MealType.VEGETARIAN);
    //         return MealType.VEGETARIAN;
    //     } else {
    //         setMealType(MealType.VEGAN);
    //         return MealType.VEGAN;
    //     }
    // }

    // public Pasta(String foodItem, double basePrice, Pasta toppingsOnPasta) {
    //     super(foodItem, basePrice);
    //     this.toppingsOnPasta = toppingsOnPasta;
    // }

    @Override
    public MealType getMealType() {
        return getMealType();
    }

    @Override
    public double getCostOfMeal() {
        return getCostOfMeal();
    }

}




