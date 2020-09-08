import java.util.ArrayList;

public class BlackjackHand implements Hand {
	private ArrayList<Card> cards = new ArrayList<>();

	public BlackjackHand(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public int computeScore() {
		int total = 0;
		for (Card card : cards) {
			total = total + getCardValue(card);
//			if (total > 21 && card.getName().equals("A")) {
//				// ah, the above logic only works if it's an ace that brings the total over 21.
//				// reassign the Ace to be worth 1 instead of 11 if total goes over 21
//				total = total - 11 + 1;
//			}
		}
		if (total > 21) {
			// check if there are any aces
			int remAces = 0;
			for (Card c : cards) {
				if (c.getName().equals("A")) {
					remAces++;
				}
			}
			// now subtract 10 (replacing value of 11 with 1) from score for each ace until it's below 21
			while (total > 21 && remAces > 0) {
				total = total - 10;
				remAces--;
			}
		}
		return total;
	}

	private int getCardValue(Card card) { 
		// use string name
		String name = card.getName();
		if (name.equals("J") || name.equals("Q") || name.equals("K")) {
			return 10;
		} else if (name.equals("A")) {
			return 11;
		} else {
			return card.getRank();
		}
	}
	
	// should add a method somewhere to generate a random card to add. 
	public void addCard(Card card) {
		this.cards.add(card);
	}
	public int getSize() {
		return cards.size();
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
}
