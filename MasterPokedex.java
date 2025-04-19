import java.util.*;

/**
 * MasterPokedex - Unifies all regional Pokédex data from Gen 1 to Gen 9
 * Provides simple ID-based search functionality across all regions
 */
public class MasterPokedex {
    private Map<Integer, Pokemon> allPokemonById;
    
    public MasterPokedex() {
        allPokemonById = new HashMap<>();
        loadAllPokedexes();
    }
    
    private void loadAllPokedexes() {
        // Load all regional Pokédexes and merge their data
        System.out.println("Loading all regional Pokédex data...");
        
        try {
            // We'll use reflection to handle each regional Pokédex class directly
            addPokemonFromPokedex("KantoPokedex");   // Gen 1
            addPokemonFromPokedex("JohtoPokedex");   // Gen 2
            addPokemonFromPokedex("HoennPokedex");   // Gen 3
            addPokemonFromPokedex("SinnohPokedex");  // Gen 4
            addPokemonFromPokedex("UnovaPokedex");   // Gen 5
            addPokemonFromPokedex("KalosPokedex");   // Gen 6
            addPokemonFromPokedex("AlolaPokedex");   // Gen 7
            addPokemonFromPokedex("GalarPokedex");   // Gen 8
            addPokemonFromPokedex("PaldeaPokedex");  // Gen 9
            
            System.out.println("All Pokédex data loaded successfully!");
            System.out.println("Total Pokémon entries: " + allPokemonById.size());
        } catch (Exception e) {
            System.out.println("Error loading Pokédex data: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    private void addPokemonFromPokedex(String className) {
        try {
            // Create an instance of the regional Pokédex class
            Class<?> pokedexClass = Class.forName(className);
            Object pokedex = pokedexClass.getDeclaredConstructor().newInstance();
            
            // Get the region name using reflection
            String regionName = "";
            try {
                java.lang.reflect.Method getRegionMethod = pokedexClass.getMethod("getRegionName");
                regionName = (String) getRegionMethod.invoke(pokedex);
            } catch (NoSuchMethodException e) {
                // If getRegionName doesn't exist, try to derive from class name
                regionName = className.replace("Pokedex", "");
            }
            
            // Get generation number (if method exists)
            int generation = 0;
            try {
                java.lang.reflect.Method getGenMethod = pokedexClass.getMethod("getGeneration");
                generation = (int) getGenMethod.invoke(pokedex);
            } catch (NoSuchMethodException e) {
                // Estimate generation based on class name order
                switch(className) {
                    case "KantoPokedex": generation = 1; break;
                    case "JohtoPokedex": generation = 2; break;
                    case "HoennPokedex": generation = 3; break;
                    case "SinnohPokedex": generation = 4; break;
                    case "UnovaPokedex": generation = 5; break;
                    case "KalosPokedex": generation = 6; break;
                    case "AlolaPokedex": generation = 7; break;
                    case "GalarPokedex": generation = 8; break;
                    case "PaldeaPokedex": generation = 9; break;
                }
            }
            
            // Get all Pokémon from this regional Pokédex using the most common method names
            List<Pokemon> pokemonList = null;
            
            // Try different possible method names for getting all Pokémon
            for (String methodName : new String[]{"getAllPokemon", "getPokemonList", "getAll", "getPokemons"}) {
                try {
                    java.lang.reflect.Method getAllMethod = pokedexClass.getMethod(methodName);
                    pokemonList = (List<Pokemon>) getAllMethod.invoke(pokedex);
                    break;
                } catch (NoSuchMethodException e) {
                    // Try next method name
                    continue;
                }
            }
            
            // If we couldn't get the Pokémon list through common methods
            if (pokemonList == null) {
                System.out.println("Warning: Couldn't find method to get Pokémon list from " + className);
                return;
            }
            
            // Add all Pokémon to our master map
            for (Pokemon pokemon : pokemonList) {
                allPokemonById.put(pokemon.getId(), pokemon);
            }
            
            System.out.println("Loaded " + regionName + " Pokédex with " + 
                    pokemonList.size() + " Pokémon (Generation " + generation + ")");
                    
        } catch (ClassNotFoundException e) {
            System.out.println("Warning: " + className + " class not found. Skipping.");
        } catch (Exception e) {
            System.out.println("Error processing " + className + ": " + e.getMessage());
        }
    }
    
    // The only search function we're implementing: search by ID
    public Pokemon getPokemonById(int id) {
        return allPokemonById.get(id);
    }
    
    // Main method to run the program
    public static void main(String[] args) {
        MasterPokedex pokedex = new MasterPokedex();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        System.out.println("\nWelcome to the Complete Pokédex (Gen 1-9)!");
        System.out.println("This program allows you to search for any Pokémon by ID number.");
        
        while (running) {
            System.out.print("\nEnter a Pokémon ID (or 0 to exit): ");
            
            int id;
            try {
                id = Integer.parseInt(scanner.nextLine());
                
                if (id == 0) {
                    running = false;
                    System.out.println("Thank you for using the Complete Pokédex!");
                } else {
                    Pokemon pokemon = pokedex.getPokemonById(id);
                    
                    if (pokemon != null) {
                        displayPokemonDetails(pokemon);
                    } else {
                        System.out.println("No Pokémon found with ID: " + id);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        
        scanner.close();
    }
    
    // Helper method to display Pokémon details
    private static void displayPokemonDetails(Pokemon pokemon) {
        System.out.println("\n=============================");
        System.out.println("Pokémon #" + pokemon.getId() + ": " + pokemon.getName());
        
        // Try to get types - handle different potential method names
        try {
            String[] types = pokemon.getTypes();
            if (types != null) {
                System.out.println("Types: " + String.join("/", types));
            }
        } catch (Exception e) {
            // If getTypes() doesn't work, try alternative methods
            try {
                // First try getType() if it returns String[]
                java.lang.reflect.Method getTypeMethod = pokemon.getClass().getMethod("getType");
                Object typeObj = getTypeMethod.invoke(pokemon);
                if (typeObj instanceof String[]) {
                    String[] types = (String[]) typeObj;
                    System.out.println("Types: " + String.join("/", types));
                } else if (typeObj != null) {
                    System.out.println("Type: " + typeObj);
                }
            } catch (Exception e2) {
                // If that fails, try individual type getters
                try {
                    String type1 = (String) pokemon.getClass().getMethod("getType1").invoke(pokemon);
                    try {
                        String type2 = (String) pokemon.getClass().getMethod("getType2").invoke(pokemon);
                        if (type2 != null && !type2.isEmpty()) {
                            System.out.println("Types: " + type1 + "/" + type2);
                        } else {
                            System.out.println("Type: " + type1);
                        }
                    } catch (Exception e3) {
                        System.out.println("Type: " + type1);
                    }
                } catch (Exception e3) {
                    // Give up on types if we can't find any type methods
                }
            }
        }
        
        // Try to display region name
        try {
            String regionName = (String) pokemon.getClass().getMethod("getRegionName").invoke(pokemon);
            if (regionName != null && !regionName.isEmpty()) {
                System.out.println("Region: " + regionName);
            }
        } catch (Exception e) {
            // Region name not available
        }
        
        // Try to display generation
        try {
            int generation = (int) pokemon.getClass().getMethod("getGeneration").invoke(pokemon);
            System.out.println("Generation: " + generation);
        } catch (Exception e) {
            // Generation not available
        }
        
        // Try to display description
        try {
            String description = (String) pokemon.getClass().getMethod("getDescription").invoke(pokemon);
            if (description != null && !description.isEmpty()) {
                System.out.println("Description: " + description);
            }
        } catch (Exception e) {
            // Description not available
        }
        
        System.out.println("=============================");
    }
}
