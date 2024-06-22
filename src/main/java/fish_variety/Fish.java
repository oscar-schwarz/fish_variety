/**
* The Fish class represents a type of fish with a name and price.
*/
package fish_variety;

public class Fish {
    private String name;

    private int price;

    /**
    * Constructs a new Fish object with the given name and price.
    * @param name the name of the fish
    * @param price the price of the fish
    */
    public Fish(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
    * Returns the name of the fish.
    * @return the name of the fish
    */
    public String getName() {
        return name;
    }

    /**
    * Returns the price of the fish.
    * @return the price of the fish
    */
    public int getPrice() {
        return price;
    }
}