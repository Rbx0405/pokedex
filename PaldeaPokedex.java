import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PaldeaPokedex {
    private static final Map<Integer, Pokemon> pokemonDatabase = new HashMap<>();

    public static void main(String[] args) {
        initializePokedex();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Paldea Pokédex!");
        System.out.println("Featuring the 120 new Pokémon from Generation 9 (National Dex #906-1025).");
        
        while (true) {
            System.out.print("\nEnter a National Pokédex number (906-1025) or 0 to exit: ");
            try {
                int pokemonNumber = scanner.nextInt();
                
                if (pokemonNumber == 0) {
                    System.out.println("Thank you for using the Pokédex!");
                    break;
                } else if (pokemonNumber < 906 || pokemonNumber > 1025) {
                    System.out.println("Invalid Pokémon number. Please enter a number between 906 and 1025.");
                } else {
                    displayPokemonInfo(pokemonNumber);
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        scanner.close();
    }
    
    private static void displayPokemonInfo(int pokemonNumber) {
        Pokemon pokemon = pokemonDatabase.get(pokemonNumber);
        
        if (pokemon != null) {
            System.out.println("=======================");
            System.out.println("===== POKÉMON #" + pokemonNumber + " =====");
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
        // Starter Pokémon and their evolutions
        pokemonDatabase.put(906, new Pokemon("Sprigatito", new String[]{"Grass"}, 0.4, 4.1, 
            "Its fluffy fur is similar in composition to plants. This Pokémon frequently washes its face to keep its fur clean."));
        
        pokemonDatabase.put(907, new Pokemon("Floragato", new String[]{"Grass"}, 0.9, 12.2, 
            "The hardened vines in its fluffy fur can be utilized like an extension of its body. It uses these vines in battle."));
        
        pokemonDatabase.put(908, new Pokemon("Meowscarada", new String[]{"Grass", "Dark"}, 1.5, 31.2, 
            "This Pokémon uses the reflective fur lining its cape to camouflage itself and confuse opponents with mirror images."));
        
        pokemonDatabase.put(909, new Pokemon("Fuecoco", new String[]{"Fire"}, 0.4, 9.8, 
            "It relaxes by gently warming its square-shaped belly with heat from its flame sac. This helps with digestion too."));
        
        pokemonDatabase.put(910, new Pokemon("Crocalor", new String[]{"Fire"}, 1.0, 30.7, 
            "The valve in its flame sac can open and close to regulate internal temperature, creating explosive sounds at times."));
        
        pokemonDatabase.put(911, new Pokemon("Skeledirge", new String[]{"Fire", "Ghost"}, 1.6, 326.5, 
            "The singer atop its head uses ghost flames to control this Pokémon. Its external appearance hides a gentler nature."));
        
        pokemonDatabase.put(912, new Pokemon("Quaxly", new String[]{"Water"}, 0.5, 6.1, 
            "The glossy gel coating its body helps it to retain water and stay consistently moist. It carefully maintains its coif."));
        
        pokemonDatabase.put(913, new Pokemon("Quaxwell", new String[]{"Water"}, 1.2, 21.5, 
            "Though it still can't fly, its strong legs let it swim powerfully through water. The strength of its kicks surprises foes."));
        
        pokemonDatabase.put(914, new Pokemon("Quaquaval", new String[]{"Water", "Fighting"}, 1.8, 61.9, 
            "Its strength and dance moves reach their full potential when cheered by allies. It values its feathers and grooms meticulously."));
        
        // Other notable Paldea Pokémon
        pokemonDatabase.put(915, new Pokemon("Lechonk", new String[]{"Normal"}, 0.5, 10.2, 
            "Using its keen sense of smell, it can find fragrant wild grass and berries. Its body gives off a bacon-like aroma."));
        
        pokemonDatabase.put(916, new Pokemon("Oinkologne", new String[]{"Normal"}, 1.0, 120.0, 
            "The male emits a pleasant aroma, while the female's scent has a soothing effect on those who smell it."));
        
        pokemonDatabase.put(921, new Pokemon("Pawmi", new String[]{"Electric"}, 0.3, 2.2, 
            "The pads on its cheeks generate electricity. When in danger, it creates an electric barrier by rubbing its cheeks."));
        
        pokemonDatabase.put(922, new Pokemon("Pawmo", new String[]{"Electric", "Fighting"}, 0.4, 6.5, 
            "When its fur stores enough electricity, this Pokémon will evolve. Until then, it trains by running and generating power."));
        
        pokemonDatabase.put(923, new Pokemon("Pawmot", new String[]{"Electric", "Fighting"}, 0.9, 41.0, 
            "When its fur stands on end after building up electricity, this Pokémon can unleash a burst of lightning strikes from its arms."));
        
        pokemonDatabase.put(924, new Pokemon("Tandemaus", new String[]{"Normal"}, 0.3, 1.8, 
            "These two Pokémon are always found together. Their food-storage cheek pouches are packed with nutrition."));
        
        pokemonDatabase.put(925, new Pokemon("Maushold", new String[]{"Normal"}, 0.3, 2.3, 
            "This family of Pokémon lives together as a group. The little ones mimic their parent's movements to learn how to forage."));
        
        pokemonDatabase.put(926, new Pokemon("Fidough", new String[]{"Fairy"}, 0.3, 10.9, 
            "This Pokémon's moist, smooth skin has a unique texture similar to dough. Its breath contains yeast to help fermentation."));
        
        pokemonDatabase.put(927, new Pokemon("Dachsbun", new String[]{"Fairy"}, 0.5, 14.9, 
            "Its sweet scent captivates people. Long ago, aristocrats would compete to see who could create the most fragrant Dachsbun."));
        
        pokemonDatabase.put(928, new Pokemon("Smoliv", new String[]{"Grass", "Normal"}, 0.3, 6.5, 
            "The oil that seeps from its head has a bitter taste, but it's treasured for cooking because of the flavor it imparts."));
        
        pokemonDatabase.put(929, new Pokemon("Dolliv", new String[]{"Grass", "Normal"}, 0.6, 11.9, 
            "The oil it produces from the fruit on its head gradually becomes more flavorful and complex as it matures."));
        
        pokemonDatabase.put(930, new Pokemon("Arboliva", new String[]{"Grass", "Normal"}, 1.4, 48.2, 
            "The oil that comes from its fruit is a top-quality product essential for fine cooking. This Pokémon is a valuable agricultural resource."));
        
        // Legendary Pokémon
        pokemonDatabase.put(1000, new Pokemon("Gholdengo", new String[]{"Steel", "Ghost"}, 1.2, 30.0, 
            "This Pokémon is made of 1,000 coins. It uses its power to control its coins in battle, launching them at foes in rapid succession."));
        
        pokemonDatabase.put(1001, new Pokemon("Wo-Chien", new String[]{"Dark", "Grass"}, 1.5, 74.2, 
            "This Pokémon arrived from the past. It can restore withered plants by using its golden grains to absorb the life energy of other creatures."));
        
        pokemonDatabase.put(1002, new Pokemon("Chien-Pao", new String[]{"Dark", "Ice"}, 1.9, 152.2, 
            "This Pokémon arrived from the past. It ambushes prey by submerging its entire body in snow and clamping down with its powerful jaw."));
        
        pokemonDatabase.put(1003, new Pokemon("Ting-Lu", new String[]{"Dark", "Ground"}, 2.7, 699.7, 
            "This Pokémon arrived from the past. It compresses the nutrients it extracts from fallen leaves and soil into orbs that sustain it."));
        
        pokemonDatabase.put(1004, new Pokemon("Chi-Yu", new String[]{"Dark", "Fire"}, 0.4, 4.9, 
            "This Pokémon arrived from the past. It has a flame sac within its small body that produces flames exceeding 5,400 degrees Fahrenheit."));
        
        pokemonDatabase.put(1005, new Pokemon("Roaring Moon", new String[]{"Dragon", "Dark"}, 2.0, 380.0, 
            "This Pokémon resembles an ancient form of Salamence. It soars through the skies on its moon-shaped wings, striking fear into opponents."));
        
        pokemonDatabase.put(1006, new Pokemon("Iron Valiant", new String[]{"Fairy", "Fighting"}, 1.4, 35.0, 
            "This Pokémon appears to be a fusion of Gardevoir and Gallade. It creates psychic blades that can cut through almost anything."));
        
        pokemonDatabase.put(1007, new Pokemon("Koraidon", new String[]{"Fighting", "Dragon"}, 2.5, 303.0, 
            "This Pokémon represents the past. Its powerful legs allow it to traverse any terrain. It's said to have opened the way for life in Paldea."));
        
        pokemonDatabase.put(1008, new Pokemon("Miraidon", new String[]{"Electric", "Dragon"}, 3.5, 240.0, 
            "This Pokémon represents the future. Its body can generate tremendous energy. It's said to have created the energy sources used in Paldea."));
    }
}

class Pokemon {
    private String name;
    private String[] types;
    private double height;
    private double weight;
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
