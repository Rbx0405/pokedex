import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KalosPokedex {
    private static Map<Integer, Pokemon> pokemonDatabase = new HashMap<>();

    public static void main(String[] args) {
        initializePokedex();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Kalos Pokédex!");
        System.out.println("Featuring 72 new Pokémon from Generation 6.");
        
        boolean running = true;
        while (running) {
            System.out.print("\nEnter a Pokémon number (650-721) or 0 to exit: ");
            
            try {
                int pokemonNumber = scanner.nextInt();
                
                if (pokemonNumber == 0) {
                    running = false;
                    System.out.println("Thank you for using the Pokédex!");
                } else if (pokemonNumber < 650 || pokemonNumber > 721) {
                    System.out.println("Invalid Pokémon number. Please enter a number between 650 and 721.");
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
        // This method populates the database with Gen 6 Pokémon info
        
        // Chespin evolution line
        pokemonDatabase.put(650, new Pokemon("Chespin", new String[]{"Grass"}, 0.4, 9.0, 
                "The quills on its head are usually soft. When it flexes them, the points become so hard and sharp that they can pierce rock."));
        pokemonDatabase.put(651, new Pokemon("Quilladin", new String[]{"Grass"}, 0.7, 29.0, 
                "It relies on its shell-like armor to deflect attacks. It counterattacks with its sharp quills."));
        pokemonDatabase.put(652, new Pokemon("Chesnaught", new String[]{"Grass", "Fighting"}, 1.6, 90.0, 
                "When it takes a defensive posture with its fists guarding its face, it could withstand a bomb blast."));
        
        // Fennekin evolution line
        pokemonDatabase.put(653, new Pokemon("Fennekin", new String[]{"Fire"}, 0.4, 9.4, 
                "As it walks, it munches on a twig in place of a snack. It intimidates opponents by puffing hot air out of its ears."));
        pokemonDatabase.put(654, new Pokemon("Braixen", new String[]{"Fire"}, 1.0, 14.5, 
                "It has a twig stuck in its tail. With friction from its tail fur, it sets the twig on fire and launches into battle."));
        pokemonDatabase.put(655, new Pokemon("Delphox", new String[]{"Fire", "Psychic"}, 1.5, 39.0, 
                "It gazes into the flame at the tip of its branch to achieve a focused state, which allows it to see into the future."));
        
        // Froakie evolution line
        pokemonDatabase.put(656, new Pokemon("Froakie", new String[]{"Water"}, 0.3, 7.0, 
                "It secretes flexible bubbles from its chest and back. The bubbles reduce the damage it would otherwise take when attacked."));
        pokemonDatabase.put(657, new Pokemon("Frogadier", new String[]{"Water"}, 0.6, 10.9, 
                "It can throw bubble-covered pebbles with precise control, hitting empty cans up to a hundred feet away."));
        pokemonDatabase.put(658, new Pokemon("Greninja", new String[]{"Water", "Dark"}, 1.5, 40.0, 
                "It creates throwing stars out of compressed water. When it spins them and throws them at high speed, these stars can split metal in two."));
        
        // Early route Pokémon
        pokemonDatabase.put(659, new Pokemon("Bunnelby", new String[]{"Normal"}, 0.4, 5.0, 
                "It has ears like shovels. Digging holes strengthens its ears so much that they can sever thick roots effortlessly."));
        pokemonDatabase.put(660, new Pokemon("Diggersby", new String[]{"Normal", "Ground"}, 1.0, 42.4, 
                "With its powerful ears, it digs burrows to sleep in at night. When it's finished digging, it lounges around lazily."));
        
        // Fletchling evolution line
        pokemonDatabase.put(661, new Pokemon("Fletchling", new String[]{"Normal", "Flying"}, 0.3, 1.7, 
                "These friendly Pokémon send signals to one another with beautiful chirps and tail-feather movements."));
        pokemonDatabase.put(662, new Pokemon("Fletchinder", new String[]{"Fire", "Flying"}, 0.7, 16.0, 
                "The hotter the flame sac on its belly, the faster it can fly, but it takes time to get the fire going."));
        pokemonDatabase.put(663, new Pokemon("Talonflame", new String[]{"Fire", "Flying"}, 1.2, 24.5, 
                "In the fever of an exciting battle, it showers embers from the gaps between its feathers and takes to the air."));
        
        // Bug Pokémon
        pokemonDatabase.put(664, new Pokemon("Scatterbug", new String[]{"Bug"}, 0.3, 2.5, 
                "When under attack from bird Pokémon, it spews a poisonous black powder that causes paralysis on contact."));
        pokemonDatabase.put(665, new Pokemon("Spewpa", new String[]{"Bug"}, 0.3, 8.4, 
                "It lives hidden within thicket shadows. When predators attack, it quickly bristles the fur covering its body in an effort to threaten them."));
        pokemonDatabase.put(666, new Pokemon("Vivillon", new String[]{"Bug", "Flying"}, 1.2, 17.0, 
                "The patterns on this Pokémon's wings depend on the climate and topography of its habitat. It scatters colorful scales."));
        
        // Fairy Pokémon
        pokemonDatabase.put(669, new Pokemon("Flabébé", new String[]{"Fairy"}, 0.1, 0.1, 
                "When it finds a flower it likes, it dwells on that flower its whole life. It floats in the wind's embrace with an untroubled heart."));
        pokemonDatabase.put(670, new Pokemon("Floette", new String[]{"Fairy"}, 0.2, 0.9, 
                "It flutters around fields of flowers and cares for flowers that are starting to wilt. It draws out the power of flowers to battle."));
        pokemonDatabase.put(671, new Pokemon("Florges", new String[]{"Fairy"}, 1.1, 10.0, 
                "It claims exquisite flower gardens as its territory, and it obtains power from basking in the energy emitted by flowering plants."));
        
        // Legendary Pokémon
        pokemonDatabase.put(716, new Pokemon("Xerneas", new String[]{"Fairy"}, 3.0, 215.0, 
                "Legends say it can share eternal life. It slept for a thousand years in the form of a tree before its revival."));
        pokemonDatabase.put(717, new Pokemon("Yveltal", new String[]{"Dark", "Flying"}, 5.8, 203.0, 
                "When this legendary Pokémon's wings and tail feathers spread wide and glow red, it absorbs the life force of living creatures."));
        pokemonDatabase.put(718, new Pokemon("Zygarde", new String[]{"Dragon", "Ground"}, 5.0, 305.0, 
                "It's said to be monitoring the ecosystem. There are rumors that even greater power lies hidden within it."));
        pokemonDatabase.put(719, new Pokemon("Diancie", new String[]{"Rock", "Fairy"}, 0.7, 8.8, 
                "A sudden transformation of Carbink, its pink, glimmering body is said to be the loveliest sight in the whole world."));
        pokemonDatabase.put(720, new Pokemon("Hoopa", new String[]{"Psychic", "Ghost"}, 0.5, 9.0, 
                "It gathers things it likes and passes them through its loop to teleport them to a secret place."));
        pokemonDatabase.put(721, new Pokemon("Volcanion", new String[]{"Fire", "Water"}, 1.7, 195.0, 
                "It lets out billows of steam and disappears into the dense fog. It's said to live in mountains where humans do not tread."));
        
        // Note: In a complete implementation, add entries for all 72 Kalos Pokémon
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
