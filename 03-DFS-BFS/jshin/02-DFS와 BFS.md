## 백준 DFS와 BFS

### 풀이 
- List를 통해 node들을 연결해 bfs, dfs를 수행함


### 구현 코드
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {


	// 방문 확인 용
	static boolean[] bfsCheck;
	static boolean[] dfsCheck;
 
	// 결과 입력
	static List<Integer> bfsResult = new ArrayList<>();
	static List<Integer> dfsResult = new ArrayList<>();
 
	
	static int n,m,start;

	//관겨 연결 리스트
	static List<List<Integer>> nodeList = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
		
		bfsCheck = new boolean[n+1];
		dfsCheck = new boolean[n+1];
		

		//정점에 갯수만큼 List를 생성
		for(int i = 0; i <= n; i++) {
			nodeList.add(new ArrayList<>());
		}
		
		// 각정점에 연결된 Node들을 입력
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			// 양방향 관계로 모두 입력
			nodeList.get(a).add(b);
			nodeList.get(b).add(a);
		}
		
        
        //시작 지점 셋팅
		dfsResult.add(start);
		dfsCheck[start] = true;
		dfs(start);
		
		System.out.print(dfsResult.get(0));
		for(int i = 1; i < dfsResult.size(); i++) {
			System.out.print(" " + dfsResult.get(i));
		}
	System.out.println();
		
		bfs();
		System.out.print(bfsResult.get(0));
		for(int i = 1; i < bfsResult.size(); i++) {
			System.out.print(" " + bfsResult.get(i));
		}
		
		

		

	}

	private static void bfs() {
		//시작 지점 셋팅
		bfsCheck[start] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			Integer nowNodes = q.poll();
			
			bfsResult.add(nowNodes);
			
			List<Integer> nextNodes = nodeList.get(nowNodes);
			
			Collections.sort(nextNodes);
			
			for(Integer nextNode : nextNodes) {
				if(!bfsCheck[nextNode]) {
					bfsCheck[nextNode] = true;
					q.offer(nextNode);
				}
			}
			
		}
	}

	private static void dfs(int now) {
		
		List<Integer> nodes = nodeList.get(now);
		Collections.sort(nodes);
		
		// 번호가 낮은 순으로 재귀로 탐색함
		for(int i = 0; i < nodes.size(); i++) {
			Integer nextNode = nodes.get(i);
			if(!dfsCheck[nextNode]) {
				dfsCheck[nextNode] = true;
				dfsResult.add(nextNode);
				dfs(nextNode);
			}
		}

	}
}
```
