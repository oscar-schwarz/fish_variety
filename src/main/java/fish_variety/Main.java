package fish_variety;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        // Make fish
        Fish grueneMigraene = new Fish("Gruene Migraene", 70);
        Fish korallenqualle = new Fish("Korallenqualle", 50);
        Fish schuppenschatulle = new Fish("Schuppenschatulle", 30);
        Fish breitmaulmolch = new Fish("Breitmaulmolch", 40);
        Fish prachtpiranha = new Fish("Prachtpiranha", 40);
        Fish zitterling = new Fish("Zitterling", 30);
        Fish grottensprotte = new Fish("Grottensprotte", 20);

        // Set relations
        FishConstraints constraints = new FishConstraints(
            grueneMigraene,
            korallenqualle,
            schuppenschatulle,
            breitmaulmolch,
            prachtpiranha,
            zitterling,
            grottensprotte
        );

        constraints.addConstraints(grueneMigraene, new Fish[] {
            breitmaulmolch, grottensprotte
        });

        constraints.addConstraints(schuppenschatulle, new Fish[] {
            breitmaulmolch, prachtpiranha
        });

        // Redundant, but is handled in method and better readability
        constraints.addConstraints(breitmaulmolch, new Fish[] {
            grueneMigraene, schuppenschatulle
        });

        constraints.addConstraints(prachtpiranha, new Fish[] {
            schuppenschatulle, grottensprotte
        });

        constraints.addConstraints(zitterling, new Fish[] {
            zitterling
        });

        constraints.addConstraints(grottensprotte, new Fish[] {
            grueneMigraene, prachtpiranha, zitterling
        });

        FishCollection collection = new FishCollection(constraints);
        
        collection.addFishesUntilMaxPrice(1000);

        System.out.println(collection.getFishes().size());

        for (Fish fish : collection.getFishes()) {
            System.out.println(fish.getName());
        }
    }
}
