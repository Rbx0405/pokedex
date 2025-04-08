import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SinnohPokedex {
    private static Map<Integer, Pokemon> pokemonDatabase = new HashMap<>();

    public static void main(String[] args) {
        initializePokedex();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Sinnoh Pokédex!");
        System.out.println("Featuring the 107 new Pokémon from Generation 4 (National Dex #387-493).");
        
        boolean running = true;
        while (running) {
            System.out.print("\nEnter a National Pokédex number (387-493) or 0 to exit: ");
            
            try {
                int pokemonNumber = scanner.nextInt();
                
                if (pokemonNumber == 0) {
                    running = false;
                    System.out.println("Thank you for using the Pokédex!");
                } else if (pokemonNumber < 387 || pokemonNumber > 493) {
                    System.out.println("Invalid Pokémon number. Please enter a number between 387 and 493.");
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
        // This method populates the database with Gen 4 Pokémon info
        
        // Turtwig evolution line
        pokemonDatabase.put(387, new Pokemon("Turtwig", new String[]{"Grass"}, 0.4, 10.2, 
                "Made from soil, the shell on its back hardens when it drinks water. It lives along lakes."));
        pokemonDatabase.put(388, new Pokemon("Grotle", new String[]{"Grass"}, 1.1, 97.0, 
                "It lives along water in forests. In the daytime, it leaves the forest to sunbathe its treed shell."));
        pokemonDatabase.put(389, new Pokemon("Torterra", new String[]{"Grass", "Ground"}, 2.2, 310.0, 
                "Ancient people imagined that beneath the ground, a gigantic Torterra dwelled."));
        
        // Chimchar evolution line
        pokemonDatabase.put(390, new Pokemon("Chimchar", new String[]{"Fire"}, 0.5, 6.2, 
                "Its fiery rear end is fueled by gas made in its belly. Even rain can't extinguish the fire."));
        pokemonDatabase.put(391, new Pokemon("Monferno", new String[]{"Fire", "Fighting"}, 0.9, 22.0, 
                "It skillfully controls the intensity of the fire on its tail to keep its foes at an ideal distance."));
        pokemonDatabase.put(392, new Pokemon("Infernape", new String[]{"Fire", "Fighting"}, 1.2, 55.0, 
                "Its crown of fire is indicative of its fiery nature. It is beaten by none in terms of quickness."));
        
        // Piplup evolution line
        pokemonDatabase.put(393, new Pokemon("Piplup", new String[]{"Water"}, 0.4, 5.2, 
                "Because it is very proud, it hates accepting food from people. Its thick down guards it from cold."));
        pokemonDatabase.put(394, new Pokemon("Prinplup", new String[]{"Water"}, 0.8, 23.0, 
                "It lives alone, away from others. Apparently, every one of them believes it is the most important."));
        pokemonDatabase.put(395, new Pokemon("Empoleon", new String[]{"Water", "Steel"}, 1.7, 84.5, 
                "The three horns that extend from its beak attest to its power. The leader has the biggest horns."));
        
        // Starly evolution line
        pokemonDatabase.put(396, new Pokemon("Starly", new String[]{"Normal", "Flying"}, 0.3, 2.0, 
                "They flock in great numbers. Though small, they flap their wings with great power."));
        pokemonDatabase.put(397, new Pokemon("Staravia", new String[]{"Normal", "Flying"}, 0.6, 15.5, 
                "They maintain huge flocks, although fierce scuffles break out between various flocks."));
        pokemonDatabase.put(398, new Pokemon("Staraptor", new String[]{"Normal", "Flying"}, 1.2, 24.9, 
                "It never stops attacking even if it is injured. It fusses over the shape of its comb."));
        
        // Bidoof evolution line
        pokemonDatabase.put(399, new Pokemon("Bidoof", new String[]{"Normal"}, 0.5, 20.0, 
                "With nerves of steel, nothing can perturb it. It is more agile and active than it appears."));
        pokemonDatabase.put(400, new Pokemon("Bibarel", new String[]{"Normal", "Water"}, 1.0, 31.5, 
                "It makes its nest by damming streams with bark and mud. It is known as an industrious worker."));
        
        // Kricketot evolution line
        pokemonDatabase.put(401, new Pokemon("Kricketot", new String[]{"Bug"}, 0.3, 2.2, 
                "It chats with others using the sounds of its colliding antennae. These sounds are fall hallmarks."));
        pokemonDatabase.put(402, new Pokemon("Kricketune", new String[]{"Bug"}, 1.0, 25.5, 
                "It crosses its knifelike arms in front of its chest when it cries. It can compose melodies ad lib."));
        
        // Shinx evolution line
        pokemonDatabase.put(403, new Pokemon("Shinx", new String[]{"Electric"}, 0.5, 9.5, 
                "All of its fur dazzles if danger is sensed. It flees while the foe is momentarily blinded."));
        pokemonDatabase.put(404, new Pokemon("Luxio", new String[]{"Electric"}, 0.9, 30.5, 
                "Strong electricity courses through the tips of its sharp claws. A light scratch causes fainting."));
        pokemonDatabase.put(405, new Pokemon("Luxray", new String[]{"Electric"}, 1.4, 42.0, 
                "It has eyes which can see through anything. It spots and captures prey hiding behind objects."));
        
        // Budew evolution line
        pokemonDatabase.put(406, new Pokemon("Budew", new String[]{"Grass", "Poison"}, 0.2, 1.2, 
                "Over the winter, it closes its bud and endures the cold. In spring, the bud opens and releases pollen."));
        
        // Cranidos evolution line
        pokemonDatabase.put(408, new Pokemon("Cranidos", new String[]{"Rock"}, 0.9, 31.5, 
                "It was resurrected from an iron ball-like fossil. It downs prey with its headbutts."));
        pokemonDatabase.put(409, new Pokemon("Rampardos", new String[]{"Rock"}, 1.6, 102.5, 
                "Its powerful head butt has enough power to shatter even the most durable things upon impact."));
        
        // Shieldon evolution line
        pokemonDatabase.put(410, new Pokemon("Shieldon", new String[]{"Rock", "Steel"}, 0.5, 57.0, 
                "A Pokémon that lived in primeval jungles. Few enemies would have been willing to square off against it."));
        pokemonDatabase.put(411, new Pokemon("Bastiodon", new String[]{"Rock", "Steel"}, 1.3, 149.5, 
                "Any frontal attack is repulsed. It is a docile Pokémon that feeds on grass and berries."));
        
        // Legendary Pokémon
        pokemonDatabase.put(480, new Pokemon("Uxie", new String[]{"Psychic"}, 0.3, 0.3, 
                "Known as 'The Being of Knowledge.' It is said that it can wipe out the memory of those who see its eyes."));
        pokemonDatabase.put(481, new Pokemon("Mesprit", new String[]{"Psychic"}, 0.3, 0.3, 
                "Known as 'The Being of Emotion.' It taught humans the nobility of sorrow, pain, and joy."));
        pokemonDatabase.put(482, new Pokemon("Azelf", new String[]{"Psychic"}, 0.3, 0.3, 
                "Known as 'The Being of Willpower.' It sleeps at the bottom of a lake to keep the world in balance."));
        
        pokemonDatabase.put(483, new Pokemon("Dialga", new String[]{"Steel", "Dragon"}, 5.4, 683.0, 
                "A Pokémon spoken of in legend. It is said that time began moving when Dialga was born."));
        pokemonDatabase.put(484, new Pokemon("Palkia", new String[]{"Water", "Dragon"}, 4.2, 336.0, 
                "It has the ability to distort space. It is described as a deity in Sinnoh-region mythology."));
        
        pokemonDatabase.put(487, new Pokemon("Giratina", new String[]{"Ghost", "Dragon"}, 4.5, 750.0, 
                "This Pokémon is said to live in a world on the reverse side of ours, where common knowledge is distorted and strange."));
        
        pokemonDatabase.put(493, new Pokemon("Arceus", new String[]{"Normal"}, 3.2, 320.0, 
                "It is told in mythology that this Pokémon was born before the universe even existed."));
        
        // Note: In a complete implementation, all 107 Sinnoh Pokémon should be added
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
