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

		if (N == K) {							// 수빈과 동생 위치가 같을 경우 종료
			System.out.println("0\n1");
			return;
		}
		
		bfs();
		System.out.println(result + "\n" + resultCnt);
	}

	static void bfs() {
		que = new LinkedList<Integer>();
		que.offer(N);											// 수빈 start 위치 insert

		while (!que.isEmpty()) {
			int position = que.poll();

			if (position == K) {								// 수빈과 동생 위치가 같아질 경우 시간 저장 및 횟수++
				result = time[position];
				resultCnt++;
			}
			
			// 이동방법 => 1. -방향으로 이동 / 2. +방향으로 이동 / 3. 순간이동
			// 각각의 이동방법이 범위내에 있고 / 처음 방문이거나 이미 방문 했지만 연산 후 저장된 시간과 동일이면 큐 insert
			if (position - 1 >= 0 && (time[position - 1] == 0 || time[position - 1] == time[position] + 1)) {
				que.offer(position - 1);
				time[position - 1] = time[position] + 1;		// 이전 순서에 +1 해서 time 증가 (5->4=1 / 4->3=2)
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