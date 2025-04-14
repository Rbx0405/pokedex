import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GalarPokedex {
    private static Map<Integer, Pokemon> pokemonDatabase = new HashMap<>();

    public static void main(String[] args) {
        initializePokedex();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Galar Pokédex!");
        System.out.println("Featuring 89 new Pokémon from Generation 8.");
        
        boolean running = true;
        while (running) {
            System.out.print("\nEnter a Pokémon number (810-898) or 0 to exit: ");
            
            try {
                int pokemonNumber = scanner.nextInt();
                
                if (pokemonNumber == 0) {
                    running = false;
                    System.out.println("Thank you for using the Pokédex!");
                } else if (pokemonNumber < 810 || pokemonNumber > 898) {
                    System.out.println("Invalid Pokémon number. Please enter a number between 810 and 898.");
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
        // This method populates the database with Gen 8 (Galar) Pokémon info
        
        // Grookey evolution line
        pokemonDatabase.put(810, new Pokemon("Grookey", new String[]{"Grass"}, 0.3, 5.0, 
                "When it uses its special stick to strike up a beat, the sound waves produced carry revitalizing energy to the plants and flowers in the area."));
        pokemonDatabase.put(811, new Pokemon("Thwackey", new String[]{"Grass"}, 0.7, 14.0, 
                "The faster a Thwackey can beat its two sticks together, the more respect it wins from its peers."));
        pokemonDatabase.put(812, new Pokemon("Rillaboom", new String[]{"Grass"}, 2.1, 90.0, 
                "By drumming, it taps into the power of its special tree stump. The roots of the stump follow its direction in battle."));
        
        // Scorbunny evolution line
        pokemonDatabase.put(813, new Pokemon("Scorbunny", new String[]{"Fire"}, 0.3, 4.5, 
                "A warm-up of running around gets fire energy coursing through this Pokémon's body. Once that happens, it's ready to fight."));
        pokemonDatabase.put(814, new Pokemon("Raboot", new String[]{"Fire"}, 0.6, 9.0, 
                "Its thick and fluffy fur protects it from the cold and enables it to use hotter fire moves."));
        pokemonDatabase.put(815, new Pokemon("Cinderace", new String[]{"Fire"}, 1.4, 33.0, 
                "It juggles a pebble with its feet, turning it into a burning soccer ball. Its shots strike opponents hard and leave them scorched."));
        
        // Sobble evolution line
        pokemonDatabase.put(816, new Pokemon("Sobble", new String[]{"Water"}, 0.3, 4.0, 
                "When scared, this Pokémon cries. Its tears pack the chemical punch of 100 onions, and attackers won't be able to resist weeping."));
        pokemonDatabase.put(817, new Pokemon("Drizzile", new String[]{"Water"}, 0.7, 11.5, 
                "A clever combatant, this Pokémon battles using water balloons created with moisture secreted from its palms."));
        pokemonDatabase.put(818, new Pokemon("Inteleon", new String[]{"Water"}, 1.9, 45.2, 
                "It has many hidden capabilities, such as fingertips that can shoot water and a membrane on its back that it can use to glide through the air."));
        
        // Early route Pokémon
        pokemonDatabase.put(819, new Pokemon("Skwovet", new String[]{"Normal"}, 0.3, 2.5, 
                "It eats berries nonstop—a habit that has made it more resilient than it looks. It'll show up on farms and fields to steal berries."));
        pokemonDatabase.put(820, new Pokemon("Greedent", new String[]{"Normal"}, 0.6, 6.0, 
                "It stashes berries in its tail—so many berries that they fall out constantly. But this Pokémon is a bit slow-witted, so it doesn't notice the loss."));
        
        // Regional bird evolution line
        pokemonDatabase.put(821, new Pokemon("Rookidee", new String[]{"Flying"}, 0.2, 1.8, 
                "It will bravely challenge any opponent, no matter how powerful. This Pokémon benefits from every battle—even a defeat increases its strength a bit."));
        pokemonDatabase.put(822, new Pokemon("Corvisquire", new String[]{"Flying"}, 0.8, 16.0, 
                "Smart enough to use tools in battle, these Pokémon have been seen picking up rocks and flinging them or using ropes to wrap up enemies."));
        pokemonDatabase.put(823, new Pokemon("Corviknight", new String[]{"Flying", "Steel"}, 2.2, 75.0, 
                "This Pokémon reigns supreme in the skies of the Galar region. The black luster of its steel body could drive terror into the heart of any foe."));
        
        // Legendary Pokémon
        pokemonDatabase.put(888, new Pokemon("Zacian", new String[]{"Fairy"}, 2.8, 110.0, 
                "Known as a legendary hero, this Pokémon absorbs metal particles, transforming them into a weapon it uses to battle."));
        pokemonDatabase.put(889, new Pokemon("Zamazenta", new String[]{"Fighting"}, 2.9, 210.0, 
                "In times past, it worked together with a king of the people to save the Galar region. It absorbs metal that it then uses in battle."));
        pokemonDatabase.put(890, new Pokemon("Eternatus", new String[]{"Poison", "Dragon"}, 20.0, 950.0, 
                "The core on its chest absorbs energy emanating from the lands of the Galar region. This energy is what allows Eternatus to stay active."));
        
        // Mythical Pokémon
        pokemonDatabase.put(893, new Pokemon("Zarude", new String[]{"Dark", "Grass"}, 1.8, 70.0, 
                "Within dense forests, this Pokémon lives in a pack with others of its kind. It's incredibly aggressive, and the other Pokémon of the forest fear it."));
        
        // DLC Legendary Pokémon
        pokemonDatabase.put(894, new Pokemon("Regieleki", new String[]{"Electric"}, 1.2, 145.0, 
                "This Pokémon is a cluster of electrical energy. It's said that removing the rings on Regieleki's body will unleash the Pokémon's latent power."));
        pokemonDatabase.put(895, new Pokemon("Regidrago", new String[]{"Dragon"}, 2.1, 200.0, 
                "An academic theory proposes that this Pokémon was created by an ancient people when they fused a certain dragon Pokémon's data into a crystal."));
        pokemonDatabase.put(896, new Pokemon("Glastrier", new String[]{"Ice"}, 2.2, 800.0, 
                "As it dashes through the snowy fields, this Pokémon produces a distinct trail of frozen soil behind it."));
        pokemonDatabase.put(897, new Pokemon("Spectrier", new String[]{"Ghost"}, 2.0, 44.5, 
                "It probes its surroundings with all its senses save one—it doesn't use its sense of sight. Spectrier's kicks are said to separate soul from body."));
        pokemonDatabase.put(898, new Pokemon("Calyrex", new String[]{"Psychic", "Grass"}, 1.1, 7.7, 
                "Calyrex is known in legend as a king that ruled over Galar in ancient times. It has the power to cause hearts to mend and plants to spring forth."));
        
        // Add more Gen 8 Pokémon
        pokemonDatabase.put(824, new Pokemon("Blipbug", new String[]{"Bug"}, 0.4, 8.0, 
                "A constant collector of information, this Pokémon is very smart. Very strong is what it isn't."));
        pokemonDatabase.put(825, new Pokemon("Dottler", new String[]{"Bug", "Psychic"}, 0.4, 19.5, 
                "It barely moves, but it's still alive. Hiding in its shell without food or water seems to have awakened its psychic powers."));
        pokemonDatabase.put(826, new Pokemon("Orbeetle", new String[]{"Bug", "Psychic"}, 0.4, 40.8, 
                "It's famous for its high intelligence, and the large size of its brain is proof that it also possesses immense psychic power."));
        
        pokemonDatabase.put(827, new Pokemon("Nickit", new String[]{"Dark"}, 0.6, 8.9, 
                "Cunning and cautious, this Pokémon survives by stealing food from others. It erases its tracks with swipes of its tail as it makes off with its plunder."));
        pokemonDatabase.put(828, new Pokemon("Thievul", new String[]{"Dark"}, 1.2, 19.9, 
                "It secretly marks potential targets with a scent. By following the scent, it stalks its prey and steals from them in the dead of night."));
        
        pokemonDatabase.put(829, new Pokemon("Gossifleur", new String[]{"Grass"}, 0.4, 2.2, 
                "It anchors itself in the ground with its single leg, then basks in the sun. After absorbing enough sunlight, its petals spread as it blooms brilliantly."));
        pokemonDatabase.put(830, new Pokemon("Eldegoss", new String[]{"Grass"}, 0.5, 2.5, 
                "The seeds attached to its cotton fluff are full of nutrients. It spreads them on the wind so that plants and other Pokémon can benefit from them."));
        
        // Note: In a complete implementation, add entries for all 89 Galar Pokémon
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
