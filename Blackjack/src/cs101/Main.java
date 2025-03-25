package cs101;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in); // Create a Scanner object
		Dealer jess = new Dealer();

		// deal dealer's cards
		String[] dealerCards = jess.dealTwo();
		System.out.println("Dealer shows: " + dealerCards[0]);

		// System.out.println("Value of dealer card is " +
		// jess.cardValue(dealerCards[0]));

		String[] startCards = jess.dealTwo();
		String totalHand = startCards[0] + ", " + startCards[1];

		System.out.println("Here's your hand: " + Arrays.toString(startCards));

		int totalHandValue = jess.handValue(startCards);
		System.out.println("The value of your hand is: " + totalHandValue);

		while (true) {

			System.out.println("Hit or Stand?");
			String hitOrStandInput = input.nextLine();

			if (hitOrStandInput.equals("hit")) {
				// deal another card
				String newCard = jess.dealOne();
				totalHand += ", " + newCard;
				totalHandValue += jess.cardValue(newCard);

				System.out.println("New Hand: " + totalHand);
				System.out.println("The value of your hand is: " + totalHandValue);

				// bust?
				if (totalHandValue > 21) {
					System.out.println("You busted!");
					break;
				}

			} else if (hitOrStandInput.equals("stand")) {
				// move to the end
				break;
			}

		}

		// ending - dealer shows cards
		System.out.println("You've activated my trap card! " + Arrays.toString(dealerCards));

		int totalDealerValue = jess.handValue(dealerCards);
		while (totalDealerValue <= 16) {

			String newCard = jess.dealOne();
			totalDealerValue += jess.cardValue(newCard);
			System.out.println("Dealer picks new card: " + newCard);
		}

		// did we win?

		System.out.println("The Dealer shows: " + totalDealerValue);

		if (totalHandValue > totalDealerValue && totalHandValue <= 21) {
			System.out.println("GG");
		}

	}

}
