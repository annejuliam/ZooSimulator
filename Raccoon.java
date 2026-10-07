import java.util.Arrays;
import java.util.List;

public class Raccoon extends Animal {

    public Raccoon(String name) {
        super(name, 85, 45);
    }

    @Override
    public String getSpecies() {
        return "Raccoon";
    }

    @Override
    public List<String> getFoodOptions() {
        return Arrays.asList("Berries", "Eggs", "Apple");
    }

    @Override
    public void eat(String food) {
        switch (food.toLowerCase()) {
            case "berries" -> {
                changeHunger(-25);
                changeHealth(3);
                System.out.println("(^_^) " + getName() + " ate all the berries.");
            }
            case "eggs" -> {
                changeHunger(-35);
                changeHealth(5);
                System.out.println("(>w<) " + getName() + " enjoyed the eggs!");
            }
            case "apple" -> {
                changeHunger(-20);
                System.out.println("(^o^) " + getName() + " crunched on an apple.");
            }
            default -> System.out.println("(o_o) " + getName() + " cannot eat that.");
        }
    }
}
