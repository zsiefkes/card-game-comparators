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

	
	// four of a kind. returns card rank if there is a four of a kind, otherwise returns 0.
	public int hasFourOfAKind() {
//		boolean hasFourOfAKind = false;
		int rank = 0;
		for (Card cardA : this.cards) {
			// for each card, check if there are 3 others of the same rank contained in the other hands
			ArrayList<Card> remCards = new ArrayList<Card>();
			for (Card c : this.cards) {
				remCards.add(c);
			}
			remCards.remove(cardA);
//			ArrayList<Card> remCards = this.cards;
//			remCards.remove(cardA);
			// just check hand hasn't been updated here....
//			System.out.println("hand size should still be 5: " + this.cards.size());
			// AE!! since we set remCards equal to this.cards, and then removed a card from remCards, it bloody removes it from this.cards as well. okay, good to know. need to add them one by one.
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
