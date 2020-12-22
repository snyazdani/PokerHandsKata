package PokerHands;

import java.util.ArrayList;

/**
 *
 * @author Nick Yazdani
 */
public class Flush {
    boolean isFlush(ArrayList<String> hand) {
        int suitMatch = 1;
        boolean isFlush = false;
        for(int i = 0; i < hand.size(); i++){
            if(i+1 >= hand.size()) break;
            if(hand.get(i).equals(hand.get(i+1))){
                suitMatch++;
            }
            if(suitMatch == 5) isFlush = true;
        }
        return isFlush;
    }

    boolean flushWinner(boolean h1Flush, boolean h2Flush, Map h1HighCard, Map h2HighCard) {
        boolean isFlush = true;
        if(!h1Flush && !h2Flush) return isFlush = false;
        // declare flush winner
        if(h1Flush && !h2Flush) {
            System.out.println("Black wins. - with a flush.");
        }
        else if(!h1Flush && h2Flush) {
            System.out.println("White wins. - with a flush.");
        }
        else {
            if(h1HighCard.getValue() > h2HighCard.getValue()) {
                System.out.println("Black wins. - with a flush: " + h1HighCard.getName() + " high.");
            }
            else if(h1HighCard.getValue() < h2HighCard.getValue()) {
                System.out.println("White wins. - with a flush: " + h2HighCard.getName() + " high.");
            }
            else {
                System.out.println("Players Black and White Tie.");
            }
        }
        return isFlush;
    }
}