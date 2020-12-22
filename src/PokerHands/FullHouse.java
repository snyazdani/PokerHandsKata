package PokerHands;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Nick Yazdani
 */
public class FullHouse {
    ArrayList<Integer> isFullHouse(ArrayList<Integer> values) {
        ArrayList<Integer> vals = new ArrayList<>();
        vals.addAll(values);
        ArrayList<Integer> returnList = new ArrayList<>();
        int freq1 = 0, freq2 = 0, value1 = 0, value2 = 0 , temp;

        for(Integer i : vals){
            temp = Collections.frequency(vals, i);
            if (temp > freq1) {
                freq1 = temp;
                value1 = i;
            }
            if(freq1 == 3) {
                returnList.add(value1);
                vals.remove(i);
                vals.remove(i);
                vals.remove(i);
                break;
            }
        }
        for(Integer i : vals) {
            temp = Collections.frequency(vals, i);
            if (temp > freq2) {
                freq2 = temp;
                value2 = i;
            }
            if(freq2 == 2) {
                returnList.add(value2);
                break;
            }
        }
        if(freq1 != 3 || freq2 !=2) { // return array if not full house
            returnList.clear();
        }
        return returnList;
    }

    boolean fullHouseWinner(ArrayList<Integer> h1FullHouse, ArrayList<Integer> h2FullHouse) {
        boolean isFullHouse = true;
        if(h1FullHouse.isEmpty() && h2FullHouse.isEmpty()) return isFullHouse = false;

        // declare full house winner
        if(!h1FullHouse.isEmpty() && h2FullHouse.isEmpty()) {
            System.out.println("Black wins. - with full house: " + Hands.intToName(h1FullHouse.get(0))
                    + "'s over " + Hands.intToName(h1FullHouse.get(1)) + "s.");
        }
        else if(h1FullHouse.isEmpty() && !h2FullHouse.isEmpty()) {
            System.out.println("White wins. - with full house: " + Hands.intToName(h2FullHouse.get(0))
                    + "'s over " + Hands.intToName(h2FullHouse.get(1)) + "s.");
        }
        else {
            if(h1FullHouse.get(0) > h2FullHouse.get(0)) {
                System.out.println("Black wins. - with full house: " + Hands.intToName(h1FullHouse.get(0))
                        + "'s over " + Hands.intToName(h1FullHouse.get(1)) + "s.");
            }
            else
                System.out.println("White wins. - with full house: " + Hands.intToName(h2FullHouse.get(0))
                        + "'s over " + Hands.intToName(h2FullHouse.get(1)) + "s.");
        }
        return isFullHouse;
    }
}