import java.util.ArrayList;

public class PokerHand implements Hand {
	private ArrayList<Card> cards = new ArrayList<>();
	private int handRank; // 1 - 9 with:
	/* 
	 * 9 - Straight Flush
	 * 8 - Four of a Kind
	 * 7 - Full House
	 * 6 - Flush
	 * 5 - Straight
	 * 4 - Three of a Kind
	 * 3 - Two Pair
	 * 2 - Pair
	 * 1 - High Card
	 */
	private String handName; // name of hand from list above
	private int handhighCardRank; // rank of high card within hand.
	private int highCardRank; // rank of high card outside of hand, or within if hand uses all 5 cards (hand ranks 9, 7, 6, 5)
	private Card highCard; // overall high card in hand.

	public PokerHand(ArrayList<Card> cards) {
		// ensure there are 5 cards.
		if (cards.size() != 5) {
			System.out.println("Must have 5 cards in a Poker hand.");
			return;
		}
		this.cards = cards;
		assignRankAndhighCardRank();
		setHandName();
	}
	
	// check for the hand and assign hand rank, hand high card and outside high card as variables on the calss instance.
	private void assignRankAndhighCardRank() { 
		// hmm ... i really should set the high card from within each one of these methods, for consistency? 'cause i'm finding the rank of the card within each of them anyway.. 
		
		if (hasStraightFlush() > 0) {
			this.handRank = 9;
			this.handhighCardRank = hasStraightFlush();
			this.highCard = findHighCard(cards);
			this.highCardRank = highCard.getRank();
			
		} else if (hasFourOfAKind() > 0) {
			this.handRank = 8;
			this.handhighCardRank = hasFourOfAKind();
			// high card outside of hand is set from within hasNOfAKind method
			
		} else if (hasFullHouse() > 0) {
			this.handRank = 7;
			this.handhighCardRank = hasFullHouse();
			this.highCard = findHighCard(cards);
			this.highCardRank = highCard.getRank();
			
		} else if (hasFlush() > 0) {
			this.handRank = 6;
			this.handhighCardRank = hasFlush();
			this.highCard = findHighCard(cards);
			this.highCardRank = highCard.getRank();

		} else if (hasStraight() > 0) {
			// if a straight is A through 5, want the high card to be recorded as 5, not A-
			this.handRank = 5;
			this.handhighCardRank = hasStraight();
			this.highCard = findHighCard(cards);
			this.highCardRank = highCard.getRank();
			
		} else if (hasThreeOfAKind() > 0) {
			this.handRank = 4;
			this.handhighCardRank = hasThreeOfAKind();
			// high card outside of hand is set from within hasNOfAKind method
			
		} else if (hasTwoPair() > 0) {
			this.handRank = 3;
			this.handhighCardRank = hasTwoPair();
			// high card outside of hand is set from within hasNOfAKind method

		} else if (hasPair() > 0) {
			this.handRank = 2;
			this.handhighCardRank = hasPair();
			// high card outside of hand is set from within hasNOfAKind method

		} else {
			this.handRank = 1;
			this.highCard = findHighCard(cards);
			this.highCardRank = highCard.getRank();
		}
	}


	// set hand name based on hand rank
	private void setHandName() {
		if (handRank == 9) {
			this.handName = "Straight Flush";
		} else if (handRank == 8) {
			this.handName = "Four of a Kind";
		} else if (handRank == 7) {
			this.handName = "Full House";
		} else if (handRank == 6) {
			this.handName = "Flush";
		} else if (handRank == 5) {
			this.handName = "Straight";
		} else if (handRank == 4) {
			this.handName = "Three of a Kind";
		} else if (handRank == 3) {
			this.handName = "Two Pair";
		} else if (handRank == 2) {
			this.handName = "Pair";
		} else {
			this.handName = "High Card";
		}
	}
	
	// methods check for the different hands!
	
	// straight flush
	// returns rank of highest card in straight if straight flush is present, otherwise returns 0.
	public int hasStraightFlush() {
		// check for flush. 
		if (hasFlush() == 0) {
			// if no flush present, return 0
			return 0;
		} else {
			// we have a flush. check for straight and return the highest card in straight
			int straightRanking = hasStraight();
			return straightRanking;
		}
	}
	
	// returns card rank if there is a N of a kind, otherwise returns 0.
	// generalized to be able to check for 2, 3 or 4 of a kind.
	// takes number of repeated cards to check for n, as well as arraylist of cards to check through in order to enable checking for pairs in remaining cards for full house and two pair. method is private.
	private int hasNOfAKind(int n, ArrayList<Card> cards) {
		if (n > 4 || n > cards.size()) return 0;
		int rank = 0;
		for (Card cardA : cards) {
			// for each card, check if there are n-1 others of the same rank contained in the other cards
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
				// we also want to check what the high card is, to be used for comparing. remove all cards with matching rank
				// can we edit an arraylist while iterating over it? probs not... create a new one
				ArrayList<Card> cardsToCheckHigh = new ArrayList<Card>();
				for (Card card : remCards) {
					if (card.getRank() != rank) {
						cardsToCheckHigh.add(card);
					}
				}
				// now check for high card and set as variable on the instance
				this.highCard = findHighCard(cardsToCheckHigh);
				this.highCardRank = highCard.getRank();
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
	
	// pair
	public int hasPair() {
		return hasNOfAKind(2, cards);
	}
	
	// two pair. return rank of highest pair
	public int hasTwoPair() {
		// check first for a pair
		int firstPairRank = hasNOfAKind(2, cards);
		// if no pair, return 0
		if (firstPairRank == 0) return 0;
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
	
	// flush. returns rank of highest card if flush is present, otherwise returns 0.
	public int hasFlush() {
		int rank = 0;
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
				// nope. don't want to return the suit, it's not relevant. what we actually need is the rank of the higest card. check for highest card.
				// note use of overloaded method - can't send this.cards to the method from within a loop iterating over this.cards, throws concurrentmodificationexception - so if no argument is sent, automatically run on this.cards
				rank = findHighCard().getRank();
			}
		}
		return rank;
	}
	
	// straight. return int representing rank of highest card in straight.
	public int hasStraight() {
		// integer to return
		int topRank = 0;
		// order the cards using aces high. aces can be low in a straight, too. need to check both!
		ArrayList<Card> orderedAcesHigh = new ArrayList<Card>();
		for (Card c : cards) {
			orderedAcesHigh.add(c);
		}
		orderedAcesHigh.sort(new AcesHighComparator());
		// check if each successive one is one higher in rank than the previous
		for (int i = 0; i < 4; i++) {
			int difference = orderedAcesHigh.get(i + 1).getRank() - orderedAcesHigh.get(i).getRank();
			if (difference != 1 && difference != -12) {
				// difference of -12 implies king then ace.
				// ugh this is a super messy way to patch this up.
				break;
			}
			if (i == 3) {
				// hand is a straight. return rank of highest ranking card. note this will be 1 for an ace high flush.
				topRank = orderedAcesHigh.get(i + 1).getRank();
				return topRank;
			}
		}
		
		// run same check for aces low. bit of code repitition here. could break out to separate method.
		ArrayList<Card> orderedAcesLow = new ArrayList<Card>();
		for (Card c : cards) {
			orderedAcesLow.add(c);
		}
		orderedAcesLow.sort(new AcesLowComparator());
		// check if each successive one is one higher in rank than the previous
		for (int i = 0; i < 4; i++) {
			if (orderedAcesLow.get(i + 1).getRank() - orderedAcesLow.get(i).getRank() != 1) {
				// hand is not a straight.
				break;
			}
			if (i == 3) {
				// hand is a straight. return rank of highest ranking card
				topRank = orderedAcesLow.get(i + 1).getRank();
			}
		}
		return topRank;
		
	}

	// high card. return rank of highest ranking card (aces are high)
	// overloaded method. takes arraylist of cards as an argument in order to be able to check um. the remaining cards from other hands.
	// ### should really have the high card reference a Card itself, not just an integer representing its rank. that way we can easily grab its name for printing.
	public Card findHighCard(ArrayList<Card> cards) {
		cards.sort(new AcesHighComparator());
//		return cards.get(cards.size() - 1).getRank();
		return cards.get(cards.size() - 1);
	}
	
	// overloaded method - if no argument is sent, run on this.cards.
	public Card findHighCard() {
		// use aces high comparator to order cards. don't edit ordering on the hand itself.
		ArrayList<Card> orderedAcesHigh = new ArrayList<Card>();
		for (Card c : cards) {
			orderedAcesHigh.add(c);
		}
		orderedAcesHigh.sort(new AcesHighComparator());
//		return orderedAcesHigh.get(4).getRank();
		return orderedAcesHigh.get(4);
	}
	
	
	public int getSize() {
		return cards.size(); // should be 5!
	}
	
	public int getHandRank() {
		return handRank;
	}

	public Card getHighCard() {
		return highCard;
	}
	
	public int getHighCardRank() {
		return highCardRank;
	}

	public int gethandhighCardRank() {
		return handhighCardRank;
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
	
	public void getHandDescription() {
		if (handRank == 9 || handRank == 6) {			
			System.out.printf("%s with high card %s%n", handName, highCard.getName());
		} else if (handRank == 7) {
			System.out.printf("%s with triple %s%n", handName, highCard.getName());
		} else if (handRank == 5) {
			// ### for a straight need to be able to grab the handHighCard and its name. save as variable not just the rank. the straight is ordered correctly by the comparator but I just want to be able to accurately describe the hand (currently printing as Straight with high card A)
			// maybe I should change "high card" to "kicker" to stop confusion with handHighCard...
			System.out.println("%s with high card %s%n", handName, handhighCardRank.getName());
		} else {
			System.out.printf("%s in %ss with high card %s%n", handName, handhighCardRank, highCard.getName());
		}
	}
}
