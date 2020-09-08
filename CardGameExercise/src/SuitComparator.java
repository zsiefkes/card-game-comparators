import java.util.Comparator;

public class SuitComparator implements Comparator<Card> {

	public int compare(Card a, Card b) {
		// clubs (lowest), diamonds, hearts, spades
		int suitRankA = assignSuitRank(a.getSuit());
		int suitRankB = assignSuitRank(b.getSuit());
		return suitRankA - suitRankB;
	}
	
	// just realised if it's alphabetical then ha lol we can just use the normal ordering on 
	
	// Alphabetical order (bridge order): clubs (lowest), diamonds, hearts, spades
	private int assignSuitRank(String suit) {
//		// clubs (lowest), diamonds, hearts, spades
		if (suit.equals("Clubs")) {
			return 1;
		} else if (suit.equals("Diamonds")) {
			return 2;
		} else if (suit.equals("Hearts")) {
			return 3;
		} else if (suit.equals("Spades")) {
			return 4;
		} else {
			return -1;
		}
	}
}
