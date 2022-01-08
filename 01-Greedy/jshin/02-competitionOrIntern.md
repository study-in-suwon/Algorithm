## 백준 대회 or 인턴

### 풀이 
1. 남학생, 여학생이 가질 수 있는 팀을 구해 더 많은 경우 빼주는 식으로 구현
2. 남학생 팀과 여학생 팀을 비교하기 위해 여학생을 2로 나눠 각각 총 참가할 수 있는 팀을 구함
3. 인턴쉽에 참가해야 하는 학생 수가 0이 될때까지 여학생 팀과 남학생 팀을 비교해 여학생 팀의 수가 같거나 많을땐 인턴쉽에 여학생 2명을 참가 시키고 남학생 수가 많을 경우 인턴쉽에 남학생을 1명 참가시킴
4. 인턴쉽에 참가 인원이 다 채워졌을때 여학생 팀과 남학생 팀중 수가 적은 팀이 최종 참가팀이 됨


### 구현
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int team = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        
        int changeN = 0;
        
        if(n > 1 && m > 0 && k < n+m) {
            changeN = n / 2;
            
            k -= n % 2;
            
            while(k > 0) {
                if(changeN >= m) {
                    changeN--;
                    k -= 2;
                } else {
                    m--;
                    k--;
                }
            }
            if(changeN > 0 && m > 0) {
                team = Math.min(changeN,m);
            }
            System.out.println(team);
        }
    }
}
```
