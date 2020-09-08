import java.util.ArrayList;

public class PokerHand implements Hand {
	private ArrayList<Card> cards = new ArrayList<>();

	public PokerHand(ArrayList<Card> cards) {
		// ensure there are 5 cards.
		if (cards.size() != 5) {
			System.out.println("Must have 5 cards in a Poker hand.");
			return;
		}
		this.cards = cards;
	}

	
	// straight flush
	
	// four of a kind. returns card rank if there is a four of a kind, otherwise returns 0.
	public int hasFourOfAKind() {
		int rank = 0;
		for (Card cardA : cards) {
			// for each card, check if there are 3 others of the same rank contained in the other hands
			ArrayList<Card> remCards = returnHandWithoutCard(cardA);
			// log number of matches
			int numMatches = 0;
			for (Card cardB : remCards) {
				if (cardB.getRank() == cardA.getRank()) {
					numMatches++;
				}
			}
			if (numMatches > 2) {
				rank = cardA.getRank();
			}
		}		
		return rank;
	}
	
	// motivation:
	//	ArrayList<Card> remCards = this.cards;
	//	remCards.remove(cardA);
		// just check hand hasn't been updated here....
	//	System.out.println("hand size should still be 5: " + this.cards.size());
		// AE!! since we set remCards equal to this.cards, and then removed a card from remCards, it bloody removes it from this.cards as well. okay, good to know. need to add them one by one.
	// going to have to use this a few times, should break out to its own function...
	private ArrayList<Card> returnHandWithoutCard(Card cardToRemove) {
		ArrayList<Card> remCards = new ArrayList<Card>();
		for (Card c : cards) {
			remCards.add(c);
		}
		remCards.remove(cardToRemove);
		return remCards;
	}
	
	// full house
	
	// flush. returns string containing flush suit, if one is present, otherwise returns empty string.
	public String hasFlush() {
		for (Card cardA : cards) {
			String suit = cardA.getSuit();
			int numMatches = 0;
			ArrayList<Card> remCards = returnHandWithoutCard(cardA);
			for (int i = 0; i < 4; i++) {
				if (remCards.get(i).getSuit().equalsIgnoreCase(suit)) {
					numMatches++;
				}
			}
			if (numMatches == 4) {
				return suit;
			}
		}
		return "";
	}
	
	// straight
	
	// three of a kind
	
	// two pair
	
	// pair
	
	// high card
	

	
	public int getSize() {
		return cards.size(); // should be 5!
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	public void displayHand() {
		System.out.println("Hand contains:");
		for (Card c : this.cards) {
			System.out.println(c.getDescriptor());
		}
	}
}
