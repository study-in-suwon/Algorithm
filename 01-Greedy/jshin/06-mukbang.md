## 프로그래머스 무지의 먹방 라이브

### 풀이 
1. 음식양으로 정렬하여 음식이 적은 것부터 제외하고 다시 인덱스 별로 정렬해 순서를 찾음
2. food객체를 링크드리스트로 저장해 음식양이 적은 것부터 제거할 수 있게함
3. 총 음식량이 방송 중단 시간보다 적거나 같을때 -1로 리턴함
4. 방송중단 시간이 0번째 인덱스의 음식양 * 리스트 사이즈 보다 크거나 같은 경우 음식양이 같은 객체를 삭제, 그 수만큼 방송중단 시간을 빼줌
5. 방송중단 시간이 더 적어진 경우 리스트를 인덱스 별로 오름차순으로 정렬해 남은 방송시간과 리스트 사이즈의 나머지를 구해 다음 순서를 찾음


### 구현 코드 
```java
import java.util.Iterator;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

	class Solution {
		static class Food implements Comparable<Food>{
			int index;
			long foodNum;
			
			Food(int index, long foodNum) {
				this.index = index;
				this.foodNum = foodNum;
			}
			
			@Override
			public int compareTo(Food others) {
				return Long.compare(this.foodNum,  others.foodNum);
			}
		}
		
		public int solution(int[] food_times, long k) {

			int answer = 0;
			List<Food> foodArr = new LinkedList<>();
			long totalFood = 0;
			for(int i =0; i < food_times.length; i++) {
				totalFood += food_times[i];
				foodArr.add(new Food(i+1, food_times[i]));
			}
				
			//총 음식양이 에러 시간보다 적을 경우
			if(totalFood <= k) {
				return -1;
			}

			//음식 수만큼 오름 차순 정렬
			Collections.sort(foodArr);
			
			long preFoodNum = 0;
			while(true) {
				
			
				//가장 양이 적은 음식 
				Food minFood = foodArr.get(0);
				
				//음식 양
				long foodNum = minFood.foodNum - preFoodNum;
				long lowTotalFood = foodArr.size() * foodNum;
				
				if(lowTotalFood <= k) {
					//시간 제거
					k -= lowTotalFood;
					long preCheck = preFoodNum;
					for(Iterator<Food> iter = foodArr.iterator(); iter.hasNext();) {
						Food food = iter.next();

						if(food.foodNum -preFoodNum > foodNum) {
							preFoodNum = preCheck;
							break;
						}
						preCheck = food.foodNum;
						iter.remove();
					}
					
					continue;
				} else {
					// 정렬 후 index구함
					Collections.sort(foodArr, (a,b) -> Long.compare(a.index, b.index));
					int index = foodArr.get(0).index;
					if(k >= foodArr.size()) index = foodArr.get( (int) (k % foodArr.size())).index;
					else if(k < foodArr.size() && k > 0) index = foodArr.get((int)k).index;
					answer = index;
					break;
				}
				
			}
			
			return answer;
		}
	}
```
