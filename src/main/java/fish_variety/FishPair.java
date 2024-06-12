package fish_variety;

public class FishPair {
    private Fish first;
    private Fish second;

    public FishPair(Fish first, Fish second) {
        this.first = first;
        this.second = second;
    }

    public Fish getFirst() {
        return first;
    }

    public Fish getSecond() {
        return second;
    }

    public Fish getOtherThan(Fish fish) {
        if (fish == this.first) return this.second;
        if (fish == this.second) return this.first;

        // Fallback if given fish is not in pair
        return null;
    }

    
}
