package greedy;

import java.util.Scanner;

public class Greedy_01 {

	public static void main(String[] args) {
		
		int n = 0, b = 0, c = 0;
		int[] a;
		
		int tmp = 0;
		long result = 0;
		
		Scanner sc = new Scanner(System.in);
		
		// ������ ����
		n = sc.nextInt();
		if(n < 1 || n > 1000000) {
			System.out.println("������ ���� ������ 1 �� N �� 1,000,000 �Դϴ�.");
			sc.close();
			return;
		}
		a = new int[n];
		
		// �� �����忡 �ִ� ������ ��
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			if(a[i] < 1 || a[i] > 1000000) {
				System.out.println("�� �����忡 �ִ� �������� ���� 1 �� N �� 1,000,000 �Դϴ�.");
				sc.close();
				return;
			}
		}
		
		// �Ѱ����� ������ ����
		b = sc.nextInt();
		if(b < 1 || b > 1000000) {
			System.out.println("�Ѱ������� �� �����忡�� ������ �� �ִ� �������� ���� 1 �� N �� 1,000,000 �Դϴ�.");
			sc.close();
			return;
		}
		
		// �ΰ����� ������ ����
		c = sc.nextInt();
		if(c < 1 || c > 1000000) {
			System.out.println("�ΰ������� �� �����忡�� ������ �� �ִ� �������� ���� 1 �� N �� 1,000,000 �Դϴ�.");
			sc.close();
			return;
		}
		
		sc.close();
		// �Է� ��
		
		for(int i = 0; i < n; i++) {
			tmp = a[i] - b;
			result++;
			if(tmp > 0) {
				result += (int) Math.ceil((double)tmp/c);
			}
			
		}
		
		System.out.println(result);

	}

}
