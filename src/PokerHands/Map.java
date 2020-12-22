package PokerHands;

/**
 * @author Nick Yazdani
 */

// return high card value
public class Map {
    int value;
    String name;
    Map(int value, String name) {
        this.name = name;
        this.value = value;
    }
    int getValue() { return value; }
    void setValue(int newValue) { value = newValue; }
    String getName() { return name; }
    void setName(String newName) { name = newName; }
}