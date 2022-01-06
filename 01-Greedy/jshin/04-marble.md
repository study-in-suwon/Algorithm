## 백준 모두의 마블

### 풀이 
1. 카드의 최대값을 찾아 나머지 값들을 각각 더해 최대 가질 수 있는 골드를 찾음


### 구현 코드
```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> numArr = new ArrayList<>();
        
        int n = sc.nextInt();
        
        int num = 0;
        
        for(int i = 0; i < n; i++) {
            int l = sc.nextInt();
            num = Math.max(num,l);
            numArr.add(l);
        }
        
        int maxNum = num;
        
        Integer sum = numArr.stream().map(v -> v + maxNum).reduce((a,b) -> a + b).get();
        System.out.println(sum - (maxNum*2));
    }
    
}
```
