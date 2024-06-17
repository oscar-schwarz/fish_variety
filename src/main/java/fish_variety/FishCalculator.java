package fish_variety;

import java.util.ArrayList;

public class FishCalculator {

    public static FishCollection mostCompatibleFishTypesOfCollection(int price, FishCollection initialCollection) {
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

        // Get largets collection in variants
        FishCollection largestCollectionVariant = variants.get(0);

        for (FishCollection fishCollection : variants) {
            if (fishCollection.getFishes().size() > largestCollectionVariant.getFishes().size()) {
                largestCollectionVariant = fishCollection;
            }
        }

        return largestCollectionVariant;
    }
}
