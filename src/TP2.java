import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TP2 {
    public static void main(String[] args) {
        System.out.println("dish de type vegetarian");
        List<String> myDishList= Exercice1.Dish.menu.stream().filter(Exercice1.Dish::isVegetarian).map(Exercice1.Dish::getName).toList();
        System.out.println("chi qst maert");
        List<Integer> numbers= Arrays.asList(1,2,3,6);
        int somme= numbers.stream().reduce(0,(a1,a2)->a1*a2);
        System.out.println(somme);
        int somme2= numbers.stream().reduce(numbers.get(0),(a1,a2)->Math.max(a1,a2));
        System.out.println(somme2);
        

    }
}
