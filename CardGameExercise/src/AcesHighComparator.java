import java.util.Comparator;

public class AcesHighComparator implements Comparator<Card> {

	public int compare(Card a, Card b) {
		int rankA = a.getRank();
		int rankB = b.getRank();
		// aces have a rank of 1 but we want them to be the highest. reassign to 14
		if (rankA == 1) rankA = 14;
		if (rankB == 1) rankB = 14;
		return rankA - rankB;
	}
	
}
