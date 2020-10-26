package edu.cnm.deepdive.cards.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Wash implements Iterable<Card> { // pile

  private final List<Card> cards; // method in List thats an iterator

  public Wash() {
    cards = new ArrayList<>(); // good for accessing arbitrary positions
  }

  public void add(Card card) {
    cards.add(card);
  }

  public Card draw(Card card) {
    return cards.remove(0);
  }

  public void sort() {
    Collections.sort(cards); //cards.sort(null)
  }

  public void shuffle(Random rng) {
    Collections.shuffle(cards, rng);
  }

  @Override
  public Iterator<Card> iterator() {
    return cards.iterator();
  }

  @Override
  public String toString() {
    return cards.toString(); // lists have decent string representations
  }

  public int size() {
    return cards.size();
  }

  protected List<Card> getCards() { // protected allows subclasses to access as well as package
    return cards;
  }
}
