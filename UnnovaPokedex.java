import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UnnovaPokedex {
    private static Map<Integer, Pokemon> pokemonDatabase = new HashMap<>();

    public static void main(String[] args) {
        initializePokedex();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Unova Pokédex!");
        System.out.println("Featuring the 156 new Pokémon from Generation 5 (National Dex #494-649).");
        
        boolean running = true;
        while (running) {
            System.out.print("\nEnter a National Pokédex number (494-649) or 0 to exit: ");
            
            try {
                int pokemonNumber = scanner.nextInt();
                
                if (pokemonNumber == 0) {
                    running = false;
                    System.out.println("Thank you for using the Pokédex!");
                } else if (pokemonNumber < 494 || pokemonNumber > 649) {
                    System.out.println("Invalid Pokémon number. Please enter a number between 494 and 649.");
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
        // This method populates the database with Gen 5 Pokémon info
        
        // Starter Pokémon: Snivy evolution line
        pokemonDatabase.put(495, new Pokemon("Snivy", new String[]{"Grass"}, 0.6, 8.1, 
                "It is very intelligent and calm. Being exposed to lots of sunlight makes its movements swifter."));
        pokemonDatabase.put(496, new Pokemon("Servine", new String[]{"Grass"}, 0.8, 16.0, 
                "It moves along the ground as if sliding. Its swift movements befuddle its foes, and it then attacks with a vine whip."));
        pokemonDatabase.put(497, new Pokemon("Serperior", new String[]{"Grass"}, 3.3, 63.0, 
                "It only gives its all against strong opponents who are not fazed by the glare from Serperior's noble eyes."));
        
        // Starter Pokémon: Tepig evolution line
        pokemonDatabase.put(498, new Pokemon("Tepig", new String[]{"Fire"}, 0.5, 9.9, 
                "It loves to eat roasted berries, but sometimes it gets too excited and burns them to a crisp."));
        pokemonDatabase.put(499, new Pokemon("Pignite", new String[]{"Fire", "Fighting"}, 1.0, 55.5, 
                "Whatever it eats becomes fuel for the flame in its stomach. When it is angered, the intensity of the flame increases."));
        pokemonDatabase.put(500, new Pokemon("Emboar", new String[]{"Fire", "Fighting"}, 1.6, 150.0, 
                "It has mastered fast and powerful fighting moves. It grows a beard of fire."));
        
        // Starter Pokémon: Oshawott evolution line
        pokemonDatabase.put(501, new Pokemon("Oshawott", new String[]{"Water"}, 0.5, 5.9, 
                "The scalchop on its stomach isn't just used for battle—it can be used to break open hard berries as well."));
        pokemonDatabase.put(502, new Pokemon("Dewott", new String[]{"Water"}, 0.8, 24.5, 
                "Scalchop techniques differ from one Dewott to another. It never neglects maintaining its scalchops."));
        pokemonDatabase.put(503, new Pokemon("Samurott", new String[]{"Water"}, 1.5, 94.6, 
                "One swing of the sword incorporated in its armor can fell an opponent. A simple glare from one of them quiets everybody."));
        
        // Early route Pokémon: Patrat evolution line
        pokemonDatabase.put(504, new Pokemon("Patrat", new String[]{"Normal"}, 0.5, 11.6, 
                "Using food stored in cheek pouches, they can keep watch for days. They use their tails to communicate with others."));
        pokemonDatabase.put(505, new Pokemon("Watchog", new String[]{"Normal"}, 1.1, 27.0, 
                "When they see an enemy, their tails stand high, and they spit the seeds of berries stored in their cheek pouches."));
        
        // Early route Pokémon: Lillipup evolution line
        pokemonDatabase.put(506, new Pokemon("Lillipup", new String[]{"Normal"}, 0.4, 4.1, 
                "It faces strong opponents with great courage. But, when at a disadvantage in a fight, this intelligent Pokémon flees."));
        pokemonDatabase.put(507, new Pokemon("Herdier", new String[]{"Normal"}, 0.9, 14.7, 
                "It has black, cape-like fur that is very hard and decreases the amount of damage it receives."));
        pokemonDatabase.put(508, new Pokemon("Stoutland", new String[]{"Normal"}, 1.2, 61.0, 
                "It rescues people stranded by blizzards in the mountains. Its shaggy fur shields it from the cold."));
        
        // Early route Pokémon: Purrloin evolution line
        pokemonDatabase.put(509, new Pokemon("Purrloin", new String[]{"Dark"}, 0.4, 10.1, 
                "Their cute act is a ruse. They trick people and steal their valuables just to see the looks on their faces."));
        pokemonDatabase.put(510, new Pokemon("Liepard", new String[]{"Dark"}, 1.1, 37.5, 
                "These Pokémon vanish and appear unexpectedly. Many Trainers are drawn to their beautiful form and fur."));
        
        // Early route Pokémon: Pansage, Pansear, Panpour evolution lines
        pokemonDatabase.put(511, new Pokemon("Pansage", new String[]{"Grass"}, 0.6, 10.5, 
                "It's good at finding berries and gathers them from all over. It's kind enough to share them with friends."));
        pokemonDatabase.put(512, new Pokemon("Simisage", new String[]{"Grass"}, 1.1, 30.5, 
                "It attacks enemies with strikes of its thorn-covered tail. This Pokémon is wild tempered."));
        
        pokemonDatabase.put(513, new Pokemon("Pansear", new String[]{"Fire"}, 0.6, 11.0, 
                "This Pokémon lives in caves in volcanoes. The fire within the tuft on its head can reach 600 degrees Fahrenheit."));
        pokemonDatabase.put(514, new Pokemon("Simisear", new String[]{"Fire"}, 1.0, 28.0, 
                "A flame burns inside its body. It scatters embers from its head and tail to sear its opponents."));
        
        pokemonDatabase.put(515, new Pokemon("Panpour", new String[]{"Water"}, 0.6, 13.5, 
                "The water stored inside the tuft on its head is full of nutrients. It waters plants with it using its tail."));
        pokemonDatabase.put(516, new Pokemon("Simipour", new String[]{"Water"}, 1.0, 29.0, 
                "It prefers places with clean water. When its tuft runs low, it replenishes it by siphoning up water with its tail."));
        
        // Legendary Pokémon: Tao Trio
        pokemonDatabase.put(643, new Pokemon("Reshiram", new String[]{"Dragon", "Fire"}, 3.2, 330.0, 
                "This Pokémon appears in legends. It sends flames into the air from its tail, burning up everything around it."));
        pokemonDatabase.put(644, new Pokemon("Zekrom", new String[]{"Dragon", "Electric"}, 2.9, 345.0, 
                "This legendary Pokémon can scorch the world with lightning. It assists those who want to build an ideal world."));
        pokemonDatabase.put(646, new Pokemon("Kyurem", new String[]{"Dragon", "Ice"}, 3.0, 325.0, 
                "It generates a powerful, freezing energy inside itself, but its body became frozen when the energy leaked out."));
        
        // Other Legendaries
        pokemonDatabase.put(638, new Pokemon("Cobalion", new String[]{"Steel", "Fighting"}, 2.1, 250.0, 
                "It has a body and heart of steel. Its glare is sufficient to make even an unruly Pokémon obey it."));
        pokemonDatabase.put(639, new Pokemon("Terrakion", new String[]{"Rock", "Fighting"}, 1.9, 260.0, 
                "Its charge is strong enough to break through a giant castle wall in one blow. This Pokémon is spoken of in legends."));
        pokemonDatabase.put(640, new Pokemon("Virizion", new String[]{"Grass", "Fighting"}, 2.0, 200.0, 
                "Its head sprouts horns as sharp as blades. Using whirlwind-like movements, it confounds and swiftly cuts opponents."));
        
        pokemonDatabase.put(641, new Pokemon("Tornadus", new String[]{"Flying"}, 1.5, 63.0, 
                "The lower half of its body is wrapped in a cloud of energy. It zooms through the sky at 200 mph."));
        pokemonDatabase.put(642, new Pokemon("Thundurus", new String[]{"Electric", "Flying"}, 1.5, 61.0, 
                "The spikes on its tail discharge immense bolts of lightning. It flies around the Unova region firing off lightning bolts."));
        
        pokemonDatabase.put(645, new Pokemon("Landorus", new String[]{"Ground", "Flying"}, 1.5, 68.0, 
                "From the forces of lightning and wind, it creates energy to give nutrients to the soil and make the land abundant."));
        
        pokemonDatabase.put(647, new Pokemon("Keldeo", new String[]{"Water", "Fighting"}, 1.4, 48.5, 
                "When it is resolute, its body fills with power and it becomes swifter. Its jumps are then too fast to follow."));
        
        pokemonDatabase.put(648, new Pokemon("Meloetta", new String[]{"Normal", "Psychic"}, 0.6, 6.5, 
                "Its melodies are sung with a special vocalization method that can control the feelings of those who hear it."));
        
        pokemonDatabase.put(649, new Pokemon("Genesect", new String[]{"Bug", "Steel"}, 1.5, 82.5, 
                "This ancient bug Pokémon was altered by Team Plasma. They upgraded the cannon on its back."));
        
        // Note: In a complete implementation, all 156 Unova Pokémon should be added
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
