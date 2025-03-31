import java.sql.*;
import java.util.Scanner;

public class Gen1Pokedex {
    // Database connection information
    private static final String DB_URL = "jdbc:sqlite:pokedex.db";
    
    public static void main(String[] args) {
        createDatabase();
        populateDatabase();
        
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
    
    private static void createDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            
            // Create Pokemon table if it doesn't exist
            String sql = "CREATE TABLE IF NOT EXISTS pokemon (" +
                         "id INTEGER PRIMARY KEY," +
                         "name TEXT NOT NULL," +
                         "primary_type TEXT NOT NULL," +
                         "secondary_type TEXT," +
                         "height_m REAL," +
                         "weight_kg REAL," +
                         "description TEXT" +
                         ");";
            
            stmt.execute(sql);
            System.out.println("Database initialized successfully.");
            
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    
    private static void populateDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            
            // Check if database is already populated
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM pokemon");
            if (rs.next() && rs.getInt(1) > 0) {
                return; // Database already populated
            }
            
            // Populate with Gen 1 Pokémon
            String[][] pokemonData = {
                // id, name, primary_type, secondary_type, height_m, weight_kg, description
                {"1", "Bulbasaur", "Grass", "Poison", "0.7", "6.9", "A strange seed was planted on its back at birth. The plant sprouts and grows with this Pokémon."},
                {"2", "Ivysaur", "Grass", "Poison", "1.0", "13.0", "When the bulb on its back grows large, it appears to lose the ability to stand on its hind legs."},
                {"3", "Venusaur", "Grass", "Poison", "2.0", "100.0", "The plant blooms when it is absorbing solar energy. It stays on the move to seek sunlight."},
                {"4", "Charmander", "Fire", null, "0.6", "8.5", "From the time it is born, a flame burns at the tip of its tail. Its life would end if the flame were to go out."},
                {"5", "Charmeleon", "Fire", null, "1.1", "19.0", "When it swings its burning tail, it elevates the temperature to unbearably high levels."},
                {"6", "Charizard", "Fire", "Flying", "1.7", "90.5", "Spits fire that is hot enough to melt boulders. Known to cause forest fires unintentionally."},
                {"7", "Squirtle", "Water", null, "0.5", "9.0", "When it retracts its long neck into its shell, it squirts out water with vigorous force."},
                {"8", "Wartortle", "Water", null, "1.0", "22.5", "It is recognized as a symbol of longevity. If its shell has algae on it, that Wartortle is very old."},
                {"9", "Blastoise", "Water", null, "1.6", "85.5", "It crushes its foe under its heavy body to cause fainting. In a pinch, it will withdraw inside its shell."},
                {"10", "Caterpie", "Bug", null, "0.3", "2.9", "Its short feet are tipped with suction pads that enable it to tirelessly climb slopes and walls."},
                {"11", "Metapod", "Bug", null, "0.7", "9.9", "This Pokémon is vulnerable to attack while its shell is soft, exposing its weak and tender body."},
                {"12", "Butterfree", "Bug", "Flying", "1.1", "32.0", "In battle, it flaps its wings at great speed to release highly toxic dust into the air."},
                {"25", "Pikachu", "Electric", null, "0.4", "6.0", "When several of these Pokémon gather, their electricity could build and cause lightning storms."},
                {"26", "Raichu", "Electric", null, "0.8", "30.0", "Its long tail serves as a ground to protect itself from its own high-voltage power."},
                {"150", "Mewtwo", "Psychic", null, "2.0", "122.0", "A Pokémon that was created by genetic manipulation. However, even though the scientific power of humans created this Pokémon's body, they failed to endow Mewtwo with a compassionate heart."},
                {"151", "Mew", "Psychic", null, "0.4", "4.0", "When viewed through a microscope, this Pokémon's short, fine, delicate hair can be seen."}
                // Add the rest of the Gen 1 Pokémon here (this is a subset for brevity)
            };
            
            String insertSQL = "INSERT INTO pokemon (id, name, primary_type, secondary_type, height_m, weight_kg, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            
            for (String[] pokemon : pokemonData) {
                pstmt.setInt(1, Integer.parseInt(pokemon[0]));
                pstmt.setString(2, pokemon[1]);
                pstmt.setString(3, pokemon[2]);
                pstmt.setString(4, pokemon[3]);
                pstmt.setDouble(5, Double.parseDouble(pokemon[4]));
                pstmt.setDouble(6, Double.parseDouble(pokemon[5]));
                pstmt.setString(7, pokemon[6]);
                pstmt.executeUpdate();
            }
            
            System.out.println("Database populated with Generation 1 Pokémon.");
            
        } catch (SQLException e) {
            System.out.println("Database population error: " + e.getMessage());
        }
    }
    
    private static void displayPokemonInfo(int pokemonNumber) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM pokemon WHERE id = ?")) {
            
            pstmt.setInt(1, pokemonNumber);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("\n===== POKÉMON #" + rs.getInt("id") + " =====");
                System.out.println("Name: " + rs.getString("name"));
                
                // Format type display
                String type = rs.getString("primary_type");
                String secondaryType = rs.getString("secondary_type");
                if (secondaryType != null) {
                    type += "/" + secondaryType;
                }
                System.out.println("Type: " + type);
                
                System.out.println("Height: " + rs.getDouble("height_m") + " m");
                System.out.println("Weight: " + rs.getDouble("weight_kg") + " kg");
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("=======================");
            } else {
                System.out.println("Pokémon #" + pokemonNumber + " data not available.");
            }
            
        } catch (SQLException e) {
            System.out.println("Database query error: " + e.getMessage());
        }
    }
}
