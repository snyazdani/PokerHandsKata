package PokerHands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Nick Yazdani
 */
public class Dealer {
    int deckSize;
    ArrayList<String> newDeck;
    Random rand;
    Dealer() {
        deckSize = 52;
        newDeck = new Cards().getDeck();
        Collections.shuffle(newDeck);
        rand = new Random(42);
    }

    ArrayList dealHand() {
        ArrayList<String> myHand = new ArrayList<>();
        int cardIndex;
        for(int i = 0; i < 5; i++, deckSize--) {
            cardIndex = rand.nextInt(deckSize);
            myHand.add(newDeck.get(cardIndex));
            newDeck.remove(cardIndex);// remove the card picked from the deck
        }
        return myHand;
    }
}
