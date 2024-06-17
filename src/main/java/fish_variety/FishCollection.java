package fish_variety;

import java.util.ArrayList;

public class FishCollection {
    private ArrayList<Fish> fishes = new ArrayList<Fish>();
    private FishConstraints constraints;

    private Fish latest;

    public FishCollection(FishConstraints constraints, ArrayList<Fish> fishes) {
        this.constraints = constraints;
        for (Fish fish : fishes) {
            this.add(fish);
        }
    }

    public FishCollection(FishConstraints constraints) {
        this.constraints = constraints;
    }
    
    public ArrayList<Fish> getFishes() {
        return this.fishes;
    }

    public ArrayList<Fish> getUnaddedFishes() {
        ArrayList<Fish> unadded = new ArrayList<Fish>(this.constraints.getAllFish());

        unadded.removeAll(this.fishes);

        // Sorts the fishes
        return new FishCollection(this.constraints, unadded).getFishes();
    }

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

    public Fish getLatestFish() {
        return this.latest;
    }

    public void add(Fish newFish) {
        this.latest = newFish;

        if (this.fishes.contains(newFish)) return;

        boolean wasAdded = false;
        for (int i=0;i<this.fishes.size();i++) {
            if (this.fishes.get(i).getPrice() > newFish.getPrice()) {
                this.fishes.add(i, newFish);
                wasAdded = true;
                break;
            }
        }

        if (!wasAdded) {
            this.fishes.add(newFish);
        }
    }

    public void remove(Fish fish) {
        this.fishes.remove(fish);
    }

    public int getPrice() {
        int price = 0;
        for (Fish fish: fishes) {
            price += fish.getPrice();
        }

        return price;
    }
}