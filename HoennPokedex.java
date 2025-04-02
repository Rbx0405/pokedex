import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HoennPokedex {
    private static Map<Integer, Pokemon> pokemonDatabase = new HashMap<>();

    public static void main(String[] args) {
        initializePokedex();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Hoenn Pokédex!");
        System.out.println("Featuring 135 new Pokémon from Generation 3.");
        
        boolean running = true;
        while (running) {
            System.out.print("\nEnter a Pokémon number (252-386) or 0 to exit: ");
            
            try {
                int pokemonNumber = scanner.nextInt();
                
                if (pokemonNumber == 0) {
                    running = false;
                    System.out.println("Thank you for using the Pokédex!");
                } else if (pokemonNumber < 252 || pokemonNumber > 386) {
                    System.out.println("Invalid Pokémon number. Please enter a number between 252 and 386.");
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
        // This method populates the database with Gen 3 Pokémon info
        
        // Treecko evolution line
        pokemonDatabase.put(252, new Pokemon("Treecko", new String[]{"Grass"}, 0.5, 5.0, 
                "It makes its nest in a giant tree in the forest. It ferociously guards against anything nearing its territory. It is said to be the protector of the forest's trees."));
        pokemonDatabase.put(253, new Pokemon("Grovyle", new String[]{"Grass"}, 0.9, 21.6, 
                "Leaves grow out of this Pokémon's body. They help obscure a Grovyle from the eyes of its enemies while it is in a thickly overgrown forest."));
        pokemonDatabase.put(254, new Pokemon("Sceptile", new String[]{"Grass"}, 1.7, 52.2, 
                "The leaves growing on Sceptile's body are very sharp edged. This Pokémon is very agile—it leaps all over the branches of trees and jumps on its foe from above or behind."));
        
        // Torchic evolution line
        pokemonDatabase.put(255, new Pokemon("Torchic", new String[]{"Fire"}, 0.4, 2.5, 
                "A fire burns inside, so it feels very warm to hug. It launches fireballs of 1,800 degrees Fahrenheit. If attacked, it strikes back by spitting balls of fire it forms in its stomach."));
        pokemonDatabase.put(256, new Pokemon("Combusken", new String[]{"Fire", "Fighting"}, 0.9, 19.5, 
                "Combusken toughens up its legs and thighs by running through fields and mountains. This Pokémon's legs possess both speed and power, enabling it to dole out 10 kicks in one second."));
        pokemonDatabase.put(257, new Pokemon("Blaziken", new String[]{"Fire", "Fighting"}, 1.9, 52.0, 
                "In battle, Blaziken blows out intense flames from its wrists and attacks foes courageously. The stronger the foe, the more intensely this Pokémon's wrists burn."));
        
        // Mudkip evolution line
        pokemonDatabase.put(258, new Pokemon("Mudkip", new String[]{"Water"}, 0.4, 7.6, 
                "In water, Mudkip breathes using the gills on its cheeks. If it is faced with a tight situation in battle, this Pokémon will unleash its amazing power—it can crush rocks bigger than itself."));
        pokemonDatabase.put(259, new Pokemon("Marshtomp", new String[]{"Water", "Ground"}, 0.7, 28.0, 
                "Marshtomp is much faster at traveling through mud than it is at swimming. This Pokémon's hindquarters exhibit obvious development, giving it the ability to walk on just its hind legs."));
        pokemonDatabase.put(260, new Pokemon("Swampert", new String[]{"Water", "Ground"}, 1.5, 81.9, 
                "Swampert is very strong. It has enough power to easily drag a boulder weighing more than a ton. This Pokémon also has powerful vision that lets it see even in murky water."));
        
        // Poochyena evolution line
        pokemonDatabase.put(261, new Pokemon("Poochyena", new String[]{"Dark"}, 0.5, 13.6, 
                "At first sight, Poochyena takes a bite at anything that moves. This Pokémon chases after prey until the victim becomes exhausted. However, it may turn tail if the prey strikes back."));
        pokemonDatabase.put(262, new Pokemon("Mightyena", new String[]{"Dark"}, 1.0, 37.0, 
                "Mightyena travel and act as a pack in the wild. The memory of its life in the wild compels the Pokémon to obey only those Trainers that it recognizes to possess superior skill."));
        
        // Zigzagoon evolution line
        pokemonDatabase.put(263, new Pokemon("Zigzagoon", new String[]{"Normal"}, 0.4, 17.5, 
                "Zigzagoon restlessly wanders everywhere at all times. This Pokémon does so because it is very curious. It becomes interested in anything that it happens to see."));
        pokemonDatabase.put(264, new Pokemon("Linoone", new String[]{"Normal"}, 0.5, 32.5, 
                "Linoone always runs full speed and only in straight lines. If facing an obstacle, it makes a right-angle turn to evade it. This Pokémon is very challenged by gently curving roads."));
        
        // Wurmple evolution lines
        pokemonDatabase.put(265, new Pokemon("Wurmple", new String[]{"Bug"}, 0.3, 3.6, 
                "Using the spikes on its rear end, Wurmple peels the bark off trees and feeds on the sap that oozes out. This Pokémon's feet are tipped with suction pads that allow it to cling to glass without slipping."));
        pokemonDatabase.put(266, new Pokemon("Silcoon", new String[]{"Bug"}, 0.6, 10.0, 
                "Silcoon tethers itself to a tree branch using silk to keep from falling. There, this Pokémon hangs quietly while it awaits evolution. It peers out of the silk cocoon through a small hole."));
        pokemonDatabase.put(267, new Pokemon("Beautifly", new String[]{"Bug", "Flying"}, 1.0, 28.4, 
                "Beautifly's favorite food is the sweet pollen of flowers. If you want to see this Pokémon, just leave a potted flower by an open window. Beautifly is sure to come looking for pollen."));
        pokemonDatabase.put(268, new Pokemon("Cascoon", new String[]{"Bug"}, 0.7, 11.5, 
                "Cascoon makes its protective cocoon by wrapping its body entirely with a fine silk from its mouth. Once the silk goes around its body, it hardens. This Pokémon prepares for its evolution inside the cocoon."));
        pokemonDatabase.put(269, new Pokemon("Dustox", new String[]{"Bug", "Poison"}, 1.2, 31.6, 
                "Dustox is instinctively drawn to light. Swarms of this Pokémon are attracted by the bright lights of cities, where they wreak havoc by stripping the leaves off roadside trees for food."));
        
        // Lotad evolution line
        pokemonDatabase.put(270, new Pokemon("Lotad", new String[]{"Water", "Grass"}, 0.5, 2.6, 
                "Lotad live in ponds and lakes, where they float on the surface. It grows weak if its broad leaf dries out. On rare occasions, this Pokémon travels on land in search of clean water."));
        pokemonDatabase.put(271, new Pokemon("Lombre", new String[]{"Water", "Grass"}, 1.2, 32.5, 
                "Lombre is nocturnal—it will get active after dusk. It is also a mischief maker. When this Pokémon spots anglers, it tugs on their fishing lines from beneath the surface and enjoys their consternation."));
        pokemonDatabase.put(272, new Pokemon("Ludicolo", new String[]{"Water", "Grass"}, 1.5, 55.0, 
                "Ludicolo begins dancing as soon as it hears cheerful, festive music. This Pokémon is said to appear when it hears the singing of children on hiking outings."));
        
        // Legendary Pokémon
        pokemonDatabase.put(380, new Pokemon("Latias", new String[]{"Dragon", "Psychic"}, 1.4, 40.0, 
                "Latias is highly sensitive to the emotions of people. If it senses any hostility, this Pokémon ruffles the feathers all over its body and cries shrilly to intimidate the foe."));
        pokemonDatabase.put(381, new Pokemon("Latios", new String[]{"Dragon", "Psychic"}, 2.0, 60.0, 
                "Latios has the ability to make others see an image of what it has seen or imagines in its head. This Pokémon is intelligent and understands human speech."));
        pokemonDatabase.put(382, new Pokemon("Kyogre", new String[]{"Water"}, 4.5, 352.0, 
                "Kyogre has the power to create massive rain clouds that cover the entire sky and bring about torrential downpours. This Pokémon saved people who were suffering from droughts."));
        pokemonDatabase.put(383, new Pokemon("Groudon", new String[]{"Ground"}, 3.5, 950.0, 
                "Groudon has long been described in mythology as the Pokémon that raised lands and expanded continents. This Pokémon took to sleep after a cataclysmic battle with Kyogre."));
        pokemonDatabase.put(384, new Pokemon("Rayquaza", new String[]{"Dragon", "Flying"}, 7.0, 206.5, 
                "Rayquaza lived for hundreds of millions of years in the earth's ozone layer, never descending to the ground. This Pokémon appears to feed on water and particles in the atmosphere."));
        pokemonDatabase.put(385, new Pokemon("Jirachi", new String[]{"Steel", "Psychic"}, 0.3, 1.1, 
                "A legend states that Jirachi will make true any wish that is written on notes attached to its head when it awakens. If this Pokémon senses danger, it will fight without awakening."));
        pokemonDatabase.put(386, new Pokemon("Deoxys", new String[]{"Psychic"}, 1.7, 60.8, 
                "The DNA of a space virus underwent a sudden mutation upon exposure to a laser beam and resulted in Deoxys. The crystalline organ on this Pokémon's chest appears to be its brain."));

        // Note: In a complete implementation, add entries for all 135 Hoenn Pokémon
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
