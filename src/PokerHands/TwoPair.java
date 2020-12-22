package PokerHands;

import java.util.ArrayList;
import java.util.Collections;
import static PokerHands.Hands.intToName;

/**
 *
 * @author Nick Yazdani
 */
public class TwoPair {
    ArrayList<Integer> isTwoPair(ArrayList<Integer> values) {
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
            if(freq1 == 2) {
                returnList.add(value1);
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
                vals.remove(i);
                vals.remove(i);
                break;
            }
        }
        if(freq1 != 2 || freq2 != 2) { // return array if not full house
            returnList.clear();
            return returnList;
        }
        Collections.sort(returnList);
        Collections.reverse(returnList);
        returnList.add(vals.get(0));
        return returnList;
    }

    boolean twoPairWinner(ArrayList<Integer> h1TwoPair, ArrayList<Integer> h2TwoPair) {
        boolean isTwoPair = true;
        if(h1TwoPair.isEmpty() && h2TwoPair.isEmpty()) return isTwoPair = false;

        // Decide the winner
        if(!h1TwoPair.isEmpty() && h2TwoPair.isEmpty()) {
            System.out.println("Black wins. - with two pair: " + intToName(h1TwoPair.get(0)) + "s over "
                    + intToName(h1TwoPair.get(1)) + "s.");
        }
        else if(h1TwoPair.isEmpty() && !h2TwoPair.isEmpty()) {
            System.out.println("White wins. - with two pair: " + intToName(h2TwoPair.get(0)) + "s over "
                    + intToName(h2TwoPair.get(1)) + "s.");
        }
        else {
            if(h1TwoPair.get(0) > h2TwoPair.get(0)) {
                System.out.println("Black wins. - with two pair: " + intToName(h1TwoPair.get(0)) + "s over "
                        + intToName(h1TwoPair.get(1)) + "s.");
            }
            else if(h1TwoPair.get(0) < h2TwoPair.get(0)) {
                System.out.println("White wins. - with two pair: " + intToName(h2TwoPair.get(0)) + "s over "
                        + intToName(h2TwoPair.get(1)) + "s.");
            }
            else {
                if(h1TwoPair.get(1) > h2TwoPair.get(1)) {
                    System.out.println("Black wins. - with two pair: " + intToName(h1TwoPair.get(0)) + "s over "
                            + intToName(h1TwoPair.get(1)) + "s.");
                }
                else if(h1TwoPair.get(1) < h2TwoPair.get(1)) {
                    System.out.println("White wins. - with two pair: " + intToName(h2TwoPair.get(0)) + "s over "
                            + intToName(h2TwoPair.get(1)) + "s.");
                }
                else {
                    if(h1TwoPair.get(2) > h2TwoPair.get(2)) {
                        System.out.println("Black wins. - with two pair: " + intToName(h1TwoPair.get(0)) + "s over "
                                + intToName(h1TwoPair.get(1)) + "s, " + intToName(h1TwoPair.get(2)) + " high.");
                    }
                    else if(h1TwoPair.get(2) < h2TwoPair.get(2)) {
                        System.out.println("White wins. - with two pair: " + intToName(h2TwoPair.get(0)) + "s over "
                                + intToName(h2TwoPair.get(1)) + "s, " + intToName(h2TwoPair.get(2)) + " high.");
                    }
                    else {
                        System.out.println("Players tie with two pair: " + intToName(h2TwoPair.get(0)) + "s over "
                                + intToName(h2TwoPair.get(1)) + "s, " + intToName(h2TwoPair.get(2)) + " high.");
                    }
                }
            }
        }
        return isTwoPair;
    }
}