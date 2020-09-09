import java.util.ArrayList;

import org.graalvm.compiler.phases.common.RemoveValueProxyPhase;

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
	
	
	// returns card rank if there is a N of a kind, otherwise returns 0.
	// generalized to be able to check for 2, 3 or 4 of a kind.
	private int hasNOfAKind(int n, ArrayList<Card> cards) {
		if (n > 4 || n > cards.size()) return 0;
		int rank = 0;
		for (Card cardA : cards) {
			// for each card, check if there are n-1 others of the same rank contained in the other hands
			ArrayList<Card> remCards = returnHandWithoutCard(cards, cardA);
			// log number of matches
			int numMatches = 0;
			for (Card cardB : remCards) {
				if (cardB.getRank() == cardA.getRank()) {
					numMatches++;
				}
			}
			if (numMatches > n-2) {
				rank = cardA.getRank();
			}
		}		
		return rank;
	}
	
	// four of a kind. 
	public int hasFourOfAKind() {
		return hasNOfAKind(4, cards);
	}
	
	// three of a kind
	public int hasThreeOfAKind() {
		return hasNOfAKind(3, cards);
	}
	
	// for this we need to be able to check for a pair, and then another pair in the remaining cards....
	// should my methods take an arraylist of cards as an argument? instead of all just referencing the instance variable this.cards? probably eh. maybe only hasNOfAKind() needs to, for the rest we use all 5 cards (in checking for straight flush, just check for both flush and straight.) also hasNOfAKind() is private so don't need to provide the cards from outside the class.
	// two pair. return rank of highest pair
	public int hasTwoPair() {
		// check first for a pair
		int firstPairRank = hasNOfAKind(2, cards);
		// run the removecard twice on the first pair ranking cards. first have to grab them
		ArrayList<Card> firstPair = new ArrayList<Card>();
		for (Card c : cards) {
			if (c.getRank() == firstPairRank) firstPair.add(c);
		}
		ArrayList<Card> remCards = returnHandWithoutCard(cards, firstPair.get(0));
		remCards = returnHandWithoutCard(remCards, firstPair.get(1));
		// now check for pair in remaining cards
		int secondPairRank = hasNOfAKind(2, remCards);
		// check for second pair and ensure rank doesn't match rank of first pair.
		if (secondPairRank > 0 && secondPairRank != firstPairRank) {
			if (firstPairRank == 1 || secondPairRank == 1) {
				// ah, now ...... we're playing aces high, so return aces if the top pair was aces.
				return 1;
			} else {
				return Math.max(firstPairRank, secondPairRank);
			}
		} else { 
			return 0;
		}
	}
	
	// pair
	public int hasPair() {
		return hasNOfAKind(2, cards);
	}
	
	// going to have to use this a few times, should break out to its own function...
	private ArrayList<Card> returnHandWithoutCard(ArrayList<Card> hand, Card cardToRemove) {
		ArrayList<Card> remCards = new ArrayList<Card>();
		for (Card c : hand) {
			remCards.add(c);
		}
		remCards.remove(cardToRemove);
		return remCards;
	}
	
	// full house. return rank of three of a kind, or 0 for no full house.
	// check for three of a kind, then check for pair in remaining two cards.
	public int hasFullHouse() {
		
		// check first for a triple
		int tripleRank = hasNOfAKind(3, cards);
		if (tripleRank == 0) return 0;
		
		// if a triple is found, remove triple and check for pair in remaining cards
		ArrayList<Card> triple = new ArrayList<Card>();
		for (Card c : cards) {
			if (c.getRank() == tripleRank) triple.add(c);
		}
		ArrayList<Card> remCards = returnHandWithoutCard(cards, triple.get(0));
		remCards = returnHandWithoutCard(remCards, triple.get(1));
		remCards = returnHandWithoutCard(remCards, triple.get(2));
		int pairRank = hasNOfAKind(2, remCards);
		if (pairRank > 0) {
			if (pairRank == 1 || tripleRank == 1) {
				// we're playing aces high, so return aces if the top pair was aces.
				return 1;
			} else {
				return Math.max(pairRank, tripleRank);
			}
		} else { 
			return 0;
		}
		
	}
	
	// flush. returns string containing flush suit, if one is present, otherwise returns empty string.
	public String hasFlush() {
		for (Card cardA : cards) {
			String suit = cardA.getSuit();
			int numMatches = 0;
			ArrayList<Card> remCards = returnHandWithoutCard(cards, cardA);
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
	
	// straight. return int representing rank of highest card in straight.
	public int hasStraight() {
		// for check card, check if the remaining four cards contain the card that immediately follows it
		for (Card cardA : cards) {
			int rankA = cardA.getRank();
		}
	}

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
