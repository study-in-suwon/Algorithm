package implementation;

import java.util.Scanner;

public class Lucky {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String score = sc.nextLine();				// 점수 입력 받을 변수 선언
		int result = 0;								// 비교 변수 선언
		
		String[] imsi = score.split("");			// 입력한 점수 쪼개기
		
		for (int i = 0; i < imsi.length; i++) {		// 자리위치 별 점수 합하기
			if(i < (imsi.length / 2)) result += Integer.parseInt(imsi[i]);
			else result -= Integer.parseInt(imsi[i]);
		}
		System.out.println(result == 0 ? "LUCKY" : "READY");
	}
}