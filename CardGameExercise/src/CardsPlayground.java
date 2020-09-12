import java.util.ArrayList;
import java.util.Collections;

public class CardsPlayground {
	
	public CardsPlayground() {
//		this.testCardClass();
//		this.testBlackjackClass();
		this.testPokerHandClass();
	}
	
	private void testPokerHandClass() {
//		testFourOfAKind();
//		testThreeOfAKind();
//		testTwoPair();
//		testPair();
//		testFlush();
//		testFullHouse();
//		testStraight();
		testStraightFlush();
	}
	
	private void testStraightFlush() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("Diamonds", 11));
		cards.add(new Card("Diamonds", 12));
		cards.add(new Card("Diamonds", 10));
		cards.add(new Card("Diamonds", 13));
		cards.add(new Card("Diamonds", 1));
		PokerHand handA = new PokerHand(cards);
		handA.displayHand();
		System.out.println(handA.hasStraightFlush());
		
		ArrayList<Card> cardsB = new ArrayList<Card>();
		cardsB.add(new Card("Spades", 1));
		cardsB.add(new Card("Spades", 2));
		cardsB.add(new Card("Spades", 3));
		cardsB.add(new Card("Spades", 4));
		cardsB.add(new Card("Spades", 5));
		PokerHand handB = new PokerHand(cardsB);
		handB.displayHand();
		System.out.println(handB.hasStraightFlush());
		
		ArrayList<Card> cardsC = new ArrayList<Card>();
		cardsC.add(new Card("Spades", 2));
		cardsC.add(new Card("Hearts", 3));
		cardsC.add(new Card("Clubs", 4));
		cardsC.add(new Card("Diamonds", 5));
		cardsC.add(new Card("Diamonds", 6));
		PokerHand handC = new PokerHand(cardsC);
		handC.displayHand();
		System.out.println(handC.hasStraightFlush());
	}
	
	private void testStraight() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("Spades", 11));
		cards.add(new Card("Hearts", 11));
		cards.add(new Card("Clubs", 10));
		cards.add(new Card("Diamonds", 10));
		cards.add(new Card("Diamonds", 1));
		PokerHand handA = new PokerHand(cards);
		handA.displayHand();
		System.out.println(handA.hasStraight());
		
		ArrayList<Card> cardsB = new ArrayList<Card>();
		cardsB.add(new Card("Spades", 1));
		cardsB.add(new Card("Hearts", 2));
		cardsB.add(new Card("Clubs", 3));
		cardsB.add(new Card("Diamonds", 4));
		cardsB.add(new Card("Spades", 5));
		PokerHand handB = new PokerHand(cardsB);
		handB.displayHand();
		System.out.println(handB.hasStraight());
		
		ArrayList<Card> cardsC = new ArrayList<Card>();
		cardsC.add(new Card("Spades", 10));
		cardsC.add(new Card("Hearts", 11));
		cardsC.add(new Card("Clubs", 12));
		cardsC.add(new Card("Diamonds", 13));
		cardsC.add(new Card("Diamonds", 1));
		PokerHand handC = new PokerHand(cardsC);
		handC.displayHand();
		System.out.println(handC.hasStraight());
	}
	
	private void testFullHouse() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("Spades", 11));
		cards.add(new Card("Hearts", 11));
		cards.add(new Card("Clubs", 10));
		cards.add(new Card("Diamonds", 10));
		cards.add(new Card("Diamonds", 1));
		PokerHand handA = new PokerHand(cards);
		handA.displayHand();
		System.out.println(handA.hasFullHouse());
		
		ArrayList<Card> cardsB = new ArrayList<Card>();
		cardsB.add(new Card("Spades", 1));
		cardsB.add(new Card("Hearts", 3));
		cardsB.add(new Card("Clubs", 1));
		cardsB.add(new Card("Diamonds", 1));
		cardsB.add(new Card("Diamonds", 3));
		PokerHand handB = new PokerHand(cardsB);
		handB.displayHand();
		System.out.println(handB.hasFullHouse());
		
		ArrayList<Card> cardsC = new ArrayList<Card>();
		cardsC.add(new Card("Spades", 5));
		cardsC.add(new Card("Hearts", 11));
		cardsC.add(new Card("Clubs", 11));
		cardsC.add(new Card("Diamonds", 5));
		cardsC.add(new Card("Diamonds", 11));
		PokerHand handC = new PokerHand(cardsC);
		handC.displayHand();
		System.out.println(handC.hasFullHouse());
	}
	
	private void testTwoPair() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("Spades", 11));
		cards.add(new Card("Hearts", 11));
		cards.add(new Card("Clubs", 10));
		cards.add(new Card("Diamonds", 10));
		cards.add(new Card("Diamonds", 1));
		PokerHand handA = new PokerHand(cards);
		handA.displayHand();
		System.out.println(handA.hasTwoPair());
		
		ArrayList<Card> cardsB = new ArrayList<Card>();
		cardsB.add(new Card("Spades", 1));
		cardsB.add(new Card("Hearts", 3));
		cardsB.add(new Card("Clubs", 3));
		cardsB.add(new Card("Diamonds", 1));
		cardsB.add(new Card("Diamonds", 11));
		PokerHand handB = new PokerHand(cardsB);
		handB.displayHand();
		System.out.println(handB.hasTwoPair());
		
		ArrayList<Card> cardsC = new ArrayList<Card>();
		cardsC.add(new Card("Spades", 1));
		cardsC.add(new Card("Hearts", 1));
		cardsC.add(new Card("Clubs", 1));
		cardsC.add(new Card("Diamonds", 5));
		cardsC.add(new Card("Diamonds", 11));
		PokerHand handC = new PokerHand(cardsC);
		handC.displayHand();
		System.out.println(handC.hasTwoPair());
	}

	private void testPair() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("Spades", 11));
		cards.add(new Card("Hearts", 11));
		cards.add(new Card("Clubs", 11));
		cards.add(new Card("Diamonds", 2));
		cards.add(new Card("Diamonds", 1));
		PokerHand handA = new PokerHand(cards);
		handA.displayHand();
		System.out.println(handA.hasPair());

		ArrayList<Card> cardsB = new ArrayList<Card>();
		cardsB.add(new Card("Spades", 1));
		cardsB.add(new Card("Hearts", 2));
		cardsB.add(new Card("Clubs", 3));
		cardsB.add(new Card("Diamonds", 4));
		cardsB.add(new Card("Diamonds", 11));
		PokerHand handB = new PokerHand(cardsB);
		handB.displayHand();
		System.out.println(handB.hasPair());

		ArrayList<Card> cardsC = new ArrayList<Card>();
		cardsC.add(new Card("Spades", 1));
		cardsC.add(new Card("Hearts", 1));
		cardsC.add(new Card("Clubs", 2));
		cardsC.add(new Card("Diamonds", 5));
		cardsC.add(new Card("Diamonds", 11));
		PokerHand handC = new PokerHand(cardsC);
		handC.displayHand();
		System.out.println(handC.hasPair());
	}
	
	
	private void testThreeOfAKind() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("Spades", 11));
		cards.add(new Card("Hearts", 11));
		cards.add(new Card("Clubs", 11));
		cards.add(new Card("Diamonds", 2));
		cards.add(new Card("Diamonds", 11));
		PokerHand handA = new PokerHand(cards);
		handA.displayHand();
		System.out.println(handA.hasThreeOfAKind());
		// returns 5! seems to work. let's try another.
		ArrayList<Card> cardsB = new ArrayList<Card>();
		cardsB.add(new Card("Spades", 1));
		cardsB.add(new Card("Hearts", 5));
		cardsB.add(new Card("Clubs", 5));
		cardsB.add(new Card("Diamonds", 5));
		cardsB.add(new Card("Diamonds", 11));
		PokerHand handB = new PokerHand(cardsB);
		handB.displayHand();
		System.out.println(handB.hasThreeOfAKind());
		// returns 0. Good. one more
		ArrayList<Card> cardsC = new ArrayList<Card>();
		cardsC.add(new Card("Spades", 1));
		cardsC.add(new Card("Hearts", 1));
		cardsC.add(new Card("Clubs", 2));
		cardsC.add(new Card("Diamonds", 5));
		cardsC.add(new Card("Diamonds", 11));
		PokerHand handC = new PokerHand(cardsC);
		handC.displayHand();
		System.out.println(handC.hasThreeOfAKind());
	}
	
	
	private void testFourOfAKind() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("Spades", 5));
		cards.add(new Card("Hearts", 5));
		cards.add(new Card("Clubs", 5));
		cards.add(new Card("Diamonds", 5));
		cards.add(new Card("Diamonds", 11));
		PokerHand handA = new PokerHand(cards);
		handA.displayHand();
		System.out.println(handA.hasFourOfAKind());
		// returns 5! seems to work. let's try another.
		ArrayList<Card> cardsB = new ArrayList<Card>();
		cardsB.add(new Card("Spades", 1));
		cardsB.add(new Card("Hearts", 5));
		cardsB.add(new Card("Clubs", 5));
		cardsB.add(new Card("Diamonds", 5));
		cardsB.add(new Card("Diamonds", 11));
		PokerHand handB = new PokerHand(cardsB);
		handB.displayHand();
		System.out.println(handB.hasFourOfAKind());
		// returns 0. Good. one more
		ArrayList<Card> cardsC = new ArrayList<Card>();
		cardsC.add(new Card("Spades", 1));
		cardsC.add(new Card("Hearts", 1));
		cardsC.add(new Card("Clubs", 1));
		cardsC.add(new Card("Diamonds", 1));
		cardsC.add(new Card("Diamonds", 11));
		PokerHand handC = new PokerHand(cardsC);
		handC.displayHand();
		System.out.println(handC.hasFourOfAKind());
	}
	
	private void testFlush() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("Spades", 5));
		cards.add(new Card("Hearts", 5));
		cards.add(new Card("Clubs", 5));
		cards.add(new Card("Diamonds", 5));
		cards.add(new Card("Diamonds", 11));
		PokerHand handA = new PokerHand(cards);
		handA.displayHand();
		if (handA.hasFlush().equals("")) System.out.println("no flush");
		// good. let's try a flush.
		ArrayList<Card> cardsB = new ArrayList<Card>();
		cardsB.add(new Card("Spades", 1));
		cardsB.add(new Card("Spades", 2));
		cardsB.add(new Card("Spades", 5));
		cardsB.add(new Card("Spades", 7));
		cardsB.add(new Card("Spades", 11));
		PokerHand handB = new PokerHand(cardsB);
		handB.displayHand();
		System.out.println(handB.hasFlush());
		// returns 0. Good. one more
		ArrayList<Card> cardsC = new ArrayList<Card>();
		cardsC.add(new Card("Clubs", 1));
		cardsC.add(new Card("Clubs", 2));
		cardsC.add(new Card("Clubs", 3));
		cardsC.add(new Card("Clubs", 12));
		cardsC.add(new Card("Clubs", 11));
		PokerHand handC = new PokerHand(cardsC);
		handC.displayHand();
		System.out.println(handC.hasFlush());
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
