import java.util.ArrayList;

public class PokerHandComparator implements Comparator<PokerHand> {

	public int compare(PokerHand a, PokerHand b) {
		// oosh! let's do it! far out lol
		// fuck lol where do we even start?
		// i guess for each type, starting at the highest hand, check if the cards fit the criteria
		// send the arraylist of cards to each of the methods so we're not unnecessarily invoking the pokerHand.getCards() method over and over
		// should the hand checking logic live on the PokerHand class or the PokerHandComparator class?
		// i feel like checking each hand should live on the PokerHand class itself...
	}
	
	// straight flush
	private boolean hasStraightFlush(ArrayList<Card> hand) {
		for (Card card : hand) {
			
		}		
	}

	
	// full house
	
	// flush
	
	// straight
	
	// three of a kind
	
	// two pair
	
	// pair
	
	// high card
	
}
