import java.util.Comparator;

public class AcesLowComparator implements Comparator<Card> {

	public int compare(Card a, Card b) {
		// only comparing rank, not suit. Aces have a rank of one and are low.
		return a.getRank() - b.getRank();
	}
}
