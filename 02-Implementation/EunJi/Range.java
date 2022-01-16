package implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Range {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] word = new String[sc.nextInt()];

		for (int i = 0; i < word.length; i++) word[i] = sc.next();

		Arrays.sort(word, new Comparator<String>() {
			public int compare(String i, String j) {
				if (i.length() == j.length()) return i.compareTo(j);
				else return Integer.compare(i.length(), j.length());
			}
		});
		System.out.println(word[0]);
		for (int i = 1; i < word.length; i++) if (!word[i].equals(word[i - 1])) System.out.println(word[i]);
		
		
//		Scanner sc = new Scanner(System.in);
//		String[] word = new String[sc.nextInt() + 1];
//		ArrayList<String> sort = new ArrayList<String>();
//		ArrayList<String> compare = new ArrayList<String>();
//		String imsi = "";
//		
//		for (int i = 0; i < word.length - 1; i++) word[i] = sc.next();
//		word[word.length - 1] = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//		
//		for (int i = 0; i < word.length - 1; i++) {
//			for (int j = (i+1); j < word.length; j++) {
//				if(word[i].length() > word[j].length()) {
//					imsi = word[i];
//					word[i] = word[j];
//					word[j] = imsi;
//				}
//			}
//		}
//		
//		for (int i = 0; i < word.length - 1; i++) {
//			if(word[i].length() == word[(i+1)].length()) {
//				if(compare.contains(word[i]))
//					continue;
//				else compare.add(word[i]);
//			} else {
//				compare.add(word[i]);
//				compare.sort(null);
//				sort.addAll(compare);
//				compare.clear();
//			}
//		}
//		
//		for (int i = 0; i < sort.size(); i++) System.out.println(sort.get(i));
	}
}