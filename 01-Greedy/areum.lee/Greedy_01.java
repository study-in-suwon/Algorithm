package greedy;

import java.util.Scanner;

public class Greedy_01 {

	public static void main(String[] args) {
		
		int n = 0, b = 0, c = 0;
		int[] a;
		
		int tmp = 0;
		long result = 0;
		
		Scanner sc = new Scanner(System.in);
		
		// 시험장 개수
		n = sc.nextInt();
		if(n < 1 || n > 1000000) {
			System.out.println("시험장 개수 범위는 1 ≤ N ≤ 1,000,000 입니다.");
			sc.close();
			return;
		}
		a = new int[n];
		
		// 각 시험장에 있는 응시자 수
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			if(a[i] < 1 || a[i] > 1000000) {
				System.out.println("각 시험장에 있는 응시자의 수는 1 ≤ N ≤ 1,000,000 입니다.");
				sc.close();
				return;
			}
		}
		
		// 총감독관 응시자 감시
		b = sc.nextInt();
		if(b < 1 || b > 1000000) {
			System.out.println("총감독관은 한 시험장에서 감시할 수 있는 응시자의 수는 1 ≤ N ≤ 1,000,000 입니다.");
			sc.close();
			return;
		}
		
		// 부감독관 응시자 감시
		c = sc.nextInt();
		if(c < 1 || c > 1000000) {
			System.out.println("부감독관은 한 시험장에서 감시할 수 있는 응시자의 수는 1 ≤ N ≤ 1,000,000 입니다.");
			sc.close();
			return;
		}
		
		sc.close();
		// 입력 끝
		
		for(int i = 0; i < n; i++) {
			tmp = a[i] - b;
			result++;
			if(tmp > 0) {
				result += (int) Math.ceil((double)tmp/c);
			}
			
		}
		
		System.out.println(result);

	}

}
