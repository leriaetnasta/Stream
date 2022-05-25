import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class Exercice1 {
    public static class Dish {

        private final String name;
        private final boolean vegetarian;
        private final int calories;
        private final Type type;

        public Dish(String name, boolean vegetarian, int calories, Type type) {
            this.name = name;
            this.vegetarian = vegetarian;
            this.calories = calories;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public boolean isVegetarian() {
            return vegetarian;
        }

        public int getCalories() {
            return calories;
        }

        public Type getType() {
            return type;
        }

        public enum Type {
            MEAT,
            FISH,
            OTHER
        }

        @Override
        public String toString() {
            return name;
        }

        public static final List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 400, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );
        public static List<String> getLowCaloricDishesNames (List<Dish> dishes) {
            List<Dish> lowCaloricDishes = new ArrayList<>();
            for (Dish d : dishes) {
                if (d.getCalories() < 400) {
                    lowCaloricDishes.add(d);
                }
            }
            List<String> lowCaloricDishesName = new ArrayList<>();
            Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
                @Override
                public int compare(Dish d1, Dish d2) {
                    return Integer.compare(d1.getCalories(), d2.getCalories());
                }
            });
            for (Dish d : lowCaloricDishes) {
                lowCaloricDishesName.add(d.getName());
            }
            return lowCaloricDishesName;
        }
        public static  List<String> getLowCaloricDishesNames2 (List<Dish> dishes) {
            List<String> myDishStream= dishes.stream().filter(d->d.getCalories()<400)
                    .sorted(comparing(Dish::getCalories)).map(d->d.getName()).toList();
            return myDishStream;

        }

        public static void main(String[] args) {
            System.out.println(getLowCaloricDishesNames2(menu));

        }


    }
}
