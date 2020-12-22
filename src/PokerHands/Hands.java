package PokerHands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.util.Objects;

/**
 *
 * @author Nick Yazdani
 */
public class Hands {
    List hand1, hand2;


    Hands(ArrayList<String> hand1, ArrayList<String> hand2) {
        this.hand1 = hand1;
        this.hand2 = hand2;
    }


    public static String intToName(int value) {
        String name;

        switch (value) {
            case 11:
                name = "Jack";
                break;
            case 12:
                name = "Queen";
                break;
            case 13:
                name = "King";
                break;
            case 14:
                name = "Ace";
                break;
            default:
                name = Integer.toString(value);
                break;
        }
        return name;
    }

    Map highCard(ArrayList<Integer> cards) {

        int highCard = Collections.max(cards);
        String highCardName;

        switch (highCard) {
            case 11:
                highCardName = "Jack";
                break;
            case 12:
                highCardName = "Queen";
                break;
            case 13:
                highCardName = "King";
                break;
            case 14:
                highCardName = "Ace";
                break;
            default:
                highCardName = Integer.toString(highCard);
                break;
        }
        Map cMap = new Map(highCard, highCardName);
        return cMap;
    }

    void compareHands(ArrayList<String> hand1, ArrayList<String> hand2) {

        Splitter h1Split = new Splitter(hand1);
        Splitter h2Split = new Splitter(hand2);

        Map h1HighCard = highCard(h1Split.getValues());
        Map h2HighCard = highCard(h2Split.getValues());

        // determine if flush
        Flush flush = new Flush();
        boolean h1Flush = flush.isFlush(h1Split.getSuits());
        boolean h2Flush = flush.isFlush(h2Split.getSuits());

        // determine if straight
        Straight straight = new Straight();
        boolean h1Straight = straight.isStraight(h1Split.getValues());
        boolean h2Straight = straight.isStraight(h2Split.getValues());

        // determine if straight flush
        StraightFlush straightFlush = new StraightFlush();
        boolean h1StraightFlush = straightFlush.isStraightFlush(h1Flush, h1Straight);
        boolean h2StraightFlush = straightFlush.isStraightFlush(h2Flush, h2Straight);

        // straight flush winner
        if(straightFlush.straightFlushWinner(h1StraightFlush, h2StraightFlush, h1Split, h2Split, h1HighCard, h2HighCard)) return;

        // determine if four of a kind
        FourOfAKind fourOfAKind = new FourOfAKind();
        int h1FourOfAKind = fourOfAKind.isFourOfAKind(h1Split.getValues());
        String h1MatchFourName = intToName(h1FourOfAKind);
        int h2FourOfAKind = fourOfAKind.isFourOfAKind(h2Split.getValues());
        String h2MatchFourName = intToName(h2FourOfAKind);

        // four of a kind winner
        if(fourOfAKind.fourOfAKindWinner(h1FourOfAKind, h2FourOfAKind, h1MatchFourName, h2MatchFourName)) return;

        // determine if full house
        FullHouse fullHouse = new FullHouse();
        ArrayList<Integer> h1FullHouse = fullHouse.isFullHouse(h1Split.getValues());
        ArrayList<Integer> h2FullHouse = fullHouse.isFullHouse(h2Split.getValues());

        // full house winner
        if(fullHouse.fullHouseWinner(h1FullHouse, h2FullHouse)) return;

        // flush winner
        if(flush.flushWinner(h1Flush, h2Flush, h1HighCard, h2HighCard)) return;

        // straight winner
        if(straight.straightWinner(h1Straight, h2Straight, h1Split, h2Split, h1HighCard, h2HighCard)) return;

        // determine if three of a kind
        ThreeOfAKind threeOfAKind = new ThreeOfAKind();
        int h1ThreeOfAKind = threeOfAKind.isThreeOfAKind(h1Split.getValues());
        String h1MatchThreeName = intToName(h1ThreeOfAKind);
        int h2ThreeOfAKind = threeOfAKind.isThreeOfAKind(h2Split.getValues());
        String h2MatchThreeName = intToName(h2ThreeOfAKind);

        // three of a kind winner
        if(threeOfAKind.threeOfAKindWinner(h1ThreeOfAKind, h2ThreeOfAKind, h1MatchThreeName, h2MatchThreeName)) return;

        // determine if two pair
        TwoPair twoPair = new TwoPair();
        ArrayList<Integer> h1TwoPair = twoPair.isTwoPair(h1Split.getValues());
        ArrayList<Integer> h2TwoPair = twoPair.isTwoPair(h2Split.getValues());

        // two pair if winner
        if(twoPair.twoPairWinner(h1TwoPair, h2TwoPair)) return;

        // determine if pair
        Pair pair = new Pair();
        ArrayList<Integer> h1Pair = pair.isPair(h1Split.getValues());
        ArrayList<Integer> h2Pair = pair.isPair(h2Split.getValues());

        // pair winner
        if(pair.pairWinner(h1Pair, h2Pair)) return;

        // high card
        HighCard highCard = new HighCard();
        ArrayList<Integer> h1High = highCard.isHighCard(h1Split.getValues());
        ArrayList<Integer> h2High = highCard.isHighCard(h2Split.getValues());

        // high card winner
        if(highCard.highCardWinner(h1High, h2High));
    }
}