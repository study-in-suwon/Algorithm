package sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class Antenna_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> location = new ArrayList<Integer>();
		int house = sc.nextInt();
		
		for (int i = 0; i < house; i++) location.add(sc.nextInt());
		location.sort(null);
		
		System.out.println(location.get((house-1)/2));
	}
}