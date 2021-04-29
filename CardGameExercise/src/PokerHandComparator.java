import java.util.ArrayList;
import java.util.Comparator;

public class PokerHandComparator implements Comparator<PokerHand> {

	public int compare(PokerHand a, PokerHand b) {
		// now that we've set everything we need as instance variables, we can just go ahead and compare directly from the PokerHand class instance variables.
		
		// compare hand ranks. flush beats three of a kind, etc.
		int handRankDiff = a.getHandRank() - b.getHandRank();
		if (handRankDiff != 0) {
			return handRankDiff;
			
		} else {
			// if the hands are the same, check the rank within the hand. eg. pair aces beats pair 8s.
			int handHighCardDiff = a.gethandhighCardRank() - b.gethandhighCardRank();
			if (handHighCardDiff != 0) {
				return handHighCardDiff;
				
			} else {
				// we have a tie. check high card to break the tie. if high cards are the same, we have an overall tie of hands so can return 0.
				return a.getHighCardRank() - b.getHighCardRank();
			}
		}
		
	}
	
	// hand ranking order:
	// straight flush
	// four of a kind.
	// full house
	// flush
	// straight
	// three of a kind
	// two pair
	// pair
	// high card
}
