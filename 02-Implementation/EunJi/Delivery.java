package implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Delivery {
	private static int result;								// 치킨거리의 합
	private static int N, M, c_Length, h_Length, selected[];
	private static boolean isSelected[];					// 방문했는지 확인
	private static List<Chicken> clist = new ArrayList<>(); // chicken 클래스 리스트
	private static List<House> hlist = new ArrayList<>();	// house 클래스 리스트

	static class Chicken {									// 치킨집 위치 저장
		int y, x;

		public Chicken(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static class House {									// 가정집 위치 저장
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
		c_Length = clist.size();							// 치킨집 수
		h_Length = hlist.size();							// 가정집 수
		result = 10000;
		isSelected = new boolean[c_Length];					// 치킨 집 선택했는지
		selected = new int[M];								// 현재 선택 된 치킨집이 어딘지

		find_distance(0, 0);								// result 값 탐색

		System.out.println(result);							// 결과 출력
	}

	private static void find_distance(int start, int cnt) {
		if (cnt == M) {
			System.out.println();
			int sum = 0;
			for (int i = 0; i < h_Length; i++) {			// 모든 가정집과 비교
				int min = 10000;
				for (int j = 0; j < M; j++) {				// 선택 된 치킨 집 모두 비교 / 선택된 치킨집과 일반집과의 거리를 구해서 최소값을 구한다.
					System.out.println(selected[cnt-j-1] + " / " + i);
					int distance = getDistance(clist.get(selected[cnt - j - 1]).x, clist.get(selected[cnt - j - 1]).y, hlist.get(i).x, hlist.get(i).y);
					min = min > distance ? distance : min;
				}
				sum += min;									// 최소값 누적.
			}
			result = sum > result ? result : sum;			// 가장 작은 최소값을 정한다.
			
			return;
		}

		for (int i = start; i < c_Length; i++) {
			if (isSelected[i])								// 현재 선택 된 치킨집은 넘김
				continue;

			selected[cnt] = i;								// 현재 치킨집을 선택한다.
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