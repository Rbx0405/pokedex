import java.util.Scanner;

/**
 * JohtoPokedex - A Java program showing Johto Pokémon by number with descriptions
 */
public class JohtoPokedex {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("==== Johto Pokédex ====");
        System.out.println("Enter a Pokémon number (152-251) or 0 to exit:");
        
        while (true) {
            System.out.print("> ");
            int number;
            
            try {
                number = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }
            
            if (number == 0) {
                System.out.println("Exiting Johto Pokédex. Goodbye!");
                break;
            }
            
            String pokemon = getPokemonByNumber(number);
            System.out.println(pokemon);
        }
        
        scanner.close();
    }
    
    private static String getPokemonByNumber(int number) {
        switch (number) {
            case 152: return "#152 Chikorita (Grass)\nA sweet-scented leaf grows from its head. In battle, Chikorita waves its leaf around to keep the foe at bay, but in gentler moments, the leaf produces a soothing fragrance that creates a cozy, friendly atmosphere all around.";
            case 153: return "#153 Bayleef (Grass)\nBayleef emits a spicy aroma from the leaves around its neck and plays using them. A Bayleef's leaves have healing powers and emit an aroma that can soothe sick people and invigorate those who inhale it.";
            case 154: return "#154 Meganium (Grass)\nThe fragrance of Meganium's flower soothes and calms emotions. In battle, it gives off more of its becalming scent to blunt the foe's fighting spirit. The aroma that rises from its petals contains a substance that calms aggressive feelings.";
            case 155: return "#155 Cyndaquil (Fire)\nCyndaquil protects itself by flaring up the flames on its back. The flames are vigorous if the Pokémon is angry. However, if it is tired, the flames splutter fitfully with incomplete combustion.";
            case 156: return "#156 Quilava (Fire)\nQuilava keeps its foes at bay with the intensity of its flames and gusts of superheated air. This Pokémon applies its outstanding nimbleness to dodge attacks even while scorching the foe with flames.";
            case 157: return "#157 Typhlosion (Fire)\nTyphlosion obscures itself behind a shimmering heat haze that it creates using its intensely hot flames. This Pokémon creates blazing explosive blasts that burn everything to cinders.";
            case 158: return "#158 Totodile (Water)\nDespite its small body, Totodile's jaws are very powerful. While it may think it's just playfully nipping, its bite has enough strength to cause serious injury, so care must be taken with this Pokémon.";
            case 159: return "#159 Croconaw (Water)\nOnce Croconaw has clamped its jaws on its foe, it will absolutely not let go. Because the tips of its fangs are forked back like barbed fishhooks, they become impossible to remove once they have sunk in.";
            case 160: return "#160 Feraligatr (Water)\nFeraligatr intimidates its foes by opening its huge mouth. In battle, it will kick the ground hard with its thick and powerful hind legs to charge at the foe at an incredible speed.";
            case 161: return "#161 Sentret (Normal)\nWhen Sentret sleeps, it does so while others stand guard. The sentry wakes the others at the first sign of danger. When this Pokémon becomes separated from its pack, it becomes incapable of sleep due to fear.";
            case 162: return "#162 Furret (Normal)\nFurret has a very slim build. When under attack, it can slickly squirm through narrow spaces and get away. In spite of its short limbs, this Pokémon is very nimble and fleet.";
            case 163: return "#163 Hoothoot (Normal/Flying)\nHoothoot has an internal organ that senses and tracks the earth's rotation. Using this special organ, this Pokémon begins hooting at precisely the same time every day.";
            case 164: return "#164 Noctowl (Normal/Flying)\nNoctowl never fails at catching prey in darkness. This Pokémon owes its success to its superior vision that allows it to see in minimal light, and to its soft, supple wings that make no sound in flight.";
            case 165: return "#165 Ledyba (Bug/Flying)\nLedyba secretes an aromatic fluid from where its legs join its body. This fluid is used for communicating with others. This Pokémon conveys its feelings to others by altering the fluid's scent.";
            case 166: return "#166 Ledian (Bug/Flying)\nIt is said that in lands with clean air, where the stars fill the sky, there live Ledian in countless numbers. There is a good reason for this—the Pokémon uses the light of the stars as its energy.";
            case 167: return "#167 Spinarak (Bug/Poison)\nThe web spun by Spinarak can be considered its second nervous system. It is said that this Pokémon can determine what kind of prey is touching its web just by the tiny vibrations it feels through the web's strands.";
            case 168: return "#168 Ariados (Bug/Poison)\nAriados's feet are tipped with tiny hooked claws that enable it to scuttle on ceilings and vertical walls. This Pokémon constricts the foe with thin but strong silk webbing.";
            case 169: return "#169 Crobat (Poison/Flying)\nIf this Pokémon is flying by fluttering only a pair of wings on either the forelegs or hind legs, it's proof that Crobat has been flying a long distance. It switches the wings it uses if it is tired.";
            case 170: return "#170 Chinchou (Water/Electric)\nChinchou lets loose positive and negative electrical charges from its two antennas to make its prey faint. This Pokémon flashes its electric lights to exchange signals with others.";
            case 171: return "#171 Lanturn (Water/Electric)\nLanturn is nicknamed 'the deep-sea star' for its illuminated antenna. This Pokémon produces light by causing a chemical reaction between bacteria and its bodily fluids inside the antenna.";
            case 172: return "#172 Pichu (Electric)\nPichu stores electricity in the pouches on its cheeks but discharges it inadvertently when agitated or excited because it is still unable to control its electricity fully.";
            case 173: return "#173 Cleffa (Fairy)\nOn nights with many shooting stars, Cleffa can be seen dancing in a ring. They dance through the night and stop only at the break of day, when these Pokémon quench their thirst with the morning dew.";
            case 174: return "#174 Igglybuff (Normal/Fairy)\nIgglybuff's vocal cords are not yet fully developed. It would hurt its throat if it were to sing too much. This Pokémon gargles with freshwater from a clean stream.";
            case 175: return "#175 Togepi (Fairy)\nAs its energy, Togepi uses the positive emotions of compassion and pleasure exuded by people and Pokémon. This Pokémon stores up feelings of happiness inside its shell, then shares them with others.";
            case 176: return "#176 Togetic (Fairy/Flying)\nTogetic is said to be a Pokémon that brings good fortune. When the Pokémon spots someone who is pure of heart, it is said to appear and share its happiness with that person.";
            case 177: return "#177 Natu (Psychic/Flying)\nNatu cannot fly because its wings are not yet fully grown. If your eyes meet with this Pokémon's eyes, it will stare back intently at you. But if you move even slightly, it will hop away to safety.";
            case 178: return "#178 Xatu (Psychic/Flying)\nXatu stands rooted and still in one spot all day long. People believe that this Pokémon does so out of fear of the terrible things it has foreseen in the future.";
            case 179: return "#179 Mareep (Electric)\nMareep's fluffy coat of wool rubs together and builds a static charge. The more static electricity is charged, the more brightly the lightbulb at the tip of its tail glows.";
            case 180: return "#180 Flaaffy (Electric)\nFlaaffy's wool quality changes so that it can generate a high amount of static electricity with a small amount of wool. The bare and slick parts of its hide are shielded against electricity.";
            case 181: return "#181 Ampharos (Electric)\nAmpharos gives off so much light that it can be seen even from space. People in the old days used the light of this Pokémon to send signals back and forth with others far away.";
            case 182: return "#182 Bellossom (Grass)\nWhen Bellossom gets exposed to plenty of sunlight, the leaves ringing its body begin to spin around. This Pokémon's dancing is renowned in the southern lands.";
            case 183: return "#183 Marill (Water/Fairy)\nMarill's oil-filled tail acts as a buoy, keeping the Pokémon from drowning even in a strong current. When fishing for food at the edge of a fast-running stream, Marill wraps its tail around a tree.";
            case 184: return "#184 Azumarill (Water/Fairy)\nAzumarill can make balloons out of air. It makes these air balloons if it spots a drowning Pokémon. The air balloons enable the Pokémon in trouble to breathe.";
            case 185: return "#185 Sudowoodo (Rock)\nSudowoodo camouflages itself as a tree to avoid being attacked by enemies. However, because its hands remain green throughout the year, the Pokémon is easily identified as a fake during the winter.";
            case 186: return "#186 Politoed (Water)\nThe curled hair on Politoed's head is proof of its status as a king. It is said that the longer and more curled the hair, the more respect this Pokémon earns from its peers.";
            case 187: return "#187 Hoppip (Grass/Flying)\nThis Pokémon drifts and floats with the wind. If it senses the approach of strong winds, Hoppip links its leaves with other Hoppip to prepare against being blown away.";
            case 188: return "#188 Skiploom (Grass/Flying)\nSkiploom's flower blossoms when the temperature rises above 64 degrees Fahrenheit. How much the flower opens depends on the temperature. For that reason, this Pokémon is sometimes used as a thermometer.";
            case 189: return "#189 Jumpluff (Grass/Flying)\nJumpluff rides warm southern winds to cross the sea and fly to foreign lands. The Pokémon descends to the ground when it encounters cold air while it is floating.";
            case 190: return "#190 Aipom (Normal)\nAipom's tail ends in a hand-like appendage that can be cleverly manipulated. However, because the Pokémon uses its tail so much, its real hands have become rather clumsy.";
            case 191: return "#191 Sunkern (Grass)\nSunkern tries to move as little as possible. It does so because it tries to conserve all the nutrients it has stored in its body for its evolution. It will not eat a thing, subsisting only on morning dew.";
            case 192: return "#192 Sunflora (Grass)\nSunflora converts solar energy into nutrition. It moves around actively in the daytime when it is warm. It stops moving as soon as the sun goes down for the night.";
            case 193: return "#193 Yanma (Bug/Flying)\nYanma is capable of seeing 360 degrees without having to move its eyes. It is a great flier that is adept at making sudden stops and turning midair. This Pokémon uses its flying ability to quickly chase down targeted prey.";
            case 194: return "#194 Wooper (Water/Ground)\nWooper usually lives in water. However, it occasionally comes out onto land in search of food. On land, it coats its body with a gooey, toxic film.";
            case 195: return "#195 Quagsire (Water/Ground)\nQuagsire hunts for food by leaving its mouth wide open in water and waiting for its prey to blunder in unaware. Because the Pokémon does not move, it does not get very hungry.";
            case 196: return "#196 Espeon (Psychic)\nEspeon is extremely loyal to any Trainer it considers to be worthy. It is said that this Pokémon developed its precognitive powers to protect its Trainer from harm.";
            case 197: return "#197 Umbreon (Dark)\nUmbreon evolved as a result of exposure to the moon's waves. It hides silently in darkness and waits for its foes to make a move. The rings on its body glow when it leaps to attack.";
            case 198: return "#198 Murkrow (Dark/Flying)\nMurkrow was feared and loathed as the alleged bearer of ill fortune. This Pokémon shows strong interest in anything that sparkles or glitters. It will even try to steal rings from women.";
            case 199: return "#199 Slowking (Water/Psychic)\nSlowking undertakes research every day in an effort to solve the mysteries of the world. However, this Pokémon apparently forgets everything it has learned if the Shellder on its head comes off.";
            case 200: return "#200 Misdreavus (Ghost)\nMisdreavus frightens people with a creepy, sobbing cry. The Pokémon apparently uses its red spheres to absorb the fearful feelings of foes and turn them into nutrition.";
            case 201: return "#201 Unown (Psychic)\nUnown has the power to perceive meanings in the messages in ancient writing. Unown uses its abilities to communicate with each other using telepathy even across great distances.";
            case 202: return "#202 Wobbuffet (Psychic)\nIf two or more Wobbuffet meet, they will turn competitive and try to outdo each other's endurance. However, they may try to see which one can endure the longest without food. Trainers need to beware of this habit.";
            case 203: return "#203 Girafarig (Normal/Psychic)\nGirafarig's rear head also has a brain, but it is small and simple. The rear head attacks in response to smells and sounds. Approaching this Pokémon from behind can cause the rear head to suddenly lash out.";
            case 204: return "#204 Pineco (Bug)\nPineco hangs from a tree branch and patiently waits for prey to come along. If the Pokémon is disturbed while eating by someone shaking its tree, it drops down to the ground and explodes with no warning.";
            case 205: return "#205 Forretress (Bug/Steel)\nForretress conceals itself inside its hardened steel shell. The shell is opened when the Pokémon is catching prey, but it is so quick that the shell's inside cannot be seen.";
            case 206: return "#206 Dunsparce (Normal)\nDunsparce has a drill for its tail. It uses this tail to burrow into the ground backward. This Pokémon is known to make its nest in complex shapes deep under the ground.";
            case 207: return "#207 Gligar (Ground/Flying)\nGligar glides through the air without a sound as if it were sliding. This Pokémon hangs on to the face of its foe using its clawed hind legs and the large pincers on its forelegs, then injects the prey with its poison barb.";
            case 208: return "#208 Steelix (Steel/Ground)\nSteelix lives even further underground than Onix. This Pokémon is known to dig toward the earth's core. There are records of this Pokémon reaching a depth of over six-tenths of a mile underground.";
            case 209: return "#209 Snubbull (Fairy)\nBy baring its fangs and making a scary face, Snubbull sends smaller Pokémon scurrying away in terror. However, this Pokémon seems to be unaware that its face looks frightening to other Pokémon.";
            case 210: return "#210 Granbull (Fairy)\nGranbull has a particularly well-developed lower jaw. The enormous fangs are heavy, causing the Pokémon to tip its head back for balance. Unless it is startled, it will not try to bite indiscriminately.";
            case 211: return "#211 Qwilfish (Water/Poison)\nQwilfish sucks in water, inflating itself. This Pokémon uses this method to increase its body size as much as possible. It puffs up to intimidate foes and indicates its mood with the intensity of its spines.";
            case 212: return "#212 Scizor (Bug/Steel)\nScizor has a body with the hardness of steel. It is not easily fazed by ordinary sorts of attacks. This Pokémon flaps its wings to regulate its body temperature.";
            case 213: return "#213 Shuckle (Bug/Rock)\nShuckle quietly hides itself under rocks, keeping its body concealed inside its hard shell while eating berries it has stored away. The berries mix with its body fluids to become a juice.";
            case 214: return "#214 Heracross (Bug/Fighting)\nHeracross charges in a straight line at its foe, slips beneath the foe's grasp, and then scoops up and hurls the opponent with its mighty horn. This Pokémon even has enough power to topple a massive tree.";
            case 215: return "#215 Sneasel (Dark/Ice)\nSneasel scales trees by punching its hooked claws into the bark. This Pokémon seeks out unguarded nests and steals eggs for food while the parents are away.";
            case 216: return "#216 Teddiursa (Normal)\nThis Pokémon likes to lick its palms that are sweetened by being soaked in honey. Teddiursa concocts its own honey by blending fruits and pollen collected by Beedrill.";
            case 217: return "#217 Ursaring (Normal)\nIn the forests inhabited by Ursaring, it is said that there are many streams and towering trees where they gather food. This Pokémon walks through its forest gathering food every day.";
            case 218: return "#218 Slugma (Fire)\nMolten magma courses throughout Slugma's circulatory system. If this Pokémon is chilled, the magma cools and hardens. Its body turns brittle and chunks fall off, reducing its size.";
            case 219: return "#219 Magcargo (Fire/Rock)\nMagcargo's shell is actually its skin that hardened as a result of cooling. Its shell is very brittle and fragile—just touching it causes it to crumble apart. This Pokémon returns to its original size by dipping itself in magma.";
            case 220: return "#220 Swinub (Ice/Ground)\nSwinub roots for food by rubbing its snout against the ground. Its favorite food is a mushroom that grows under the cover of dead grass. This Pokémon occasionally roots out hot springs.";
            case 221: return "#221 Piloswine (Ice/Ground)\nPiloswine is covered by a thick coat of long hair that enables it to endure the freezing cold. This Pokémon uses its tusks to dig up food that has been buried under ice.";
            case 222: return "#222 Corsola (Water/Rock)\nCorsola's branches glitter very beautifully in seven colors when they catch sunlight. If any branch breaks off, this Pokémon grows it back in just one night.";
            case 223: return "#223 Remoraid (Water)\nRemoraid sucks in water, then expels it at high velocity using its abdominal muscles to shoot down flying prey. When evolution draws near, this Pokémon travels downstream from rivers.";
            case 224: return "#224 Octillery (Water)\nOctillery grabs onto its foe using its tentacles. This Pokémon tries to immobilize it before delivering the finishing blow. If the foe turns out to be too strong, Octillery spews ink to escape.";
            case 225: return "#225 Delibird (Ice/Flying)\nDelibird carries its food bundled up in its tail. There once was a famous explorer who managed to reach the peak of the world's highest mountain thanks to one of these Pokémon sharing its food.";
            case 226: return "#226 Mantine (Water/Flying)\nOn sunny days, schools of Mantine can be seen elegantly leaping over the sea's waves. This Pokémon is not bothered by the Remoraid that hitches rides.";
            case 227: return "#227 Skarmory (Steel/Flying)\nSkarmory is entirely encased in hard, protective armor. This Pokémon flies at close to 190 mph. It slashes foes with its wings that possess swordlike cutting edges.";
            case 228: return "#228 Houndour (Dark/Fire)\nHoundour hunt as a coordinated pack. They communicate with each other using a variety of cries to corner their prey. This Pokémon's remarkable teamwork is unparalleled.";
            case 229: return "#229 Houndoom (Dark/Fire)\nIn a Houndoom pack, the one with its horns raked sharply toward the back serves a leadership role. These Pokémon choose their leader by fighting among themselves.";
            case 230: return "#230 Kingdra (Water/Dragon)\nKingdra lives at extreme ocean depths that are otherwise uninhabited. It has long been believed that the yawning of this Pokémon creates spiraling ocean currents.";
            case 231: return "#231 Phanpy (Ground)\nFor its nest, Phanpy digs a vertical pit in the ground at the edge of a river. It marks the area around its nest with its trunk to let the others know that the area has been claimed.";
            case 232: return "#232 Donphan (Ground)\nDonphan's favorite attack is curling its body into a ball, then charging at its foe while rolling at high speed. Once it starts rolling, this Pokémon can't stop very easily.";
            case 233: return "#233 Porygon2 (Normal)\nPorygon2 was created by humans using the power of science. The man-made Pokémon has been endowed with artificial intelligence that enables it to learn new gestures and emotions on its own.";
            case 234: return "#234 Stantler (Normal)\nStantler's magnificent antlers were traded at high prices as works of art. As a result, this Pokémon was hunted close to extinction by those who sought the priceless antlers.";
            case 235: return "#235 Smeargle (Normal)\nSmeargle marks the boundaries of its territory using a body fluid that leaks out from the tip of its tail. Over 5,000 different marks left by this Pokémon have been found.";
            case 236: return "#236 Tyrogue (Fighting)\nTyrogue becomes stressed out if it does not get to train every day. When raising this Pokémon, the Trainer must establish and uphold various training methods.";
            case 237: return "#237 Hitmontop (Fighting)\nHitmontop spins on its head at high speed, all the while delivering kicks. This technique is a remarkable mix of both offense and defense at the same time. The Pokémon traveled over the seas to learn this technique.";
            case 238: return "#238 Smoochum (Ice/Psychic)\nSmoochum actively runs about, but also falls quite often. Whenever the chance arrives, it will look for its reflection to make sure its face hasn't become dirty.";
            case 239: return "#239 Elekid (Electric)\nElekid stores electricity in its body. If it touches metal and accidentally discharges all its built-up electricity, this Pokémon begins swinging its arms in circles to recharge itself.";
            case 240: return "#240 Magby (Fire)\nMagby's state of health is determined by observing the flame on its tail. If the Pokémon is spouting yellow flames from its tail, it is in good health. When it is fatigued, black smoke will be mixed in with the flames.";
            case 241: return "#241 Miltank (Normal)\nMiltank gives over five gallons of milk on a daily basis. Its sweet milk is enjoyed by children and grown-ups alike. People who can't drink milk turn it into yogurt and eat it instead.";
            case 242: return "#242 Blissey (Normal)\nBlissey senses sadness with its fluffy coat of fur. If it does so, this Pokémon will rush over to a sad person, no matter how far away, to share a Lucky Egg that brings a smile to any face.";
            case 243: return "#243 Raikou (Electric)\nRaikou embodies the speed of lightning. The roars of this Pokémon send shock waves shuddering through the air and shake the ground as if lightning bolts had come crashing down.";
            case 244: return "#244 Entei (Fire)\nEntei embodies the passion of magma. This Pokémon is thought to have been born in the eruption of a volcano. It sends up massive bursts of fire that utterly consume all that they touch.";
            case 245: return "#245 Suicune (Water)\nSuicune embodies the compassion of a pure spring of water. It runs across the land with gracefulness. This Pokémon has the power to purify dirty water.";
            case 246: return "#246 Larvitar (Rock/Ground)\nLarvitar is born deep under the ground. To come up to the surface, this Pokémon must eat its way through the soil above. Until it does so, Larvitar cannot see its parents.";
            case 247: return "#247 Pupitar (Rock/Ground)\nPupitar creates a gas inside its body that it compresses and forcefully ejects to propel itself like a jet. The body is very durable—it avoids damage even if it hits solid steel.";
            case 248: return "#248 Tyranitar (Rock/Dark)\nTyranitar is so overwhelmingly powerful, it can bring down a whole mountain to make its nest. This Pokémon wanders about in mountains seeking new opponents to fight.";
            case 249: return "#249 Lugia (Psychic/Flying)\nLugia's wings pack devastating power—a light fluttering of its wings can blow apart regular houses. As a result, this Pokémon chooses to live out of sight deep under the sea.";
            case 250: return "#250 Ho-Oh (Fire/Flying)\nHo-Oh's feathers glow in seven colors depending on the angle at which they are struck by light. These feathers are said to bring happiness to the bearers. This Pokémon is said to live at the foot of a rainbow.";
            case 251: return "#251 Celebi (Psychic/Grass)\nThis Pokémon came from the future by crossing over time. It is thought that so long as Celebi appears, a bright and shining future awaits us.";
            default:
                if (number < 152 || number > 251) {
                    return "Invalid number. Johto Pokémon are #152-#251.";
                }
                return "Unknown Pokémon";
        }
    }
}
