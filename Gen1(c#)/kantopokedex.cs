using System;
using System.Collections.Generic;

namespace KantoPokedex
{
    class Program
    {
        private static Dictionary<int, Pokemon> pokemonDatabase = new Dictionary<int, Pokemon>();

        static void Main(string[] args)
        {
            InitializePokedex();
            
            Console.WriteLine("Welcome to the Kanto Pokédex!");
            Console.WriteLine("Featuring the original 151 Pokémon from Generation 1.");
            
            bool running = true;
            while (running)
            {
                Console.Write("\nEnter a Pokémon number (1-151) or 0 to exit: ");
                
                try
                {
                    int pokemonNumber = int.Parse(Console.ReadLine());
                    
                    if (pokemonNumber == 0)
                    {
                        running = false;
                        Console.WriteLine("Thank you for using the Pokédex!");
                    }
                    else if (pokemonNumber < 1 || pokemonNumber > 151)
                    {
                        Console.WriteLine("Invalid Pokémon number. Please enter a number between 1 and 151.");
                    }
                    else
                    {
                        DisplayPokemonInfo(pokemonNumber);
                    }
                }
                catch (FormatException)
                {
                    Console.WriteLine("Please enter a valid number.");
                }
            }
        }
        
        private static void DisplayPokemonInfo(int pokemonNumber)
        {
            if (pokemonDatabase.TryGetValue(pokemonNumber, out Pokemon pokemon))
            {
                Console.WriteLine($"\n===== POKÉMON #{pokemonNumber} =====");
                Console.WriteLine($"Name: {pokemon.Name}");
                Console.WriteLine($"Type: {string.Join("/", pokemon.Types)}");
                Console.WriteLine($"Height: {pokemon.Height} m");
                Console.WriteLine($"Weight: {pokemon.Weight} kg");
                Console.WriteLine($"Description: {pokemon.Description}");
                Console.WriteLine("=======================");
            }
            else
            {
                Console.WriteLine($"Pokémon #{pokemonNumber} data not available.");
            }
        }
        
        private static void InitializePokedex()
        {
            // Bulbasaur evolution line
            pokemonDatabase.Add(1, new Pokemon("Bulbasaur", new string[] {"Grass", "Poison"}, 0.7, 6.9, 
                "A strange seed was planted on its back at birth. The plant sprouts and grows with this Pokémon."));
            pokemonDatabase.Add(2, new Pokemon("Ivysaur", new string[] {"Grass", "Poison"}, 1.0, 13.0, 
                "When the bulb on its back grows large, it appears to lose the ability to stand on its hind legs."));
            pokemonDatabase.Add(3, new Pokemon("Venusaur", new string[] {"Grass", "Poison"}, 2.0, 100.0, 
                "The plant blooms when it is absorbing solar energy. It stays on the move to seek sunlight."));
            
            // Charmander evolution line
            pokemonDatabase.Add(4, new Pokemon("Charmander", new string[] {"Fire"}, 0.6, 8.5, 
                "From the time it is born, a flame burns at the tip of its tail. Its life would end if the flame were to go out."));
            pokemonDatabase.Add(5, new Pokemon("Charmeleon", new string[] {"Fire"}, 1.1, 19.0, 
                "When it swings its burning tail, it elevates the temperature to unbearably high levels."));
            pokemonDatabase.Add(6, new Pokemon("Charizard", new string[] {"Fire", "Flying"}, 1.7, 90.5, 
                "Spits fire that is hot enough to melt boulders. Known to cause forest fires unintentionally."));
            
            // Squirtle evolution line
            pokemonDatabase.Add(7, new Pokemon("Squirtle", new string[] {"Water"}, 0.5, 9.0, 
                "When it retracts its long neck into its shell, it squirts out water with vigorous force."));
            pokemonDatabase.Add(8, new Pokemon("Wartortle", new string[] {"Water"}, 1.0, 22.5, 
                "It is recognized as a symbol of longevity. If its shell has algae on it, that Wartortle is very old."));
            pokemonDatabase.Add(9, new Pokemon("Blastoise", new string[] {"Water"}, 1.6, 85.5, 
                "It crushes its foe under its heavy body to cause fainting. In a pinch, it will withdraw inside its shell."));
            
            // Caterpie evolution line
            pokemonDatabase.Add(10, new Pokemon("Caterpie", new string[] {"Bug"}, 0.3, 2.9, 
                "Its short feet are tipped with suction pads that enable it to tirelessly climb slopes and walls."));
            pokemonDatabase.Add(11, new Pokemon("Metapod", new string[] {"Bug"}, 0.7, 9.9, 
                "This Pokémon is vulnerable to attack while its shell is soft, exposing its weak and tender body."));
            pokemonDatabase.Add(12, new Pokemon("Butterfree", new string[] {"Bug", "Flying"}, 1.1, 32.0, 
                "In battle, it flaps its wings at great speed to release highly toxic dust into the air."));
            
            // Weedle evolution line
            pokemonDatabase.Add(13, new Pokemon("Weedle", new string[] {"Bug", "Poison"}, 0.3, 3.2, 
                "Often found in forests, eating leaves. It has a sharp venomous stinger on its head."));
            pokemonDatabase.Add(14, new Pokemon("Kakuna", new string[] {"Bug", "Poison"}, 0.6, 10.0, 
                "Almost incapable of moving, this Pokémon can only harden its shell to protect itself."));
            pokemonDatabase.Add(15, new Pokemon("Beedrill", new string[] {"Bug", "Poison"}, 1.0, 29.5, 
                "It has three poisonous stingers on its forelegs and its tail. They are used to jab its enemy repeatedly."));
            
            // Pidgey evolution line
            pokemonDatabase.Add(16, new Pokemon("Pidgey", new string[] {"Normal", "Flying"}, 0.3, 1.8, 
                "A common sight in forests and woods. It flaps its wings at ground level to kick up blinding sand."));
            pokemonDatabase.Add(17, new Pokemon("Pidgeotto", new string[] {"Normal", "Flying"}, 1.1, 30.0, 
                "Very protective of its sprawling territorial area, this Pokémon will fiercely peck at any intruder."));
            pokemonDatabase.Add(18, new Pokemon("Pidgeot", new string[] {"Normal", "Flying"}, 1.5, 39.5, 
                "This Pokémon has a dazzling plumage of beautifully glossy feathers. Many Trainers are captivated by the striking beauty of the feathers on its head."));
            
            // Rattata evolution line
            pokemonDatabase.Add(19, new Pokemon("Rattata", new string[] {"Normal"}, 0.3, 3.5, 
                "Will chew on anything with its fangs. If you see one, it is certain that 40 more live in the area."));
            pokemonDatabase.Add(20, new Pokemon("Raticate", new string[] {"Normal"}, 0.7, 18.5, 
                "Its hind feet are webbed. They act as flippers, so it can swim in rivers and hunt for prey."));
            
            // Pikachu evolution line
            pokemonDatabase.Add(25, new Pokemon("Pikachu", new string[] {"Electric"}, 0.4, 6.0, 
                "When several of these Pokémon gather, their electricity could build and cause lightning storms."));
            pokemonDatabase.Add(26, new Pokemon("Raichu", new string[] {"Electric"}, 0.8, 30.0, 
                "Its long tail serves as a ground to protect itself from its own high-voltage power."));
            
            // Adding more popular Gen 1 Pokemon
            pokemonDatabase.Add(143, new Pokemon("Snorlax", new string[] {"Normal"}, 2.1, 460.0, 
                "Very lazy. Just eats and sleeps. As its rotund bulk builds, it becomes steadily more slothful."));
            
            pokemonDatabase.Add(144, new Pokemon("Articuno", new string[] {"Ice", "Flying"}, 1.7, 55.4, 
                "A legendary bird Pokémon that can control ice. The flapping of its wings chills the air. As a result, it is said that when this Pokémon flies, snow will fall."));
            
            pokemonDatabase.Add(145, new Pokemon("Zapdos", new string[] {"Electric", "Flying"}, 1.6, 52.6, 
                "A legendary bird Pokémon that has the ability to control electricity. It usually lives in thunderclouds. The Pokémon gains power if it is stricken by lightning bolts."));
            
            pokemonDatabase.Add(146, new Pokemon("Moltres", new string[] {"Fire", "Flying"}, 2.0, 60.0, 
                "A legendary bird Pokémon that can control fire. If injured, it is said to dip its body in the molten magma of a volcano to burn and heal itself."));
            
            pokemonDatabase.Add(150, new Pokemon("Mewtwo", new string[] {"Psychic"}, 2.0, 122.0, 
                "A Pokémon created by genetic manipulation. Even though the scientific power of humans created this Pokémon's body, they failed to endow Mewtwo with a compassionate heart."));
            
            pokemonDatabase.Add(151, new Pokemon("Mew", new string[] {"Psychic"}, 0.4, 4.0, 
                "When viewed through a microscope, this Pokémon's short, fine, delicate hair can be seen."));
            
            // Note: In a complete implementation, add entries for all 151 Pokémon
        }
    }

    class Pokemon
    {
        public string Name { get; }
        public string[] Types { get; }
        public double Height { get; } // in meters
        public double Weight { get; } // in kg
        public string Description { get; }
        
        public Pokemon(string name, string[] types, double height, double weight, string description)
        {
            Name = name;
            Types = types;
            Height = height;
            Weight = weight;
            Description = description;
        }
    }
}