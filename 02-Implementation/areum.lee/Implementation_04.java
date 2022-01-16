package implementation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Implementation_04 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		String[] str = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = sc.next();
		}

		sc.close();

		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// 단어 길이가 같을 경우
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2); // 사전 순 정렬
				} else {
					return o1.length() - o2.length();
				}
			}
		});

		System.out.println(str[0]);
		// 중복된 단어 제거 후 출력
		for (int i = 1; i < n; i++) {
			if (!str[i].equals(str[i - 1])) {
				System.out.println(str[i]);
			}
		}

	}

}
