/**
* Represents a pair of fish.
*/
package fish_variety;

public class FishPair {
    private Fish first;
    private Fish second;

    /**
    * Constructs a FishPair object with two Fish objects.
    * @param first the first Fish object
    * @param second the second Fish object
    */
    public FishPair(Fish first, Fish second) {
        this.first = first;
        this.second = second;
    }

    /**
    * Gets the first Fish object in the pair.
    * @return the first Fish object
    */
    public Fish getFirst() {
        return first;
    }

    /**
    * Gets the second Fish object in the pair.
    * @return the second Fish object
    */
    public Fish getSecond() {
        return second;
    }

    /**
    * Gets the Fish object that is not equal to the provided Fish object.
    * @param fish the Fish object to compare
    * @return the other Fish object in the pair
    */
    public Fish getOtherThan(Fish fish) {
        if (fish == this.first) return this.second;
        if (fish == this.second) return this.first;

        return null;
    }
}