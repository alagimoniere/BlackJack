/*
* BlackJack.java
* Author: Alyssa Lagimoniere
* Submission Date: 4/24/15
* 
* Purpose: Implements all of the methods from the other classes to play the game.
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
 * Class representing a single player blackjack game
 */
public class BlackJack {
	
	private Deck deck;
	private Dealer dealer;
	private Player player;


	/**
	 * Constructs and prepares for a new game of BlackJack.
	 * Creates player, dealer and deck objects then shuffles
	 * the deck and gives both the dealer and player two cards.
	 */
	public BlackJack() {
		player = new Player();
		dealer = new Dealer();
		deck = new Deck();
		deck.shuffle();
		player.getHand().addCard(deck.draw());
		player.getHand().addCard(deck.draw());
		dealer.getHand().addCard(deck.draw());
		dealer.getHand().addCard(deck.draw());
	}
	
	/**
	 * Restarts in a few steps
	 * 1. The Player and dealer return their cards to the deck.
	 * 2. The deck is shuffled.
	 * 3. Both the player and the dealer receive two cards drawn form the top of the deck.
	 */
	public void restart() {
		Card [] discard = player.getHand().emptyHand();
		for (int i = 0; i < discard.length; i++) {
			deck.addToBottom(discard[i]);
		}
		discard = dealer.getHand().emptyHand();
		for (int i = 0; i < discard.length; i++) {
			deck.addToBottom(discard[i]);
		}
		deck.shuffle();
		player.getHand().addCard(deck.draw());
		player.getHand().addCard(deck.draw());
		dealer.getHand().addCard(deck.draw());
		dealer.getHand().addCard(deck.draw());
	}
	
	/**
	 * Returns the value of a card in a standard game of Blackjack based on the type of the card
	 * ex. An Ace would return 1, a 2 would return 2... 
	 * @param c card whose value is extracted
	 * @return value of the card
	 */
	public static int getValueOfCard(Card c) {
		String s = c.getType().toString();
		switch(s) {
		case "ACE": return 1;
		case "TWO": return 2;
		case "THREE": return 3;
		case "FOUR": return 4;
		case "FIVE": return 5;
		case "SIX": return 6;
		case "SEVEN": return 7;
		case "EIGHT": return 8;
		case "NINE": return 9;
		default: return 10;
		}
	}
	
	/**
	 * Returns the maximum value of the hand that does not result in a bust
	 * @param h Hand whose value is returned
	 * @return value of h
	 */
	public static int getValueOfHand(Hand h) {
		Card [] copy = h.getCards();
		int aces = 0;
		int value = 0;
		for (int i = 0; i < copy.length; i++) {
			value += BlackJack.getValueOfCard(copy[i]);
			if (copy[i].getType().toString().equals("ACE")) {
				aces++;
				value += 10;
			}
		}
		while (value > 21 && aces > 0) {
			value -= 10;
			aces--;
		}
		return value;
	}

	/**
	 * @return Deck used to play
	 */
	public Deck getDeck() {
		return deck;
	}
	
	/**
	 * @return Dealer of the game
	 */
	public Dealer getDealer() {
		return dealer;
	}
	
	/**
	 * @return Player playing the blackjack game
	 */
	public Player getPlayer() {
		return player;
	}

}
