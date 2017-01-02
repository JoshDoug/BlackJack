import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class BlackJack {

	public static void main(String[] args) {
		
		Scanner playerInput = new Scanner(System.in);
		
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList();
		
		Player player1 = new Player();
		Player player2 = new Player();
		ArrayList<Card> hand1 = new ArrayList();
		ArrayList<Card> hand2 = new ArrayList();
		
		for (Suits s : Suits.values()) {
		    for (Ranks r : Ranks.values()) {
		         Card c = new Card(s,r);
		         cards.add(c);
			}
		}
		
		deck.setCard(cards);
		
		//Now the deck is already shuffled and each card is 'random', so I don't need to 'randomly' pick each card.
		deck.shuffle();

		
		player1.setHand(hand1);
		player2.setHand(hand2);
		
		System.out.println("Player 1");
		hand1.add(cards.get(0));
		cards.remove(0);
		System.out.println(hand1.get(0).getRank());
		player1.setTotal(hand1.get(0).getRank().getValue());
		System.out.println(player1.getTotal());
		
		System.out.println("Player 2");
		hand2.add(cards.get(0));
		cards.remove(0);
		System.out.println(hand2.get(0).getRank());
		player2.setTotal(hand2.get(0).getRank().getValue());
		System.out.println(player2.getTotal());
		
		boolean stick1 = false;
		boolean stick2 = false;
		
		while (!(player1.getTotal() > 21 || player2.getTotal() > 21) && (stick1 == false && stick2 == false)) {
			//Player 1 Code
			if (stick1 == false) {
				System.out.println("Player 1 you've got " + player1.getTotal() + "! Stick or Twist?");
				String twick = playerInput.nextLine();
				if (twick.equals("t")) {
					hand1.add(0, cards.get(0));
					cards.remove(0);
					System.out.println(hand1.get(0).getRank());
					player1.setTotal(hand1.get(0).getRank().getValue());
					System.out.println(player1.getTotal());
					//Incase of ACE! Could I dump most of this in the method?
					if (player1.getTotal() > 21) {
						Iterator<Card> myIt = hand1.iterator();
						while (myIt.hasNext()) {
							Card currentCard = myIt.next();
							if (currentCard.getRank().getValue() == 11) {
								System.out.println("That was close! Looks like you've got an Ace in the hole!");
								myIt.remove();
								player1.setTotal(-10);
								System.out.println("Your new total is: " + player1.getTotal());
							}
						}
					}
				}
				else if (twick.equals("s")) {
					stick1 = true;
				}
			}
			//Player 2 Code
			if (stick2 == false) {
				System.out.println("Player 2 you've got " + player2.getTotal() + "! Stick or Twist?");
				String twick = playerInput.nextLine();
				if (twick.equals("t")) {
					hand2.add(0, cards.get(0));
					cards.remove(0);
					System.out.println(hand2.get(0).getRank());
					player2.setTotal(hand2.get(0).getRank().getValue());
					System.out.println(player2.getTotal());
					//Incase of ACE!
					if (player2.getTotal() > 21) {
						Iterator<Card> myIt = hand2.iterator();
						while (myIt.hasNext()) {
							Card currentCard = myIt.next();
							if (currentCard.getRank().getValue() == 11) {
								System.out.println("That was close! Looks like you've got an Ace in the hole!");
								myIt.remove();
								player2.setTotal(-10);
								System.out.println("Your new total is: " + player2.getTotal());
							}
						}
					}
				}
				else if (twick.equals("s")) {
					stick2 = true;
				}
			}
		}
		
		if (player1.getTotal() <= 21 && (player1.getTotal() > player2.getTotal() || player2.getTotal() > 21)) {
			System.out.println("Player 1 Wins, with a total of " + player1.getTotal());
		}
		else if (player2.getTotal() <= 21 && (player2.getTotal() > player1.getTotal() || player1.getTotal() > 21)) {
			System.out.println("Player 2 Wins, with a total of " + player2.getTotal());
		}
		else if (player2.getTotal() == player1.getTotal() && (player1.getTotal() <=21)) {
			System.out.println("It's a draw, or if you're a sore drawer you can check your cards to see who won,I'm not going to.");
		}
		else {
			System.out.println("Erm, not really sure what's happend here...did you both go over 21? Seriously?!");
		}
		
		playerInput.close();
	}
}