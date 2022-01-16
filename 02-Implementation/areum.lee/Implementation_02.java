package implementation;

import java.util.Scanner;

public class Implementation_02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String k = sc.next();

		sc.close();

		String hh = String.format("%02d", n);
		String mm = "00";
		String ss = "00";

		int result = 0;

		for (int h = 0; h <= n; h++) {
			hh = String.format("%02d", h);
			for (int m = 0; m < 60; m++) {
				mm = String.format("%02d", m);
				for (int s = 0; s < 60; s++) {
					ss = String.format("%02d", s);

					if (hh.contains(k) || mm.contains(k) || ss.contains(k)) {
						result++;
					}

				}
			}

		}

		System.out.println(result);
	}

}
