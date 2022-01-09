package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Marble {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer[] cards = new Integer[sc.nextInt()];
		int coin = 0;
		
		for (int i = 0; i < cards.length; i++) cards[i] = sc.nextInt();
		Arrays.sort(cards, Collections.reverseOrder());
		
		for (int i = 1; i < cards.length; i++) coin += cards[0] + cards[i];
		
		System.out.println(coin);
	}
}