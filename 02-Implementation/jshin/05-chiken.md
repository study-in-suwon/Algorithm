## 백준 치킨 배달

### 풀이 
- 백트래킹 조합 알고리즘을 사용해서 모든 조합을 구함
1. 위치를 저장할 객체를 만들어 List로 집과 치킨집을 모두 저장함
2. 모든 조합을 확인하기 위해 재귀함수로 확인할 치킨집 카운트와 인덱스를 하나씩 더하면서 호출함
3. 카운트 갯수가 남아야하는 치킨 갯수와 같을경우 해당 치킨 거리를 저장하고 리턴함
4. 리턴이 되면 카운트 갯수는 다시 하나 줄어고 뒤에 남은 모든 치킨집 갯수만큼 반복함
5. 모든 조합을 확인해서 가장 적은 값을 찾음


### 구현 코드
```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static class Location{
		int r;
		int c;
		
		Location (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int length, chikenLength;
	
	//집 위치
	static List<Location> home = new ArrayList<>();
	
	//치킨 위치
	static List<Location> chiken = new ArrayList<>();
	
	//치킨집 방문 확인
	static boolean[][] chikenCheck;
	
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//거리 크기
		length = sc.nextInt();
		
		//남겨야 하는 치킨집 수
		chikenLength = sc.nextInt();
		
		chikenCheck = new boolean[length+1][length+1];
		
		for(int i = 1; i <= length; i++) {
			for(int j = 1; j <= length; j++) {
				int num = sc.nextInt();
				//집 위치 저장
				if(num == 1) {
					home.add(new Location(i, j));
				}
				// 치킨 집 위치 저장
				if(num == 2) {
					chiken.add(new Location(i, j));
				}
			}
		}
		
		//치킨집 0번째 위치부터 가장 적은 수의 조합을 찾음 
		dfs(0,0);
		
		System.out.println(result);
	}

	private static void dfs(int count, int index) {
		
		//남겨야 하는 치킨집 만큼 조합이 정해지면 확인
		if(count == chikenLength) {
			
			//조합에 대한 치킨 거리 값
			int total = 0;
			
			for(int i = 0; i < home.size(); i++) {
				
				//가장 짧은 치킨거리를 구함
				int chikenMin = Integer.MAX_VALUE;
				for(int j = 0; j < chiken.size(); j++) {
					//조합에 있는 치킨집만 확인
					if(chikenCheck[chiken.get(j).r][chiken.get(j).c]) {
						int min = Math.abs(home.get(i).r - chiken.get(j).r) + Math.abs(home.get(i).c - chiken.get(j).c);
						chikenMin = Math.min(chikenMin, min);						
					}
				}
				total += chikenMin;
			}
			
			//항상 최적의 거리수를 저장함
			result = Math.min(result, total);
		
			return;
		}
		
		for(int i = index; i < chiken.size(); i++) {
				//조합에 사용할 치킨 집 
				chikenCheck[chiken.get(i).r][chiken.get(i).c] = true;
				//모든조합을 찾기위해 재기함수 호출
				dfs(count+1,i+1);
				//확인이 완료되면 조합에서 제거
				chikenCheck[chiken.get(i).r][chiken.get(i).c] = false;
		
		}		
		
	}

}

```
