package implementation;

import java.util.Scanner;

public class Implementation_01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 점수
		String n = sc.next();
		
		sc.close();
		
		// 자릿수 기준
		int a = n.length()/2;
		
		// 왼쪽, 오른쪽 값 저장
		String n1 = n.substring(0, a);
		String n2 = n.substring(a);
						
		int score1 = 0;
		int score2 = 0;
		
		// 각 자릿수의 합
		for(int i = 0; i < a; i++) {
			score1 += Integer.valueOf(n1.charAt(i));
			score2 += Integer.valueOf(n2.charAt(i));
		}
		
		// 럭키 스트레이트를 사용할 수 있는 상태 확인
		if(score1 == score2) {
			System.out.println("LUCKY");
		} else {
			System.out.println("READY");
		}
			
	}

}
