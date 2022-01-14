## 백준 단어 정렬

### 풀이 
- 값을 조건에 따라 정렬함
1. 중복값 제거를 위해 HashSet으로 데이터를 받음
2. 스트림을 통해 문자열 길이를 오름차순으로 정렬, 길이가 같으면 문자 순서로 정렬함


### 구현 코드
```java
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < num; i++) {
            set.add(sc.next());
            sc.nextLine();
        }
        
        set.stream().sorted((i,j) -> {
            int iLength = i.length();
            int jLength = j.length();
            
            if(iLength == jLength) {
                return i.compareTo(j);
            }
            return Integer.compare(iLength, jLength);
        }).forEach(System.out::println);
    }
}
```
