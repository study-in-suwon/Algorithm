package greedy;

import java.util.Scanner;

public class Greedy_02 {

	public static void main(String[] args) {
		
		int n = 0, m = 0, k = 0;
		int team = 0;
		int tmp = 0;
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();	// ���л�
		if(n < 0 || n > 100) {
			System.out.println("����");
			sc.close();
			return;
		}
		
		
		m = sc.nextInt();	// ���л�
		if(m < 0 || m > 100) {
			System.out.println("����");
			sc.close();
			return;
		}
		
		k = sc.nextInt();	// ����
		if(k < 0 || k > (m+n)) {
			System.out.println("����");
			sc.close();
			return;
		}

		sc.close();
		// �Է� ��
		
		// ���� ����
		if(n/2 > m) {
			team = m;
			tmp = n - (m*2);
		} else {
			team = n/2;
			tmp = n%2 + m - team;
		}
		
		
		k -= tmp; // ���� �Ἲ���� ���� �ο����� ���Ͻ� ����
		
		if(k > 0) {
			team -= k/3; // team = team - k/3
			if(k%3 > 0) {
				team--; // team = team - 1
			}
		}
		
		System.out.println(team);
		
	}

}
