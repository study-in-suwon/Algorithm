package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze {
	static int[][] maze, visited;								// 미로, 방문여부
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };	// 상하좌우
	static int N, M, result;
	
	static class Position {										// 위치저장 클래스
		int x, y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		maze = new int[N][M];
		visited = new int[N][M];

		String imsi[] = new String[M];
		for (int i = 0; i < N; i++) {
			imsi = sc.next().split("");
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(imsi[j]);			// 미로세팅
			}
		}
		result = bfs(0, 0);										// bfs 호출

		System.out.println(result);								// 결과출력
	}

	static int bfs(int x, int y) {
		Queue<Position> q = new LinkedList<>();
		visited[x][y] = 1;

		q.offer(new Position(x, y));							// 방문한 위치 저장

		Position position;
		while (!q.isEmpty()) {
			position = q.poll();
			x = position.x;
			y = position.y;

			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
					continue;
				if (visited[nextX][nextY] != 0 || maze[nextX][nextY] == 0)
					continue;

				q.offer(new Position(nextX, nextY));
				visited[nextX][nextY] = visited[x][y] + 1;
			}
		}
		return visited[N-1][M-1];
	}
}