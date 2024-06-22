package fish_variety;

import java.util.ArrayList;

/**
* Represents a collection of fishes with constraints.
*/
public class FishCollection {
    private ArrayList<Fish> fishes = new ArrayList<Fish>();
    private FishConstraints constraints;

    /**
    * Constructs a FishCollection with constraints and a list of fishes.
    * @param constraints the constraints for the fish collection
    * @param fishes the list of fishes to add to the collection
    */
    public FishCollection(FishConstraints constraints, ArrayList<Fish> fishes) {
        this.constraints = constraints;
        for (Fish fish : fishes) {
            this.add(fish);
        }
    }

    /**
    * Constructs a FishCollection with constraints.
    * @param constraints the constraints for the fish collection
    */
    public FishCollection(FishConstraints constraints) {
        this.constraints = constraints;
    }

    /**
    * Gets the constraints of the fish collection.
    * @return the constraints of the fish collection
    */
    public FishConstraints getConstraints() {
        return constraints;
    }
    
    /**
    * Gets the list of fishes in the collection.
    * @return the list of fishes in the collection
    */
    public ArrayList<Fish> getFishes() {
        return this.fishes;
    }

    /**
    * Gets the list of fishes that have not been added to the collection.
    * @return the list of unadded fishes
    */
    public ArrayList<Fish> getUnaddedFishes() {
        ArrayList<Fish> unadded = new ArrayList<Fish>(this.constraints.getAllFish());

        unadded.removeAll(this.fishes);

        // Sorts the fishes
        return new FishCollection(this.constraints, unadded).getFishes();
    }

    /**
    * Checks if the fish collection is valid based on constraints.
    * @return true if the collection is valid, false otherwise
    */
    public boolean isValid() {
        ArrayList<Fish> allIncompatibles = new ArrayList<Fish>();

        for (Fish fish : this.fishes) {
            allIncompatibles.addAll(this.constraints.getIncompatibleWithFor(fish));
        } 

        for (Fish fish : this.fishes) {
            if (allIncompatibles.contains(fish)) {
                return false;
            }
        }

        return true;
    }

    /**
    * Adds a new fish to the collection if it does not already exist.
    * @param newFish the fish to add to the collection
    */
    public void add(Fish newFish) {
        if (!this.fishes.contains(newFish)) {
            this.fishes.add(newFish);
        }
    }

    /**
    * Removes a fish from the collection.
    * @param fish the fish to remove from the collection
    */
    public void remove(Fish fish) {
        this.fishes.remove(fish);
    }

    /**
    * Calculates the total price of all fishes in the collection.
    * @return the total price of all fishes in the collection
    */
    public int getPrice() {
        int price = 0;
        for (Fish fish: fishes) {
            price += fish.getPrice();
        }

        return price;
    }

    @Override
    public String toString() {
        ArrayList<String> names = new ArrayList<>();
        for (Fish fish : this.fishes) {
            names.add(fish.getName());
        }

        return String.join(", ", names);
    }
}