package bfs_dfs;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Movement {
	static int[][] world, unite;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };	// �����¿�
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
					if (unite[i][j] == 0) {						// ���� ���� �ȵ� ������ ��� ���ջ���
						unite[i][j] = uniteNum;
						dfs(i, j);								// �ֺ� ����� ���ոα�
						uniteNum++;
					}
				}
			}

			if (uniteNum - 1 != N * N) {						// ��� ���� ������ ���� �� ���漱 ����
				isMove = true;
				move();											// �α��̵�
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
				differ = Math.abs(world[x][y] - world[sx][sy]);		// �����¿� �� ���� �� �α� �� Ȯ��
			} catch (Exception e) {
				continue;											// ���� ��� ��� continue
			}

			if (unite[x][y] == 0 && differ >= L && differ <= R) {
				unite[x][y] = uniteNum;								// ���� �� �α� ���� L R ���̰��� ��� ���� ���ոα�
				dfs(x, y);
			}
		}
	}
	
	public static void move() {
		int[] people = new int[uniteNum];
		int[] country = new int[uniteNum];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				int p = world[i][j];								// �ش� ���� �α� �� ��������
				int g = unite[i][j];								// �ش� ���� uniteNum ��������

				people[g] += p;										// ���� ���ձ� ��� ���ϱ�
				country[g]++;										// ���ձ� �� ++
			}
		int[] val = new int[uniteNum];

		for (int g = 1; g < uniteNum; g++)
			val[g] = people[g] / country[g];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				world[i][j] = val[unite[i][j]];						// �� uniteNum�� �α��� ���(val) �� world�� �־��ֱ�
	}
}