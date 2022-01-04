## 백준 시험감독

### 풀이 
1. 시험장 갯수만큼 총감독관을 카운트 하고 각 시험장마다 총감독관이 확인 할 수 있는 사람을 제외함
2. 남은 응시자와 부감독이 확인 할 수 있는 사람을 나눠 필요한 부감독의 수를 계산하고 나머지 계산을 통해 사람이 남은 경우 부감독을 하나더 카운트 진행함

>문제는 풀이 자체는 쉬웠는데 처음엔 총 감독관이 확인할 수 있는 사람을 제외했을때 -를 고려 안해서 틀렸고 그다음엔 맞는것 같은데 답이 자꾸 틀렸다. 확인해보니 결과값이 int 범위를 초과해서 long으로 선언해야 답이 풀린다. 주어진 수의 범위가 커서 int 자료형의 범위가 넘을 수 있는데 아무 생각없이 int로 썻다.

### 구현 코드
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] roomArr = new int[n];
        
        for(int i = 0; i < n; i++) {
            roomArr[i] = sc.nextInt();
        }
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        long result = n;
        
        for(int i = 0; i < n; i++) {
            int a = roomArr[i];
            a -= b;
            
            if(a > 0) {
                result += a / c;
                if(a % c > 0) {
                    result++;
                }
            }         
        }
        System.out.println(result);
    }
}
```
