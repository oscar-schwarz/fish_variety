package fish_variety;

import java.util.ArrayList;
import java.util.Arrays;

/**
* The FishConstraints class represents constraints between different types of fish.
*/
public class FishConstraints {
    private ArrayList<FishPair> constraints = new ArrayList<FishPair>();
    private ArrayList<Fish> fishes;

    /**
    * Constructor for FishConstraints class.
    * @param fishes The list of fishes to be constrained.
    */
    public FishConstraints(Fish... fishes) {
        this.fishes = new ArrayList<Fish>(Arrays.asList(fishes));
    }

    /**
    * Get all the fishes in the constraints.
    * @return ArrayList of all fishes.
    */
    public ArrayList<Fish> getAllFish() {
        return this.fishes;
    }

    /**
    * Add a constraint between two fishes.
    * @param one The first fish.
    * @param two The second fish.
    */
    public void addConstraint(Fish one, Fish two) {
        this.constraints.add(new FishPair(two, one));
    }

    /**
    * Add multiple constraints for a fish.
    * @param fish The fish to add constraints for.
    * @param newIncompatibles Array of new incompatible fishes.
    */
    public void addConstraints(Fish fish, Fish[] newIncompatibles) {
        ArrayList<Fish> alreadyIncompatibles = this.getIncompatibleWithFor(fish);

        for (Fish newFish : newIncompatibles) {
            if (alreadyIncompatibles.contains(newFish)) continue;
            if (this.fishes.contains(newFish)) {
                this.fishes.add(newFish);
            }
            this.addConstraint(fish, newFish);
        }
    }

    /**
    * Get all fishes that are incompatible with a given fish.
    * @param fish The fish to check incompatibilities for.
    * @return ArrayList of incompatible fishes.
    */
    public ArrayList<Fish> getIncompatibleWithFor(Fish fish) {
        ArrayList<Fish> incompatibles = new ArrayList<Fish>();

        for (FishPair pair : this.constraints) {
            Fish other = pair.getOtherThan(fish);

            if (other == null) continue;
            else incompatibles.add(other);
        }

        return incompatibles;
    }

    /**
    * Check if two fishes are compatible with each other.
    * @param one The first fish.
    * @param two The second fish.
    * @return True if compatible, false otherwise.
    */
    public boolean areCompatible(Fish one, Fish two) {
        ArrayList<Fish> incompatibles = this.getIncompatibleWithFor(one);

        return !incompatibles.contains(two);
    }
}