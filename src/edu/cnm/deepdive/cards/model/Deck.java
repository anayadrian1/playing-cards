package edu.cnm.deepdive.cards.model;

public class Deck extends Wash {

  public Deck() { // every enum has a static method values that returns the enumerated values

    for (Suit suit : Suit.values()) { // for each suit, iterate through the rank
      for (Rank rank : Rank.values()) {
        Card card = new Card(rank, suit);
        add(card);
      }
    }
  }

}
