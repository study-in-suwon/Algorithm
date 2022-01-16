package implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Delivery {
	private static int result;								// ġŲ�Ÿ��� ��
	private static int N, M, c_Length, h_Length, selected[];
	private static boolean isSelected[];					// �湮�ߴ��� Ȯ��
	private static List<Chicken> clist = new ArrayList<>(); // chicken Ŭ���� ����Ʈ
	private static List<House> hlist = new ArrayList<>();	// house Ŭ���� ����Ʈ

	static class Chicken {									// ġŲ�� ��ġ ����
		int y, x;

		public Chicken(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static class House {									// ������ ��ġ ����
		int y, x;

		public House(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int imsi = sc.nextInt();
				if (imsi == 1) hlist.add(new House(i, j));
				else if (imsi == 2) clist.add(new Chicken(i, j));
			}
		}
		c_Length = clist.size();							// ġŲ�� ��
		h_Length = hlist.size();							// ������ ��
		result = 10000;
		isSelected = new boolean[c_Length];					// ġŲ �� �����ߴ���
		selected = new int[M];								// ���� ���� �� ġŲ���� �����

		find_distance(0, 0);								// result �� Ž��

		System.out.println(result);							// ��� ���
	}

	private static void find_distance(int start, int cnt) {
		if (cnt == M) {
			System.out.println();
			int sum = 0;
			for (int i = 0; i < h_Length; i++) {			// ��� �������� ��
				int min = 10000;
				for (int j = 0; j < M; j++) {				// ���� �� ġŲ �� ��� �� / ���õ� ġŲ���� �Ϲ������� �Ÿ��� ���ؼ� �ּҰ��� ���Ѵ�.
					System.out.println(selected[cnt-j-1] + " / " + i);
					int distance = getDistance(clist.get(selected[cnt - j - 1]).x, clist.get(selected[cnt - j - 1]).y, hlist.get(i).x, hlist.get(i).y);
					min = min > distance ? distance : min;
				}
				sum += min;									// �ּҰ� ����.
			}
			result = sum > result ? result : sum;			// ���� ���� �ּҰ��� ���Ѵ�.
			
			return;
		}

		for (int i = start; i < c_Length; i++) {
			if (isSelected[i])								// ���� ���� �� ġŲ���� �ѱ�
				continue;

			selected[cnt] = i;								// ���� ġŲ���� �����Ѵ�.
			isSelected[i] = true;
			
			find_distance(i + 1, cnt + 1);
			isSelected[i] = false;
		}
	}

	private static int getDistance(int c_x, int c_y, int h_x, int h_y) {
		int dis = Math.abs(c_x - h_x) + Math.abs(c_y - h_y);
		
		return dis;
	}
}

//		cList
//		(1,2) (4,1) (5,1) (5,2) (5,5)
//		
//		hList
//		(1,4) (2,1) (2,3) (4,4) (4,5) (5,4)
//		
//		1 / 0
//		0 / 0
//		1 / 1
//		0 / 1
//		1 / 2
//		0 / 2
//		1 / 3
//		0 / 3
//		1 / 4
//		0 / 4
//		1 / 5
//		0 / 5
//		
//		2 / 0
//		0 / 0
//		2 / 1
//		0 / 1
//		2 / 2
//		0 / 2
//		2 / 3
//		0 / 3
//		2 / 4
//		0 / 4
//		2 / 5
//		0 / 5
//		
//		3 / 0
//		0 / 0
//		3 / 1
//		0 / 1
//		3 / 2
//		0 / 2
//		3 / 3
//		0 / 3
//		3 / 4
//		0 / 4
//		3 / 5
//		0 / 5
//		
//		4 / 0
//		0 / 0
//		4 / 1
//		0 / 1
//		4 / 2
//		0 / 2
//		4 / 3
//		0 / 3
//		4 / 4
//		0 / 4
//		4 / 5
//		0 / 5
//		
//		2 / 0
//		1 / 0
//		2 / 1
//		1 / 1
//		2 / 2
//		1 / 2
//		2 / 3
//		1 / 3
//		2 / 4
//		1 / 4
//		2 / 5
//		1 / 5
//		
//		3 / 0
//		1 / 0
//		3 / 1
//		1 / 1
//		3 / 2
//		1 / 2
//		3 / 3
//		1 / 3
//		3 / 4
//		1 / 4
//		3 / 5
//		1 / 5
//		
//		4 / 0
//		1 / 0
//		4 / 1
//		1 / 1
//		4 / 2
//		1 / 2
//		4 / 3
//		1 / 3
//		4 / 4
//		1 / 4
//		4 / 5
//		1 / 5
//		
//		3 / 0
//		2 / 0
//		3 / 1
//		2 / 1
//		3 / 2
//		2 / 2
//		3 / 3
//		2 / 3
//		3 / 4
//		2 / 4
//		3 / 5
//		2 / 5
//		
//		4 / 0
//		2 / 0
//		4 / 1
//		2 / 1
//		4 / 2
//		2 / 2
//		4 / 3
//		2 / 3
//		4 / 4
//		2 / 4
//		4 / 5
//		2 / 5
//		
//		4 / 0
//		3 / 0
//		4 / 1
//		3 / 1
//		4 / 2
//		3 / 2
//		4 / 3
//		3 / 3
//		4 / 4
//		3 / 4
//		4 / 5
//		3 / 5