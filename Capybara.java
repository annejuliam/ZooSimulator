import java.util.Arrays;
import java.util.List;

public class Capybara extends Animal {

    public Capybara(String name) {
        super(name, 100, 30);
    }

    @Override
    public String getSpecies() {
        return "Capybara";
    }

    @Override
    public List<String> getFoodOptions() {
        return Arrays.asList("Watermelon", "Grass", "Carrots");
    }

    @Override
    public void eat(String food) {
        switch (food.toLowerCase()) {
            case "watermelon" -> {
                changeHunger(-30);
                changeHealth(5);
                System.out.println("(^o^) " + getName() + " loved the watermelon!");
            }
            case "grass" -> {
                changeHunger(-20);
                System.out.println("(^_^) " + getName() + " happily munched on grass.");
            }
            case "carrots" -> {
                changeHunger(-25);
                changeHealth(3);
                System.out.println("(>w<) Crunch crunch! " + getName() + " ate the carrots.");
            }
            default -> System.out.println("(o_o) " + getName() + " cannot eat that.");
        }
    }
}
