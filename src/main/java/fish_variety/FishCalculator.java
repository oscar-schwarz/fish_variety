/**
* The FishCalculator class calculates the most compatible fish types that can be bought within a given price range.
*/
package fish_variety;

import java.util.ArrayList;

public class FishCalculator {

    /**
    * Finds the most compatible fish types of a collection within a given price range.
    *
    * @param price The maximum price to consider.
    * @param initialCollection The initial FishCollection to start with.
    * @return The FishCollection with the most compatible fish types.
    */
    private static FishCollection mostCompatibleFishTypesOfCollection(int price, FishCollection initialCollection) {
        FishConstraints constraints = initialCollection.getConstraints();

        ArrayList<FishCollection> variants = new ArrayList<>();

        for (Fish fish : initialCollection.getUnaddedFishes()) {
            FishCollection collectionVariant = new FishCollection(constraints, initialCollection.getFishes());

            collectionVariant.add(fish);

            if (collectionVariant.isValid() && collectionVariant.getPrice() <= price) {
                variants.add(FishCalculator.mostCompatibleFishTypesOfCollection(price, collectionVariant));
            }
        }

        if (variants.isEmpty()) {
            return initialCollection;
        }

        // Get largest collection in variants
        FishCollection largestCollectionVariant = variants.get(0);

        for (FishCollection fishCollection : variants) {
            if (fishCollection.getFishes().size() > largestCollectionVariant.getFishes().size()) {
                largestCollectionVariant = fishCollection;
            }
        }

        return largestCollectionVariant;
    }

    private FishConstraints constraints;

    /**
    * Constructs a FishCalculator with the given constraints.
    *
    * @param constraints The FishConstraints to apply.
    */
    public FishCalculator(FishConstraints constraints) {
        this.constraints = constraints;
    }

    /**
    * Calculates the variety of fish that can be bought within a given price range and prints the result.
    *
    * @param price The maximum price to consider.
    */
    public void calculateVarietyForPrice(int price) {
        FishCollection bestVariant = FishCalculator.mostCompatibleFishTypesOfCollection(price, new FishCollection(this.constraints));

        System.out.println("Es koennen maximal " + bestVariant.getFishes().size() + " Fische zusammen gekauft werden, zum Beispiel: " + bestVariant.toString());
    }
}