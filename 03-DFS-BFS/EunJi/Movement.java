package bfs_dfs;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Movement {
	static int[][] world, unite;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };	// 상하좌우
	static int N, L, R, uniteNum;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		world = new int[N][N];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				world[i][j] = sc.nextInt();

		boolean isMove = true;

		while (isMove) {
			isMove = false;
			unite = new int[N][N];
			uniteNum = 1;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (unite[i][j] == 0) {						// 연합 생성 안된 나라일 경우 연합생성
						unite[i][j] = uniteNum;
						dfs(i, j);								// 주변 나라와 연합맺기
						uniteNum++;
					}
				}
			}

			if (uniteNum - 1 != N * N) {						// 모든 나라가 폐쇄되지 않을 때 국경선 오픈
				isMove = true;
				move();											// 인구이동
				result++;
			}
		}
		System.out.println(result);
	}

	public static void dfs(int sx, int sy) {
		int x = 0;
		int y = 0;

		for (int m = 0; m < 4; m++) {
			x = sx + dx[m];
			y = sy + dy[m];
			int differ = 0;

			try {
				differ = Math.abs(world[x][y] - world[sx][sy]);		// 상하좌우 각 나라 별 인구 차 확인
			} catch (Exception e) {
				continue;											// 범위 벗어날 경우 continue
			}

			if (unite[x][y] == 0 && differ >= L && differ <= R) {
				unite[x][y] = uniteNum;								// 나라 별 인구 차가 L R 사이값일 경우 같은 연합맺기
				dfs(x, y);
			}
		}
	}
	
	public static void move() {
		int[] people = new int[uniteNum];
		int[] country = new int[uniteNum];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				int p = world[i][j];								// 해당 나라 인구 수 가져오기
				int g = unite[i][j];								// 해당 나라 uniteNum 가져오기

				people[g] += p;										// 같은 연합국 사람 합하기
				country[g]++;										// 연합국 수 ++
			}
		int[] val = new int[uniteNum];

		for (int g = 1; g < uniteNum; g++)
			val[g] = people[g] / country[g];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				world[i][j] = val[unite[i][j]];						// 각 uniteNum의 인구수 결과(val) 값 world에 넣어주기
	}
}