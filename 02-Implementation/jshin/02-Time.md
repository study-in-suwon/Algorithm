## 백준 시각

### 풀이 
1. 시, 분, 초를 하나씩 비교해서 카운트함


### 구현 코드
```java
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        
        // 시분초 변수
        int h = 0;
        int m = 0;
        int s = 0;
        
        // 비교를 위해 검사해야 되는 값을 String으로 변경
        String kStr = k + "";
        //
        int count = 0;
        
        // 비교 값이 0인 경우 하나 카운트
        if(k ==0){
            count++;
        }
        
        //초가 60이 될때 분을 1 더하주고 분이 1될때마다 시를 1씩 더함
        while(true) {
            s = s < 59 ? s+1 : 0;
            if(s == 0) {
                m = m < 59 ? m+1 : 0;
                if(m == 0) {
                    h++;
                    // 입력받은 시간을 넘어가는 경우 종료
                    if(h>n){
                        break;
                    }
                }
            }
            //시분초 String으로 변환후 값 확인
            String numStr = (h < 10 ? "0" + h : ""+h) + (m < 10 ? "0" + m : ""+m) + (s < 10 ? "0" + s : ""+s);
            if(numStr.indexOf(kStr) != -1) {
                count++;
            }
        }
        System.out.println(count);
    }
}
```
