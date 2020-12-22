package PokerHands;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Nick Yazdani
 */
public class Cards {
    private final ArrayList<String> deck;

    Cards() {
        deck = new ArrayList<>();
        for(int i = 2; i < 10; i++){
            deck.add(i + "H");
            deck.add(i + "D");
            deck.add(i + "S");
            deck.add(i + "C");
        }
        deck.addAll(Arrays.asList("TH TD TS TC JH JD JS JC QH QD QS QC KH KD KS KC AH AD AS AC".split(" ")));
    }
    ArrayList<String> getDeck(){
        return deck;
    }
}
