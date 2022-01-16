package implementation;

import java.util.Scanner;

public class TimeCheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int limit = sc.nextInt();
		int find = sc.nextInt();
		int count = 0;
		
		for (int i = 0; i <= limit; i++)
			for (int j = 0; j < 60; j++)
				for (int j2 = 0; j2 < 60; j2++)
					if(i / 10 == find || i % 10 == find || j / 10 == find || j % 10 == find || j2 / 10 == find || j2 % 10 == find) count++;
		
		System.out.println(count);
	}
}