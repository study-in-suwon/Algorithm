## 백준 럭키 스트레이트

### 풀이 
1. 점수를 받아 반으로 나눈다음 결과값을 비교함


### 구현 코드
```java
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str = sc.next();
        // 왼쪽과 오른쪽을 비교하기 위해 문자열 길이를 2로 나눔
        int length = str.length();
        int harf = length / 2;
        
        // 받은 값을 배열로 변환
        char[] charArr = str.toCharArray();
        
        //나눈 값을 더하기 위한 변수
        int left = 0;
        int right = 0;
        
        for(int i =0; i <length; i++){
        		// int 형으로 변경
            int num = Character.getNumericValue(charArr[i]);
            
  				//왼족과 오른쪽의 합 
            if(i < harf) {
                left += num;
            } else {
                right += num;
            }
        }
        
        //왼쪽과 오른쪽을 나눠 비교
        if(left == right) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
```
