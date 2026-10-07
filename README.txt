ZOO SIMULATOR - JAVA OOP TERMINAL PROJECT

Animals:
- Sky the Capybara
- Stormy the Raccoon
- Star the Dolphin

Each animal has:
- Different starting health
- Different starting hunger
- Different food choices
- Different feeding effects

GAME RULE:
You may perform only ONE care task per game hour.
After a task, one hour passes and every animal becomes hungrier.

OOP CONCEPTS USED:

1. ABSTRACTION
Animal is an abstract class. It defines shared animal behavior while leaving
species-specific methods such as getSpecies(), getFoodOptions(), and eat()
to the subclasses.

2. INHERITANCE
Capybara, Raccoon, and Dolphin extend Animal.

3. ENCAPSULATION
Animal fields such as name, health, and hunger are private. They are accessed
through public getter methods and changed through protected helper methods.

4. POLYMORPHISM
The simulator stores Capybara, Raccoon, and Dolphin objects inside a
List<Animal>. Calling methods such as eat() uses the correct subclass behavior.

HOW TO COMPILE IN WINDOWS POWERSHELL:

javac Animal.java Capybara.java Raccoon.java Dolphin.java ZooSimulator.java

HOW TO RUN:

java ZooSimulator

