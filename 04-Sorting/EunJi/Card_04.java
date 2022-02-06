package sorting;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Card_04 {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;

		for (int i = 0; i < N; i++) pq.add(sc.nextInt());

		while (pq.size() != 1) {
			int one = pq.poll();
			int two = pq.poll();
			int sum = one + two;
			result += sum;
			pq.add(sum);
		}
		System.out.println(result);
	}
}