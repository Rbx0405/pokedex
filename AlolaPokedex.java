import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AlolaPokedex {
    private static Map<Integer, Pokemon> pokemonDatabase = new HashMap<>();

    public static void main(String[] args) {
        initializePokedex();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Alola Pokédex!");
        System.out.println("Featuring 88 new Pokémon from Generation 7.");
        
        boolean running = true;
        while (running) {
            System.out.print("\nEnter a Pokémon number (722-809) or 0 to exit: ");
            
            try {
                int pokemonNumber = scanner.nextInt();
                
                if (pokemonNumber == 0) {
                    running = false;
                    System.out.println("Thank you for using the Pokédex!");
                } else if (pokemonNumber < 722 || pokemonNumber > 809) {
                    System.out.println("Invalid Pokémon number. Please enter a number between 722 and 809.");
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
        // This method populates the database with Gen 7 Pokémon info
        
        // Rowlet evolution line
        pokemonDatabase.put(722, new Pokemon("Rowlet", new String[]{"Grass", "Flying"}, 0.3, 1.5, 
                "This wary Pokémon uses photosynthesis to store up energy during the day, while becoming active at night. It silently glides, drawing near to its targets."));
        pokemonDatabase.put(723, new Pokemon("Dartrix", new String[]{"Grass", "Flying"}, 0.7, 16.0, 
                "It throws sharp feathers called blade quills that are capable of piercing a target. Dartrix is very sensitive to the presence of others around it."));
        pokemonDatabase.put(724, new Pokemon("Decidueye", new String[]{"Grass", "Ghost"}, 1.6, 36.6, 
                "It nocks its arrow quills and fires them at opponents. It can strike targets precisely from even 100 yards away. It can move silently thanks to its mastery of flying without making a sound."));
        
        // Litten evolution line
        pokemonDatabase.put(725, new Pokemon("Litten", new String[]{"Fire"}, 0.4, 4.3, 
                "While grooming itself, it builds up fur inside its stomach. It sets the fur alight and spews fiery attacks, which change based on how it coughs."));
        pokemonDatabase.put(726, new Pokemon("Torracat", new String[]{"Fire"}, 0.7, 25.0, 
                "At its throat, it bears a bell of fire. The bell rings brightly whenever this Pokémon spits fire. With a bell-like object attached at the base of its throat, this Pokémon produces all sorts of sounds."));
        pokemonDatabase.put(727, new Pokemon("Incineroar", new String[]{"Fire", "Dark"}, 1.8, 83.0, 
                "This Pokémon has a violent, selfish disposition. If it's not in the mood to listen, it will ignore its Trainer's orders with complete nonchalance."));
        
        // Popplio evolution line
        pokemonDatabase.put(728, new Pokemon("Popplio", new String[]{"Water"}, 0.4, 7.5, 
                "This Pokémon snorts body fluids from its nose, blowing balloons to smash into its foes. It's famous for being a hard worker and a natural performer."));
        pokemonDatabase.put(729, new Pokemon("Brionne", new String[]{"Water"}, 0.6, 17.5, 
                "It cares deeply for its companions. When its Trainer is feeling down, it performs a cheery dance to help them feel better."));
        pokemonDatabase.put(730, new Pokemon("Primarina", new String[]{"Water", "Fairy"}, 1.8, 44.0, 
                "It controls its water balloons with song. The melody is learned from others of its kind and is passed down from one generation to the next."));
        
        // Pikipek evolution line
        pokemonDatabase.put(731, new Pokemon("Pikipek", new String[]{"Normal", "Flying"}, 0.3, 1.2, 
                "It can peck at a rate of 16 times a second to drill holes in trees. It uses the holes for food storage and for nesting."));
        pokemonDatabase.put(732, new Pokemon("Trumbeak", new String[]{"Normal", "Flying"}, 0.6, 14.8, 
                "It eats berries and stores their seeds in its beak. When it encounters enemies or prey, it fires off all the seeds in a burst."));
        pokemonDatabase.put(733, new Pokemon("Toucannon", new String[]{"Normal", "Flying"}, 1.1, 26.0, 
                "Its beak heats up to over 212 degrees Fahrenheit, causing severe burns when it strikes. When it battles, its beak heats up. The temperature can easily exceed 212 degrees Fahrenheit."));
        
        // Yungoos evolution line
        pokemonDatabase.put(734, new Pokemon("Yungoos", new String[]{"Normal"}, 0.4, 6.0, 
                "Although it will eat anything, it prefers fresh living things, so it marches down streets in search of prey."));
        pokemonDatabase.put(735, new Pokemon("Gumshoos", new String[]{"Normal"}, 0.7, 14.2, 
                "When it finds a trace of its prey, it patiently stakes out the location...but it's always snoozing by nightfall."));
        
        // Legendary Pokémon
        pokemonDatabase.put(785, new Pokemon("Tapu Koko", new String[]{"Electric", "Fairy"}, 1.8, 20.5, 
                "This guardian deity of Melemele is brimming with curiosity. It summons thunderclouds and stores their lightning inside its body."));
        pokemonDatabase.put(786, new Pokemon("Tapu Lele", new String[]{"Psychic", "Fairy"}, 1.2, 18.6, 
                "This guardian deity of Akala is guilelessly cruel. The fragrant aroma of flowers is the source of its energy."));
        pokemonDatabase.put(787, new Pokemon("Tapu Bulu", new String[]{"Grass", "Fairy"}, 1.9, 45.5, 
                "This guardian deity of Ula'ula is lazy and doesn't like to work, but it has the power to make plants grow."));
        pokemonDatabase.put(788, new Pokemon("Tapu Fini", new String[]{"Water", "Fairy"}, 1.3, 21.2, 
                "This guardian deity of Poni can control water. People say it can create pure water that will wash away any uncleanness."));
        pokemonDatabase.put(789, new Pokemon("Cosmog", new String[]{"Psychic"}, 0.2, 0.1, 
                "In ages past, it was called the child of the stars. It's said to be a Pokémon from another world, but no specific details are known."));
        pokemonDatabase.put(790, new Pokemon("Cosmoem", new String[]{"Psychic"}, 0.1, 999.9, 
                "Motionless as if dead, its body is faintly warm to the touch. There's something accumulating around the black core within its hard shell."));
        pokemonDatabase.put(791, new Pokemon("Solgaleo", new String[]{"Psychic", "Steel"}, 3.4, 230.0, 
                "It is said to live in another world. The intense light it radiates from the surface of its body can make the darkest of nights light up like midday."));
        pokemonDatabase.put(792, new Pokemon("Lunala", new String[]{"Psychic", "Ghost"}, 4.0, 120.0, 
                "It is said to be a female evolution of Cosmog. When its third eye activates, away it flies to another world."));
        pokemonDatabase.put(793, new Pokemon("Nihilego", new String[]{"Rock", "Poison"}, 1.2, 55.5, 
                "One of the Ultra Beasts. It's unclear whether or not this Pokémon is sentient, but sometimes it can be observed behaving like a young girl."));
        pokemonDatabase.put(794, new Pokemon("Buzzwole", new String[]{"Bug", "Fighting"}, 2.4, 333.6, 
                "This Ultra Beast appeared from another world. It shows off its body, but whether that display is a boast or a threat remains unclear."));
        pokemonDatabase.put(795, new Pokemon("Pheromosa", new String[]{"Bug", "Fighting"}, 1.8, 25.0, 
                "One of the Ultra Beasts. It refuses to touch anything, perhaps because it senses some uncleanness in this world."));
        pokemonDatabase.put(796, new Pokemon("Xurkitree", new String[]{"Electric"}, 3.8, 100.0, 
                "One of the mysterious life-forms known as Ultra Beasts. Astonishing electric shocks emanate from its entire body."));
        pokemonDatabase.put(797, new Pokemon("Celesteela", new String[]{"Steel", "Flying"}, 9.2, 999.9, 
                "It appeared from the Ultra Wormhole. One kind of Ultra Beast, witnesses saw it flying across the sky at high speed."));
        pokemonDatabase.put(798, new Pokemon("Kartana", new String[]{"Grass", "Steel"}, 0.3, 0.1, 
                "This Ultra Beast came from the Ultra Wormhole. It seems not to attack enemies on its own, but its sharp body is a dangerous weapon in itself."));
        pokemonDatabase.put(799, new Pokemon("Guzzlord", new String[]{"Dark", "Dragon"}, 5.5, 888.0, 
                "A dangerous Ultra Beast, it has gobbled mountains and swallowed whole buildings, according to reports."));
        pokemonDatabase.put(800, new Pokemon("Necrozma", new String[]{"Psychic"}, 2.4, 230.0, 
                "Reminiscent of the Ultra Beasts, this life-form, apparently asleep underground, is thought to have come from another world in ancient times."));
        pokemonDatabase.put(801, new Pokemon("Magearna", new String[]{"Steel", "Fairy"}, 1.0, 80.5, 
                "This artificial Pokémon, constructed more than 500 years ago, can understand human speech but cannot itself speak."));
        pokemonDatabase.put(802, new Pokemon("Marshadow", new String[]{"Fighting", "Ghost"}, 0.7, 22.2, 
                "It sinks into the shadows of people and Pokémon, where it can understand their feelings and copy their capabilities."));
        pokemonDatabase.put(803, new Pokemon("Poipole", new String[]{"Poison"}, 0.6, 1.8, 
                "This Ultra Beast is well enough liked to be chosen as a first partner in its own world."));
        pokemonDatabase.put(804, new Pokemon("Naganadel", new String[]{"Poison", "Dragon"}, 3.6, 150.0, 
                "It stores hundreds of liters of poisonous liquid inside its body. It is one of the organisms known as UBs."));
        pokemonDatabase.put(805, new Pokemon("Stakataka", new String[]{"Rock", "Steel"}, 5.5, 820.0, 
                "It appeared from an Ultra Wormhole. Each one appears to be made up of many life-forms stacked one on top of each other."));
        pokemonDatabase.put(806, new Pokemon("Blacephalon", new String[]{"Fire", "Ghost"}, 1.8, 13.0, 
                "It slithers toward people. Then, without warning, it triggers the explosion of its own head. It's apparently one kind of Ultra Beast."));
        pokemonDatabase.put(807, new Pokemon("Zeraora", new String[]{"Electric"}, 1.5, 44.5, 
                "It electrifies its claws and tears its opponents apart with them. Even if they dodge its attack, they'll be electrocuted by the flying sparks."));
        pokemonDatabase.put(808, new Pokemon("Meltan", new String[]{"Steel"}, 0.2, 8.0, 
                "It melts particles of iron and other metals found in the subsoil, so it can absorb them into its body of molten steel."));
        pokemonDatabase.put(809, new Pokemon("Melmetal", new String[]{"Steel"}, 2.5, 800.0, 
                "Revered long ago for its capacity to create iron from nothing, for some reason it has come back to life after 3,000 years."));

        // Note: In a complete implementation, add entries for all 88 Alola Pokémon
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
