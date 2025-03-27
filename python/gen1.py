import sqlite3
import requests

# Function to fetch Pokémon data from PokéAPI
def fetch_pokemon_data(pokemon_id):
    url = f"https://pokeapi.co/api/v2/pokemon/{pokemon_id}"
    response = requests.get(url)
    if response.status_code == 200:
        data = response.json()
        name = data["name"].capitalize()
        types = [t["type"]["name"].capitalize() for t in data["types"]]
        type1 = types[0]
        type2 = types[1] if len(types) > 1 else None
        hp = data["stats"][0]["base_stat"]
        attack = data["stats"][1]["base_stat"]
        defense = data["stats"][2]["base_stat"]
        speed = data["stats"][5]["base_stat"]
        return (pokemon_id, name, type1, type2, hp, attack, defense, speed)
    else:
        return None

# Create database and table
def create_database():
    conn = sqlite3.connect("pokedex.db")
    cursor = conn.cursor()
    
    cursor.execute('''CREATE TABLE IF NOT EXISTS pokemon (
                        id INTEGER PRIMARY KEY,
                        name TEXT,
                        type1 TEXT,
                        type2 TEXT,
                        hp INTEGER,
                        attack INTEGER,
                        defense INTEGER,
                        speed INTEGER
                    )''')

    conn.commit()
    conn.close()

# Populate the database with all 151 Pokémon
def populate_database():
    conn = sqlite3.connect("pokedex.db")
    cursor = conn.cursor()
    
    for i in range(1, 152):  # Fetch Pokémon 1 to 151
        pokemon = fetch_pokemon_data(i)
        if pokemon:
            cursor.execute("INSERT OR IGNORE INTO pokemon VALUES (?, ?, ?, ?, ?, ?, ?, ?)", pokemon)
            print(f"Added {pokemon[1]} to database.")
    
    conn.commit()
    conn.close()

# Search Pokémon in the database
def search_pokemon(identifier):
    conn = sqlite3.connect("pokedex.db")
    cursor = conn.cursor()
    
    if isinstance(identifier, int):
        cursor.execute("SELECT * FROM pokemon WHERE id = ?", (identifier,))
    else:
        cursor.execute("SELECT * FROM pokemon WHERE name = ?", (identifier.capitalize(),))
    
    pokemon = cursor.fetchone()
    conn.close()
    
    if pokemon:
        return {
            "ID": pokemon[0],
            "Name": pokemon[1],
            "Type 1": pokemon[2],
            "Type 2": pokemon[3],
            "HP": pokemon[4],
            "Attack": pokemon[5],
            "Defense": pokemon[6],
            "Speed": pokemon[7]
        }
    else:
        return "Pokémon not found."

if __name__ == "__main__":
    create_database()
    populate_database()
    while True:
        query = input("Enter Pokémon name or ID (or 'exit' to quit): ")
        if query.lower() == "exit":
            break
        try:
            query = int(query)
        except ValueError:
            pass
        
        result = search_pokemon(query)
        print(result)