public class Card {
	private String name; // A, 2-10, J, Q, K. use comparator to sort Aces high or low.
	private int rank; // 1-13. use comparator to sort Aces high or low.
	private String suit; // Spades, Hearts, Diamonds, Clubs

	// note cards are initialized with a string for the suit, and an integer representing the rank (1-13).
	public Card(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;
		this.assignName();
		System.out.println("Assigned name " + this.name + " to card with rank " + this.rank);
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
	
}
