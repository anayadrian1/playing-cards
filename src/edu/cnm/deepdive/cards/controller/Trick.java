package edu.cnm.deepdive.cards.controller;

import edu.cnm.deepdive.cards.model.Card;
import edu.cnm.deepdive.cards.model.Deck;
import edu.cnm.deepdive.cards.model.Pile;
import edu.cnm.deepdive.cards.model.Suit.Color;
import java.security.SecureRandom;
import java.util.Random;

public class Trick {

  private static final String SUMMARY_FORMAT = "%1$s-influenced pile: %2$s%n\t%1$s count = %3$d%n";

  private final Deck deck;
  private final Pile redInfluenced;
  private final Pile blackInfluenced;
  private final Random rng;

  public Trick() {
    rng = new SecureRandom();
    deck = new Deck();
    redInfluenced = new Pile();
    blackInfluenced = new Pile();

  }

  public void split() {
    while (!deck.isEmpty()) {
      Card selector = deck.draw();
      Card card = deck.draw();
      ((selector.getSuit().getColor() == Color.RED) ? redInfluenced : blackInfluenced).add(card);
    }
  }

  public void swap() {
    int upperLimit = Math.min(redInfluenced.size(), blackInfluenced.size()) + 1; // (3, 5) is 4.
    int swapSize = rng.nextInt(upperLimit); // doesn't include 4
    for (int i = 0;i < swapSize; i++) {
      blackInfluenced.add(redInfluenced.draw());
      redInfluenced.add(blackInfluenced.draw());
    }
  }

  public void summarize() {
    int redCount = 0;
    for (Card card : redInfluenced) {
      if (card.getSuit().getColor() == Color.RED) {
        redCount++;
      }
    }
    int blackCount = 0;
    for (Card card : blackInfluenced) {
      if (card.getSuit().getColor() == Color.BLACK) {
        blackCount++;
      }
    }
    redInfluenced.sort();
    blackInfluenced.sort();
    System.out.printf(SUMMARY_FORMAT, "Red", redInfluenced, redCount);
    System.out.printf(SUMMARY_FORMAT, "Black", blackInfluenced, blackCount);
  }

  public static void main(String[] args) { // main method is static so it doesn't contain an instance of this class.
    Trick trick = new Trick();
    trick.split();
    trick.swap();
    trick.summarize();
    // Pick a random number of cards between 0 (inclusive) and the size of the smaller pile
    //  (inclusive) and swap that many cards between piles.

  }
}
