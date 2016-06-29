/*
* Hand.java
* Author: Alyssa Lagimoniere
* Submission Date: 4/24/15
* 
* Purpose: Creates the hands used in the game BlackJack.
* 
* Statement of Academic Honesty:
* 
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on a programming project created by the Department of
* Computer Science at the University of Georgia. Any publishing
* of source code for this project is strictly prohibited without
* written consent from the Department of Computer Science. */

/**
 * 
 * @author ghyzel
 *
 */
public class Hand {
	
	/**
	 * The cards in the hand
	 */
	private Card [] cards;
	
	/**
	 * Creates an empty hand
	 */
	public Hand() {
		//Initializing an empty array. 
		//Calling cards.length on this array would return 0
		cards = new Card[0];		
	}

	/**
	 * Adds Card c to the hand
	 * 
	 * @param c card to be added
	 */
	public void addCard(Card c) {
		Card [] hand = new Card [cards.length + 1];
		for (int i = 0; i < cards.length; i++) {
			hand[i] = cards[i];
		}
		hand [hand.length - 1] = c;
		cards = hand;
	}
	
	/**
	 * @return number of cards in the hand
	 */
	public int size() {
		return cards.length;
	}
	
	/**
	 * Returns an array of all the cards in the hand
	 * 
	 * @return the cards in the hand
	 */
	public Card[] getCards() {
		Card [] cardsCopy = new Card [cards.length];
		for (int i = 0; i < cards.length; i++) {
			cardsCopy[i] = cards[i];
		}
		return cardsCopy;
	}
	
	/**
	 * Empties the hand, and returns an array containing the discarded cards.
	 * 
	 * @return the discarded cards
	 */
	public Card[] emptyHand() {
		Card [] discarded = new Card [cards.length];
		for (int i = 0; i < cards.length; i++) {
			discarded[i] = cards[i];
		}
		cards = new Card [0];
		return discarded;
	}
	
	/**
	 * Returns a String representation of the hand
	 * 
	 * E.g.
	 * 
	 * "Empty Hand"
	 * "1. ACE OF SPADES\n2. QUEEN OF HEARTS"
	 * 
	 * @return a String representing the hand
	 */
	@Override
	public String toString() {
		String empty = "Empty hand";
		if (cards.length == 0) {
			return empty;
		}
		String card = "";
		for (int i = 0; i < cards.length; i++) {
			card = i + ". " + cards.toString();
		}
		return card;
	}
}
