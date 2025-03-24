import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KantoPokedex {
    private static Map<Integer, Pokemon> pokemonDatabase = new HashMap<>();

    public static void main(String[] args) {
        initializePokedex();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Kanto Pokédex!");
        System.out.println("Featuring the original 151 Pokémon from Generation 1.");
        
        boolean running = true;
        while (running) {
            System.out.print("\nEnter a Pokémon number (1-151) or 0 to exit: ");
            
            try {
                int pokemonNumber = scanner.nextInt();
                
                if (pokemonNumber == 0) {
                    running = false;
                    System.out.println("Thank you for using the Pokédex!");
                } else if (pokemonNumber < 1 || pokemonNumber > 151) {
                    System.out.println("Invalid Pokémon number. Please enter a number between 1 and 151.");
                } else {
                    displayPokemonInfo(pokemonNumber);
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
        
        scanner.close();
    }
    
    private static void displayPokemonInfo(int pokemonNumber) {
        Pokemon pokemon = pokemonDatabase.get(pokemonNumber);
        
        if (pokemon != null) {
            System.out.println("\n===== POKÉMON #" + pokemonNumber + " =====");
            System.out.println("Name: " + pokemon.getName());
            System.out.println("Type: " + String.join("/", pokemon.getTypes()));
            System.out.println("Height: " + pokemon.getHeight() + " m");
            System.out.println("Weight: " + pokemon.getWeight() + " kg");
            System.out.println("Description: " + pokemon.getDescription());
            System.out.println("=======================");
        } else {
            System.out.println("Pokémon #" + pokemonNumber + " data not available.");
        }
    }
    
    private static void initializePokedex() {
        // This method populates the database with Gen 1 Pokémon info
        
        // Bulbasaur evolution line
        pokemonDatabase.put(1, new Pokemon("Bulbasaur", new String[]{"Grass", "Poison"}, 0.7, 6.9, 
                "A strange seed was planted on its back at birth. The plant sprouts and grows with this Pokémon."));
        pokemonDatabase.put(2, new Pokemon("Ivysaur", new String[]{"Grass", "Poison"}, 1.0, 13.0, 
                "When the bulb on its back grows large, it appears to lose the ability to stand on its hind legs."));
        pokemonDatabase.put(3, new Pokemon("Venusaur", new String[]{"Grass", "Poison"}, 2.0, 100.0, 
                "The plant blooms when it is absorbing solar energy. It stays on the move to seek sunlight."));
        
        // Charmander evolution line
        pokemonDatabase.put(4, new Pokemon("Charmander", new String[]{"Fire"}, 0.6, 8.5, 
                "From the time it is born, a flame burns at the tip of its tail. Its life would end if the flame were to go out."));
        pokemonDatabase.put(5, new Pokemon("Charmeleon", new String[]{"Fire"}, 1.1, 19.0, 
                "When it swings its burning tail, it elevates the temperature to unbearably high levels."));
        pokemonDatabase.put(6, new Pokemon("Charizard", new String[]{"Fire", "Flying"}, 1.7, 90.5, 
                "Spits fire that is hot enough to melt boulders. Known to cause forest fires unintentionally."));
        
        // Squirtle evolution line
        pokemonDatabase.put(7, new Pokemon("Squirtle", new String[]{"Water"}, 0.5, 9.0, 
                "When it retracts its long neck into its shell, it squirts out water with vigorous force."));
        pokemonDatabase.put(8, new Pokemon("Wartortle", new String[]{"Water"}, 1.0, 22.5, 
                "It is recognized as a symbol of longevity. If its shell has algae on it, that Wartortle is very old."));
        pokemonDatabase.put(9, new Pokemon("Blastoise", new String[]{"Water"}, 1.6, 85.5, 
                "It crushes its foe under its heavy body to cause fainting. In a pinch, it will withdraw inside its shell."));
        
        // Caterpie evolution line
        pokemonDatabase.put(10, new Pokemon("Caterpie", new String[]{"Bug"}, 0.3, 2.9, 
                "Its short feet are tipped with suction pads that enable it to tirelessly climb slopes and walls."));
        pokemonDatabase.put(11, new Pokemon("Metapod", new String[]{"Bug"}, 0.7, 9.9, 
                "This Pokémon is vulnerable to attack while its shell is soft, exposing its weak and tender body."));
        pokemonDatabase.put(12, new Pokemon("Butterfree", new String[]{"Bug", "Flying"}, 1.1, 32.0, 
                "In battle, it flaps its wings at great speed to release highly toxic dust into the air."));
        
        // Weedle evolution line
        pokemonDatabase.put(13, new Pokemon("Weedle", new String[]{"Bug", "Poison"}, 0.3, 3.2, 
                "Often found in forests, eating leaves. It has a sharp venomous stinger on its head."));
        pokemonDatabase.put(14, new Pokemon("Kakuna", new String[]{"Bug", "Poison"}, 0.6, 10.0, 
                "Almost incapable of moving, this Pokémon can only harden its shell to protect itself."));
        pokemonDatabase.put(15, new Pokemon("Beedrill", new String[]{"Bug", "Poison"}, 1.0, 29.5, 
                "It has three poisonous stingers on its forelegs and its tail. They are used to jab its enemy repeatedly."));
        
        // Pidgey evolution line
        pokemonDatabase.put(16, new Pokemon("Pidgey", new String[]{"Normal", "Flying"}, 0.3, 1.8, 
                "A common sight in forests and woods. It flaps its wings at ground level to kick up blinding sand."));
        pokemonDatabase.put(17, new Pokemon("Pidgeotto", new String[]{"Normal", "Flying"}, 1.1, 30.0, 
                "Very protective of its sprawling territorial area, this Pokémon will fiercely peck at any intruder."));
        pokemonDatabase.put(18, new Pokemon("Pidgeot", new String[]{"Normal", "Flying"}, 1.5, 39.5, 
                "This Pokémon has a dazzling plumage of beautifully glossy feathers. Many Trainers are captivated by the striking beauty of the feathers on its head, compelling them to choose Pidgeot as their Pokémon."));
        
        // Rattata evolution line
        pokemonDatabase.put(19, new Pokemon("Rattata", new String[]{"Normal"}, 0.3, 3.5, 
                "Will chew on anything with its fangs. If you see one, it is certain that 40 more live in the area."));
        pokemonDatabase.put(20, new Pokemon("Raticate", new String[]{"Normal"}, 0.7, 18.5, 
                "Its hind feet are webbed. They act as flippers, so it can swim in rivers and hunt for prey."));
        
        // Spearow evolution line
        pokemonDatabase.put(21, new Pokemon("Spearow", new String[]{"Normal", "Flying"}, 0.3, 2.0, 
                "Eats bugs in grassy areas. It has to flap its short wings at high speed to stay airborne."));
        pokemonDatabase.put(22, new Pokemon("Fearow", new String[]{"Normal", "Flying"}, 1.2, 38.0, 
                "With its huge and magnificent wings, it can keep aloft without ever having to land for rest."));
        
        // Ekans evolution line
        pokemonDatabase.put(23, new Pokemon("Ekans", new String[]{"Poison"}, 2.0, 6.9, 
                "Moves silently and stealthily. Eats the eggs of birds, such as Pidgey and Spearow, whole."));
        pokemonDatabase.put(24, new Pokemon("Arbok", new String[]{"Poison"}, 3.5, 65.0, 
                "The frightening patterns on its belly have been studied. Six variations have been confirmed."));
        
        // Pikachu evolution line
        pokemonDatabase.put(25, new Pokemon("Pikachu", new String[]{"Electric"}, 0.4, 6.0, 
                "When several of these Pokémon gather, their electricity could build and cause lightning storms."));
        pokemonDatabase.put(26, new Pokemon("Raichu", new String[]{"Electric"}, 0.8, 30.0, 
                "Its long tail serves as a ground to protect itself from its own high-voltage power."));
        
        // Adding more popular Gen 1 Pokemon
        pokemonDatabase.put(143, new Pokemon("Snorlax", new String[]{"Normal"}, 2.1, 460.0, 
                "Very lazy. Just eats and sleeps. As its rotund bulk builds, it becomes steadily more slothful."));
        
        pokemonDatabase.put(144, new Pokemon("Articuno", new String[]{"Ice", "Flying"}, 1.7, 55.4, 
                "A legendary bird Pokémon that can control ice. The flapping of its wings chills the air. As a result, it is said that when this Pokémon flies, snow will fall."));
        
        pokemonDatabase.put(145, new Pokemon("Zapdos", new String[]{"Electric", "Flying"}, 1.6, 52.6, 
                "A legendary bird Pokémon that has the ability to control electricity. It usually lives in thunderclouds. The Pokémon gains power if it is stricken by lightning bolts."));
        
        pokemonDatabase.put(146, new Pokemon("Moltres", new String[]{"Fire", "Flying"}, 2.0, 60.0, 
                "A legendary bird Pokémon that can control fire. If this Pokémon is injured, it is said to dip its body in the molten magma of a volcano to burn and heal itself."));
        
        pokemonDatabase.put(150, new Pokemon("Mewtwo", new String[]{"Psychic"}, 2.0, 122.0, 
                "A Pokémon that was created by genetic manipulation. However, even though the scientific power of humans created this Pokémon's body, they failed to endow Mewtwo with a compassionate heart."));
        
        pokemonDatabase.put(151, new Pokemon("Mew", new String[]{"Psychic"}, 0.4, 4.0, 
                "When viewed through a microscope, this Pokémon's short, fine, delicate hair can be seen."));
        
        // Note: In a complete implementation, add entries for all 151 Pokémon
    }
}

class Pokemon {
    private String name;
    private String[] types;
    private double height; // in meters
    private double weight; // in kg
    private String description;
    
    public Pokemon(String name, String[] types, double height, double weight, String description) {
        this.name = name;
        this.types = types;
        this.height = height;
        this.weight = weight;
        this.description = description;
    }
    
    public String getName() {
        return name;
    }
    
    public String[] getTypes() {
        return types;
    }
    
    public double getHeight() {
        return height;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public String getDescription() {
        return description;
    }
}
