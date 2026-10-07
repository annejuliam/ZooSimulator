import java.util.Arrays;
import java.util.List;

public class Dolphin extends Animal {

    public Dolphin(String name) {
        super(name, 110, 20);
    }

    @Override
    public String getSpecies() {
        return "Dolphin";
    }

    @Override
    public List<String> getFoodOptions() {
        return Arrays.asList("Fish", "Squid", "Shrimp");
    }

    @Override
    public void eat(String food) {
        switch (food.toLowerCase()) {
            case "fish" -> {
                changeHunger(-35);
                changeHealth(5);
                System.out.println("(^o^) " + getName() + " loved the fish!");
            }
            case "squid" -> {
                changeHunger(-30);
                changeHealth(4);
                System.out.println("(^_^) " + getName() + " happily ate the squid.");
            }
            case "shrimp" -> {
                changeHunger(-20);
                System.out.println("(>w<) Tiny shrimp, big happiness for " + getName() + "!");
            }
            default -> System.out.println("(o_o) " + getName() + " cannot eat that.");
        }
    }
}
