package problems.until099;

import java.io.IOException;
import java.util.Arrays;

import problems.Utilities.EulerUtility;

// solved

public class Problem054 {

	private static String filePath = "/Users/joelniklaus/Google Drive/Privat/Informatik/Java/ProjectEuler/src/problems/Files/p054_poker.txt";
	private static int numberOfPlayerOneWins = 0;

	public static void main(String[] args) throws IOException {
		String handsString = EulerUtility.readFile(filePath);
		
		// replace images with numbers to calculate more easily
		handsString = handsString.replaceAll("T", "10");
		handsString = handsString.replaceAll("J", "11");
		handsString = handsString.replaceAll("Q", "12");
		handsString = handsString.replaceAll("K", "13");
		handsString = handsString.replaceAll("A", "14");

		String handsLines[] = handsString.split(System.lineSeparator());

		String[][] hands = new String[handsLines.length][10];
		for (int line = 0; line < handsLines.length; line++)
			hands[line] = handsLines[line].split(" ");
		
		// String[] player1 = { "11D", "13D", "10D", "10D", "8D" };
		// String[] player2 = { "4D", "12C", "12D", "8H", "8S" };
		// int[] player1Values = sortValues(player1);
		// int[] player2Values = sortValues(player2);
		
		// String[] testHands = { "12D", "13D", "14D", "4D", "11D", "8S", "9S", "6S", "10S", "7S" };
		// checkHands(testHands);
		// System.out.println(numberOfPlayerOneWins);

		// for (int i = 0; i < hands.length; i++) {
		// for (int j = 0; j < hands[0].length; j++)
		// System.out.print(hands[i][j] + " ");
		// System.out.println();
		// }
		
		for (String[] handsLine : hands)
			checkHands(handsLine);
		System.out.println(numberOfPlayerOneWins);
	}
	
	public static void checkHands(String[] hands) {
		String[] player1 = new String[hands.length / 2], player2 = new String[hands.length / 2];
		
		for (int i = 0; i < hands.length / 2; i++)
			player1[i] = hands[i];
		for (int i = hands.length / 2; i < hands.length; i++)
			player2[i - hands.length / 2] = hands[i];
		
		int[] player1Values = sortValues(player1);
		int[] player2Values = sortValues(player2);

		if (straightFlush(player1) > straightFlush(player2)) {
			numberOfPlayerOneWins++;
			return;
		} else if (straightFlush(player1) < straightFlush(player2))
			return;
		
		if (fourOfAKind(player1) > fourOfAKind(player2)) {
			numberOfPlayerOneWins++;
			return;
		} else if (fourOfAKind(player1) < fourOfAKind(player2))
			return;

		if (fullHouse(player1) > fullHouse(player2)) {
			numberOfPlayerOneWins++;
			return;
		} else if (fullHouse(player1) < fullHouse(player2))
			return;
		
		if (flush(player1) > flush(player2)) {
			numberOfPlayerOneWins++;
			return;
		} else if (flush(player1) < flush(player2))
			return;
		else if (flush(player1) == flush(player2) && flush(player1) != 0)
			if (checkFlushCascade(player1Values, player2Values)) {
				numberOfPlayerOneWins++;
				return;
			}

		if (straight(player1) > straight(player2)) {
			numberOfPlayerOneWins++;
			return;
		} else if (straight(player1) < straight(player2))
			return;
		
		if (threeOfAKind(player1) > threeOfAKind(player2)) {
			numberOfPlayerOneWins++;
			return;
		} else if (threeOfAKind(player1) < threeOfAKind(player2))
			return;
		
		if (twoPairs(player1) > twoPairs(player2)) {
			numberOfPlayerOneWins++;
			return;
		} else if (twoPairs(player1) < twoPairs(player2))
			return;
		else if (twoPairs(player1) == 1 && twoPairs(player2) == 1)
			if (checkTwoPairsCascade(player1Values, player2Values)) {
				numberOfPlayerOneWins++;
				return;
			}

		if (onePair(player1) > onePair(player2)) {
			numberOfPlayerOneWins++;
			return;
		} else if (onePair(player1) < onePair(player2))
			return;
		else if (onePair(player1) == 1 && onePair(player2) == 1)
			if (checkOnePairCascade(player1Values, player2Values)) {
				numberOfPlayerOneWins++;
				return;
			}

		if (checkHighCardCascade(player1Values, player2Values)) {
			numberOfPlayerOneWins++;
			return;
		}
	}

	public static boolean checkHighCardCascade(int[] player1Values, int[] player2Values) {
		for (int i = player1Values.length - 1; i >= 0; i--)
			if (player1Values[i] > player2Values[i])
				return true;
			else if (player1Values[i] == player2Values[i])
				continue;
			else if (player1Values[i] < player2Values[i])
				return false;
		return false;
	}
	
	public static boolean checkOnePairCascade(int[] player1Values, int[] player2Values) {
		player1Values = bringPairToTheRear(player1Values);
		player2Values = bringPairToTheRear(player2Values);
		return checkHighCardCascade(player1Values, player2Values);
	}

	private static int[] bringPairToTheRear(int[] values) {
		for (int i = values.length - 1; i >= 0; i--) {
			int currentTempValue = values[i];
			int currentNextValue = values[i - 1];
			if (currentTempValue == currentNextValue) {
				values[i] = values[values.length - 1];
				values[i - 1] = values[values.length - 2];
				values[values.length - 1] = currentTempValue;
				values[values.length - 2] = currentNextValue;
				break;
			}
		}
		return values;
	}
	
	public static boolean checkTwoPairsCascade(int[] player1Values, int[] player2Values) {
		player1Values = bringSingleCardToTheFront(player1Values);
		player2Values = bringSingleCardToTheFront(player2Values);
		return checkHighCardCascade(player1Values, player2Values);
	}
	
	private static int[] bringSingleCardToTheFront(int[] values) {
		for (int i = values.length - 1; i >= 0; i--) {
			int currentTempValue = values[i];
			if (i == values.length - 1)
				if (currentTempValue != values[i - 1]) {
					values[i] = values[0];
					values[0] = currentTempValue;
					return values;
				}
			if (i == 0)
				if (currentTempValue != values[i + 1]) {
					values[i] = values[0];
					values[0] = currentTempValue;
					return values;
				}
			if (i < values.length - 1 && i > 0)
				if (currentTempValue != values[i - 1] && currentTempValue != values[i + 1]) {
					values[i] = values[0];
					values[0] = currentTempValue;
					return values;
				}
		}
		return values;
	}
	
	public static boolean checkFlushCascade(int[] player1Values, int[] player2Values) {
		return checkHighCardCascade(player1Values, player2Values);
	}
	
	// // returns the value of the highest card of the hand
	// private static int highCard(String[] hand) {
	// return getHighestCard(hand);
	// }

	// returns 1 if the hand contains a pair, 0 otherwise
	public static int onePair(String[] hand) {
		return nOfAKind(hand, 2, 0);
	}
	
	// returns 1 if the hand contains two pairs, 0 otherwise
	public static int twoPairs(String[] hand) {
		return nOfAKind(hand, 4, 0);
	}
	
	// returns the value if the hand contains three of a kind, 0 otherwise
	public static int threeOfAKind(String[] hand) {
		return nOfAKind(hand, 6, 3);
	}

	// returns the highest value if the hand contains a straight, 0 otherwise
	public static int straight(String[] hand) {
		int currentSmallest = 14;
		int currentBiggest = 1;
		for (int i = 0; i < hand.length; i++) {
			int currentValue = getValue(hand[i]);
			if (currentValue < currentSmallest)
				currentSmallest = currentValue;
			if (currentValue > currentBiggest)
				currentBiggest = currentValue;
		}
		if (currentBiggest - currentSmallest != 4)
			return 0;
		for (int i = 0; i < hand.length; i++) {
			int currentValue = getValue(hand[i]);
			if (currentValue == getValue(hand[0]) && i != 0)
				return 0;
			if (currentValue == getValue(hand[1]) && i != 1)
				return 0;
			if (currentValue == getValue(hand[2]) && i != 2)
				return 0;
			if (currentValue == getValue(hand[3]) && i != 3)
				return 0;
			if (currentValue == getValue(hand[4]) && i != 4)
				return 0;
		}
		return currentBiggest;
	}

	// returns the highest value if the hand contains a flush, 0 otherwise
	public static int flush(String[] hand) {
		for (int i = 1; i < hand.length; i++)
			if (!hand[0].substring(hand[0].length() - 1).equals(
					hand[i].substring(hand[i].length() - 1)))
				return 0;
		return getHighestCard(hand);
	}
	
	// returns the value if the hand contains a full house, 0 otherwise
	public static int fullHouse(String[] hand) {
		return nOfAKind(hand, 8, 3);
	}

	// returns the value if the hand contains four of a kind, 0 otherwise
	public static int fourOfAKind(String[] hand) {
		return nOfAKind(hand, 12, 4);
	}
	
	// returns the highest value if the hand contains a straight flush, 0 otherwise
	public static int straightFlush(String[] hand) {
		if (flush(hand) > 0 && straight(hand) > 0)
			return flush(hand);
		return 0;
	}
	
	private static int nOfAKind(String[] hand, int totalNumberOfEqualCards, int n) {
		int[] equalValuesCounters = new int[hand.length];
		for (int i = 0; i < hand.length; i++) {
			int currentValue = getValue(hand[i]);
			if (currentValue == getValue(hand[0]) && i != 0)
				equalValuesCounters[i]++;
			if (currentValue == getValue(hand[1]) && i != 1)
				equalValuesCounters[i]++;
			if (currentValue == getValue(hand[2]) && i != 2)
				equalValuesCounters[i]++;
			if (currentValue == getValue(hand[3]) && i != 3)
				equalValuesCounters[i]++;
			if (currentValue == getValue(hand[4]) && i != 4)
				equalValuesCounters[i]++;
		}

		int counterSum = 0;
		int sameKindIndex = 0;
		for (int i = 0; i < equalValuesCounters.length; i++) {
			counterSum += equalValuesCounters[i];
			if (equalValuesCounters[i] == n - 1)
				sameKindIndex = i;
		}
		if (counterSum == totalNumberOfEqualCards)
			if (sameKindIndex != 0)
				return getValue(hand[sameKindIndex]);
			else
				return 1;
		return 0;
	}
	
	private static int getHighestCard(String[] hand) {
		int currentBest = 2;
		for (int i = 0; i < hand.length; i++) {
			int currentValue = getValue(hand[i]);
			if (currentValue > currentBest)
				currentBest = currentValue;
		}
		return currentBest;
	}
	
	private static int getValue(String hand) {
		return Integer.parseInt(hand.substring(0, hand.length() - 1));
	}
	
	private static int[] sortValues(String[] hand) {
		int[] values = new int[hand.length];
		for (int i = 0; i < hand.length; i++)
			values[i] = getValue(hand[i]);
		Arrays.sort(values);
		return values;
	}
}
