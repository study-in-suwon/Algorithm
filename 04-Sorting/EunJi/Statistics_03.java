package sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class Statistics_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> number = new ArrayList<Integer>();
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) number.add(sc.nextInt());
		number.sort(null);
		
		int sum = 0;
		for (Integer integer : number) sum += integer;
		
		System.out.println(Math.round((float)sum / N));
		System.out.println(number.get((N-1)/2));
		System.out.println(number.get(N-1) - number.get(0));
	}
}