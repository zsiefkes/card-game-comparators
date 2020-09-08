import java.util.ArrayList;
import java.util.Collections;

public class CardsPlayground {
	
	public CardsPlayground() {
//		this.testCardClass();
		this.testBlackjackClass();
	}
	
	private void testBlackjackClass() {
		ArrayList<BlackjackHand> hands = new ArrayList<BlackjackHand>();
		// arraylist to hold the cards for our blackjack hand
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("Hearts", 1));
		cards.add(new Card("Diamonds", 4));
		BlackjackHand blackjackHand = new BlackjackHand(cards);
		System.out.println("score: " + blackjackHand.computeScore());
		blackjackHand.addCard(new Card("Spades", 3));
		System.out.println("score: " + blackjackHand.computeScore());		
		// add a card bringing total value over 21, should reassign A to 1
		blackjackHand.addCard(new Card("Hearts", 8));
		System.out.println("score: " + blackjackHand.computeScore());
		// nice! now add another ace and see how it does
		blackjackHand.addCard(new Card("Clubs", 1));
		System.out.println("score: " + blackjackHand.computeScore());
		// fuck yes!
		blackjackHand.addCard(new Card("Clubs", 11));
		System.out.println("score: " + blackjackHand.computeScore());
		// excellent.
	}
	
	private void testCardClass() {
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
	
	public static void main(String[] args) {
		new CardsPlayground();
	}
}
