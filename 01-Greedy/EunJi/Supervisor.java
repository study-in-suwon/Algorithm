package greedy;

import java.util.Scanner;

public class Supervisor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] classRm = new int[sc.nextInt()];

		for (int i = 0; i < classRm.length; i++) classRm[i] = sc.nextInt();

		int sv = sc.nextInt();
		int v = sc.nextInt();
		int count = 0;
		int remainSt = 0;

		for (int i = 0; i < classRm.length; i++) {
			remainSt = classRm[i] - sv;
			count++;									// 필수 총감독관 count
			
			if (0 < remainSt) {
				count += remainSt / v;
				if (0 != (remainSt % v)) count++;
			}
		}
		System.out.println(count);
	}
}
