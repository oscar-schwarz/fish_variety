package fish_variety;

import java.util.ArrayList;
import java.util.Arrays;

public class FishConstraints {
    private ArrayList<FishPair> constraints = new ArrayList<FishPair>();
    private ArrayList<Fish> fishes;

    public FishConstraints(Fish... fishes) {
        this.fishes = new ArrayList<Fish>(Arrays.asList(fishes));
    }

    public ArrayList<Fish> getAllFish() {
        return this.fishes;
    }

    public void addConstraint(Fish one, Fish two) {
        this.constraints.add(new FishPair(two, one));
    }

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

    public ArrayList<Fish> getIncompatibleWithFor(Fish fish) {
        ArrayList<Fish> incompatibles = new ArrayList<Fish>();

        for (FishPair pair : this.constraints) {
            Fish other = pair.getOtherThan(fish);

            if (other == null) continue;
            else incompatibles.add(other);
        }

        return incompatibles;
    }

    public boolean areCompatible(Fish one, Fish two) {
        ArrayList<Fish> incompatibles = this.getIncompatibleWithFor(one);

        return !incompatibles.contains(two);
    }
}
