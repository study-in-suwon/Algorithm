## 백준 멀티탭 스케줄러

### 풀이 
1. 해시맵을 통해 각 기기의 순서를 저장해 체크하는 방식으로 
2. 해시맵으로 각 기기의 순서를 List로 넣어 교체시 순서를 찾기 위해 사용
3. 멀티 탭이 차있는 상태에서 새로운 기기가 들어왔을때 사용 일정이 없거나 사용일정이 더 늦은 기기의 콘센트를 제거함
4. 교체가 이루어 질때만 카운트함


### 구현 코드 1
```java
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Main {
    
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 멀티탭 구멍
		int n = sc.nextInt();
		// 전기 용품 사용 횟수
		int k = sc.nextInt();

		// 기기 순서를 확인하기 위한 Map
		Map<Integer, List<Integer>> map = new HashMap<>();

		// 콘센트 순서
		Integer[] inputNums = new Integer[k + 1];

		// 0값 넣어줌
		inputNums[0] = 0;

		for (int i = 1; i <= k; i++) {

			int num = sc.nextInt();

			// 기기의 사용 순서
			inputNums[i] = num;

			// mpa의 기기가 있는 경우 기기에 대한 순서를 넣어줌
			if (map.containsKey(num)) {
				map.get(num).add(i);
			} else {
				// map 에 기기가 없는 경우 기기 셋팅
				List<Integer> mpaList = new LinkedList<>();
				mpaList.add(i);
				map.put(num, mpaList);
			}
		}
		// 멀티탭에 사용중인 기기 확인 set
		Set<Integer> multitapSet = new HashSet<>();

		// 콘센트를 제거한 수
		int count = 0;

		for (int i = 1; i <= k; i++) {
			
			// 사용할 기기
			Integer num = inputNums[i];

			// 멀티탭이 다 차있는 상태에서
			if (multitapSet.size() == n) {
				// 새로운 기기가 들어왔을때
				if (!multitapSet.contains(num)) {
					// 제거할 기기 찾기
					Iterator<Integer> iter = multitapSet.iterator();
					Integer max = Integer.MIN_VALUE;
					Integer removeIter = 0;
					while (iter.hasNext()) {
						Integer iterNum = iter.next();

						// 사용할 일정이 없는 기기 먼저 제거
						if (map.get(iterNum).size() == 0) {
							removeIter = iterNum;
							break;
							// 사용기간이 가장 마지막인 기기 제거
						} else if (max < map.get(iterNum).get(0)) {
							max = map.get(iterNum).get(0);
							removeIter = iterNum;
						}
					}

					// 교체 및 순서 제거
					multitapSet.remove(removeIter);
					multitapSet.add(num);
					max = map.get(num).remove(0);
					count++;
					
				} else {
					map.get(num).remove(0);
				}

			} else {
				multitapSet.add(num);
				map.get(num).remove(0);
				
			}
		}

		System.out.println(count);

	}
}
```
