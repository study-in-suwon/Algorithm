package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideSeek {
	static Queue<Integer> que;
	static int[] time = new int[100001];
	static int N, K, resultCnt, result = Integer.MAX_VALUE;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		if (N == K) {							// ����� ���� ��ġ�� ���� ��� ����
			System.out.println("0\n1");
			return;
		}
		
		bfs();
		System.out.println(result + "\n" + resultCnt);
	}

	static void bfs() {
		que = new LinkedList<Integer>();
		que.offer(N);											// ���� start ��ġ insert

		while (!que.isEmpty()) {
			int position = que.poll();

			if (position == K) {								// ����� ���� ��ġ�� ������ ��� �ð� ���� �� Ƚ��++
				result = time[position];
				resultCnt++;
			}
			
			// �̵���� => 1. -�������� �̵� / 2. +�������� �̵� / 3. �����̵�
			// ������ �̵������ �������� �ְ� / ó�� �湮�̰ų� �̹� �湮 ������ ���� �� ����� �ð��� �����̸� ť insert
			if (position - 1 >= 0 && (time[position - 1] == 0 || time[position - 1] == time[position] + 1)) {
				que.offer(position - 1);
				time[position - 1] = time[position] + 1;		// ���� ������ +1 �ؼ� time ���� (5->4=1 / 4->3=2)
			}
			if (position + 1 <= 100000 && (time[position + 1] == 0 || time[position + 1] == time[position] + 1)) {
				que.offer(position + 1);
				time[position + 1] = time[position] + 1;
			}
			if (position * 2 <= 100000 && (time[position * 2] == 0 || time[position * 2] == time[position] + 1)) {
				que.offer(position * 2);
				time[position * 2] = time[position] + 1;
			}
		}

	}
}