package PokerHands;
import java.util.*;

/**
 *
 * @author Nick Yazdani
 */

public class PokerHands {

    /**
     * @param args the command line argument
     */
    public static void main(String[] args) {

        Dealer dealer = new Dealer();

        ArrayList<String> handOne = dealer.dealHand();
        ArrayList<String> handTwo = dealer.dealHand();

        System.out.println("Black: " + handOne);
        System.out.println("White: " + handTwo);
        System.out.println();

        Hands hands = new Hands(handOne, handTwo);
        hands.compareHands(handOne, handTwo);
    }
}