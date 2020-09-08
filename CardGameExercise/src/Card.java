import java.util.ArrayList;
import java.util.Collections;

public class Card {
	private String name; // A, 2-10, J, Q, K. use comparator to sort Aces high or low.
	private int rank; // 1-13. use comparator to sort Aces high or low.
	private String suit; // Spades, Hearts, Diamonds, Clubs

	public Card(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;
		this.assignName();
	}
	
	private void assignName() {
		if (rank == 1) {
			this.name = "A";
		} else if (rank == 11) {
			this.name = "J";
		} else if (rank == 12) {
			this.name = "Q";
		} else if (rank == 13) {
			this.name = "K";
		} else {
			this.name = Integer.toString(rank);
		}
	}

	public String getSuit() {
		return suit;
	}
	public int getRank() {
		return rank;
	}
	public String getName() {
		return name;
	}
	public String getDescriptor() {
		// eg. A of Spades, 7 of Clubs, Q of Diamonds 
		return this.name + " of " + this.suit;
	}
	
	public static void main(String[] args) {
		// create list of cards to test our comparators
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("Clubs", 1));
		cards.add(new Card("Hearts", 4));
		cards.add(new Card("Diamonds", 8));
		cards.add(new Card("Spades", 1));
		for (Card c : cards) {
			System.out.println(c.getDescriptor());
		}
		// order with aces low
		Collections.sort(cards, new AcesLowComparator());
		System.out.println("--------------------------");
		for (Card c : cards) {
			System.out.println(c.getDescriptor());
		}
		// order with aces high
		Collections.sort(cards, new AcesHighComparator());
		System.out.println("--------------------------");
		for (Card c : cards) {
			System.out.println(c.getDescriptor());
		}
		// order by suit
		Collections.sort(cards, new SuitComparator());
		System.out.println("--------------------------");
		for (Card c : cards) {
			System.out.println(c.getDescriptor());
		}
	}
}
