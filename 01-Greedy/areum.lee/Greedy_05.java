package greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class Greedy_05 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Integer[] arr = new Integer[k];
		for(int i = 0; i < k; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		// 입력 끝

		// 연산 시작		
		boolean[] use = new boolean[101];
		int put = 0;
		int ans = 0;
		for(int i = 0; i < k; i++) {
			int tmp = arr[i];
			
			if(!use[tmp]) {
				if(put < n) {
					use[tmp] = true;
					put++;
				} else {
					ArrayList<Integer> arrList = new ArrayList<>();
					for(int j = i; j < k; j++) {
						if(use[arr[j]] && !arrList.contains(arr[j])) {
							arrList.add(arr[j]);
						}
					}
					
					if(arrList.size() != n) {
						for(int j = 0; j < arr.length; j++) {
							if(use[j] && !arrList.contains(j)) {
								use[j] = false;
								break;
							}
						}
					} else {
						int remove = arrList.get(arrList.size() - 1);
						use[remove] = false;
					}
					
					use[tmp] = true;
					ans++;
				}
			}
		}
		
		System.out.println(ans);

	}

}
