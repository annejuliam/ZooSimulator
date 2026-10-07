import java.util.List;

public abstract class Animal {
    private String name;
    private int health;
    private int hunger;
    private int maxHealth;

    public Animal(String name, int health, int hunger) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.hunger = hunger;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getHunger() {
        return hunger;
    }

    public abstract String getSpecies();
    public abstract List<String> getFoodOptions();
    public abstract void eat(String food);

    protected void changeHunger(int amount) {
        hunger += amount;
        if (hunger < 0) hunger = 0;
        if (hunger > 100) hunger = 100;
    }

    protected void changeHealth(int amount) {
        health += amount;
        if (health > maxHealth) health = maxHealth;
        if (health < 0) health = 0;
    }

    public void play() {
        changeHealth(5);
        changeHunger(8);
        System.out.println("(^_^) " + name + " had fun playing!");
    }

    public void rest() {
        changeHealth(10);
        changeHunger(5);
        System.out.println("(-_-) zZz " + name + " took a cozy nap.");
    }

    public void passHour() {
        changeHunger(7);

        if (hunger >= 80) {
            changeHealth(-10);
        } else if (hunger >= 60) {
            changeHealth(-5);
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void showStatus() {
        System.out.println("----------------------------------");
        System.out.println(name + " the " + getSpecies());
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("Hunger: " + hunger + "/100");
        System.out.println("----------------------------------");
    }
}
