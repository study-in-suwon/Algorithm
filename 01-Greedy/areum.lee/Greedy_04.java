package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Greedy_04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Integer[] c = new Integer[n];
		for(int i = 0; i < n; i++) {
			c[i] = sc.nextInt();
		}
		
		sc.close();
		// 입력 끝

		// 연산 시작
		Arrays.sort(c, Collections.reverseOrder());
		
		int level = c[0];
		int gold = 0;
		
		for(int i = 1; i < n; i++) {
			gold += level + c[i];
		}
		
		System.out.println(gold);
		
	}
}
