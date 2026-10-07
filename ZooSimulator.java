import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZooSimulator {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Animal> animals = new ArrayList<>();

    private static int day = 1;
    private static int hour = 8;

    public static void main(String[] args) {
        animals.add(new Capybara("Sky"));
        animals.add(new Raccoon("Stormy"));
        animals.add(new Dolphin("Star"));

        showWelcome();

        boolean running = true;

        while (running) {
            if (allAnimalsUnhealthy()) {
                System.out.println("(T_T) The animals need better care. Game over.");
                break;
            }

            showTime();
            System.out.println("You may do ONE task this hour. (^_^)");
            System.out.println("1. Care for an animal");
            System.out.println("2. View zoo status");
            System.out.println("3. Quit game");
            System.out.print("Choose an option: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> {
                    careForAnimal();
                    advanceHour();
                }
                case 2 -> showAllStatus();
                case 3 -> {
                    System.out.println("(^_^)/ Thanks for visiting the zoo!");
                    running = false;
                }
                default -> System.out.println("(o_o) Please choose 1, 2, or 3.");
            }
        }
    }

    private static void careForAnimal() {
        System.out.println("\nWhich animal would you like to care for?");
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            System.out.println((i + 1) + ". " + animal.getName() + " the " + animal.getSpecies());
        }

        System.out.print("Choose an animal: ");
        int animalChoice = readInt();

        if (animalChoice < 1 || animalChoice > animals.size()) {
            System.out.println("(o_o) Invalid animal choice.");
            return;
        }

        Animal animal = animals.get(animalChoice - 1);

        if (!animal.isAlive()) {
            System.out.println("(T_T) " + animal.getName() + " is too unhealthy to care for.");
            return;
        }

        System.out.println("\nWhat would you like to do with " + animal.getName() + "?");
        System.out.println("1. Feed");
        System.out.println("2. Play");
        System.out.println("3. Rest");
        System.out.print("Choose a task: ");

        int task = readInt();

        switch (task) {
            case 1 -> feedAnimal(animal);
            case 2 -> animal.play();
            case 3 -> animal.rest();
            default -> System.out.println("(o_o) Invalid task.");
        }
    }

    private static void feedAnimal(Animal animal) {
        List<String> foods = animal.getFoodOptions();

        System.out.println("\nFood options for " + animal.getName() + ":");
        for (int i = 0; i < foods.size(); i++) {
            System.out.println((i + 1) + ". " + foods.get(i));
        }

        System.out.print("Choose food: ");
        int foodChoice = readInt();

        if (foodChoice < 1 || foodChoice > foods.size()) {
            System.out.println("(o_o) Invalid food choice.");
            return;
        }

        animal.eat(foods.get(foodChoice - 1));
    }

    private static void showAllStatus() {
        System.out.println("\n========== ZOO STATUS ==========");
        for (Animal animal : animals) {
            animal.showStatus();
        }
    }

    private static void advanceHour() {
        for (Animal animal : animals) {
            animal.passHour();
        }

        hour++;

        if (hour >= 20) {
            System.out.println("\n(-_-) zZz The zoo is closing for the night...");
            day++;
            hour = 8;
        }

        System.out.println("One hour has passed. Next time: " + formatHour());
    }

    private static boolean allAnimalsUnhealthy() {
        for (Animal animal : animals) {
            if (animal.isAlive()) {
                return false;
            }
        }
        return true;
    }

    private static void showWelcome() {
        System.out.println("+==================================+");
        System.out.println("          ZOO SIMULATOR");
        System.out.println("             (^_^)");
        System.out.println("+==================================+");
        System.out.println("Take care of Sky, Stormy, and Star!");
        System.out.println();
    }

    private static void showTime() {
        System.out.println("\n+----------------------------------+");
        System.out.println("  Day " + day + " | " + formatHour());
        System.out.println("+----------------------------------+");
    }

    private static String formatHour() {
        String period = hour >= 12 ? "PM" : "AM";
        int displayHour = hour % 12;
        if (displayHour == 0) displayHour = 12;
        return displayHour + ":00 " + period;
    }

    private static int readInt() {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.print("Please enter a number: ");
        }

        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}
