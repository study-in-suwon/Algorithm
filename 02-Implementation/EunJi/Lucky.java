package implementation;

import java.util.Scanner;

public class Lucky {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String score = sc.nextLine();				// ���� �Է� ���� ���� ����
		int result = 0;								// �� ���� ����
		
		String[] imsi = score.split("");			// �Է��� ���� �ɰ���
		
		for (int i = 0; i < imsi.length; i++) {		// �ڸ���ġ �� ���� ���ϱ�
			if(i < (imsi.length / 2)) result += Integer.parseInt(imsi[i]);
			else result -= Integer.parseInt(imsi[i]);
		}
		System.out.println(result == 0 ? "LUCKY" : "READY");
	}
}