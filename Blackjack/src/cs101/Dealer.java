package cs101;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Dealer {

	private String[] deck;
	private int dealingIndex;

	public Dealer() {

		this.deck = new String[52];
		this.dealingIndex = 0;

		// make deck

		int index = 0;

		String[] suites = { "HEARTS", "CLUBS", "DIAMONDS", "SPADES" };

		for (int s = 0; s < suites.length; s++) {

			// add number cards
			for (int i = 2; i < 11; i++) {
				// add card to deck
				this.deck[index] = suites[s] + " " + i;

				// move to next slot
				index++;
			}

			// add face cards, aces
			this.deck[index] = suites[s] + " JACK";
			index++;
			this.deck[index] = suites[s] + " QUEEN";
			index++;
			this.deck[index] = suites[s] + " KING";
			index++;
			this.deck[index] = suites[s] + " ACE";
			index++;

		}

		this.shuffle();
		System.out.println(Arrays.toString(this.deck));

	}

	public void shuffle() {

		Random rand = new Random();

		for (int e = 0; e < this.deck.length; e++) {

			int random_index = rand.nextInt(this.deck.length);

			String temp = this.deck[random_index];
			this.deck[random_index] = this.deck[e];
			this.deck[e] = temp;

		}

	}

	// Don't call shuffle between!
	public String[] dealTwo() {

		String[] dealt = new String[2];

		dealt[0] = this.deck[this.dealingIndex];
		this.dealingIndex++;

		dealt[1] = this.deck[this.dealingIndex];
		this.dealingIndex++;

		return dealt;

	}

	public String dealOne() {

		String dealt = this.deck[this.dealingIndex];
		this.dealingIndex++;

		return dealt;

	}

	public int cardValue(String card) {
		String[] split = card.split(" ");

		if (split[1].equals("JACK")) {
			return 10;
		} else if (split[1].equals("QUEEN")) {
			return 10;
		} else if (split[1].equals("KING")) {
			return 10;
		} else if (split[1].equals("ACE")) {
			Scanner input = new Scanner(System.in);
			System.out.println("1 or 11?");

			String in = input.nextLine();
			return Integer.parseInt(in);
		} else {
			return Integer.parseInt(split[1]);
		}

	}

	public int handValue(String[] cards) {
		int value = 0;

		for (int i = 0; i < cards.length; i++) {
			value += this.cardValue(cards[i]);

		}

		return value;

	}

}

/*
 * Notes
 * 
 * Scanner myObj = new Scanner(System.in); // Create a Scanner object
 * 
 * String userName = myObj.nextLine();
 * 
 * 
 * Random rand = new Random();
 * 
 * // Generate random integers in range 0 to 999 int rand_int1 =
 * rand.nextInt(1000);
 * 
 */