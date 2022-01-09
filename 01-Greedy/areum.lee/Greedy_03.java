package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Greedy_03 {
	
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] i = new int[n][2];
		
		for(int k = 0; k < n; k++) {
			i[k][0] = sc.nextInt(); // 시작시간
			i[k][1] = sc.nextInt(); // 종료시간
		}
		
		sc.close();
		// 입력 끝

		// 연산 시작
		// 죵료 시간 기준 정렬
		Arrays.sort(i, new Comparator<int[]>() {
			
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];
			}
		});
		
		int result = 0;
		int prev_end_time = 0;
		
		for(int k = 0; k < n; k++) {
			if(prev_end_time <= i[k][0]) {
				prev_end_time = i[k][1];
				result++;
			}
		}
		
		System.out.println(result);
	
	}

}
