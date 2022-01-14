## 프로그래머스 문자열 압축

### 풀이 
- 1부터 문자열 갯수만큼 반복문을 돌려 문자열을 압축했을때 가장 적은 값을 구하는 방식으로 구현함
1. 문자열 갯수를 구해 1~문자열 길이만큼 압축을 시도하기 위해 for문 사용
2. 2중 for문을 사용해서 실제 압축을 하면서 문자열 길이를 카운트함
3. 남은 문자열이 압축길이보다 적을경우 반복 문 종료, 남은 값을 더해줌
4. 가장 길이가 짧은 데이터를 갱신


### 구현 코드
```java
class Solution {
    public int solution(String s) {

        int answer = 0;

        //문자열 길이
        int length = s.length();

        //압축했을때의 최소 문자열 길이
        int minLength = length;

        //문자열 길이 만큼 확인
        for(int i = 1; i < length; i++) {

            //이전 문자열
            String preStr = "";

            //이전 인덱스 위치
            int preNum = 0;

            //압축했을때 나오는 문자열의 길이
            int totalCount = 0;

            //동일한 문자열 카운트
            int sameCount = 1;


            for(int j = i; j <= length; j+=i) {


                //문자열 압축 시도
                String nowStr = s.substring(preNum,j);

                preNum = j;

                //압축된 문자열이 이전에 압축된 문자열과 동일하면  카운트함
                if(nowStr.equals(preStr)) {
                    sameCount++;
                } else {

                    //중복된 값이 없이 처음 들어왔을때

                    //이전에 압축된 문자열이 있는 경우 압축된 만큼 카운트하고 초기화함
                    if(sameCount > 1) {
                        totalCount += (sameCount + "").length();
                        sameCount = 1;
                    }
                    //이전 문자열을 현재 문자열로갱신후 카운트
                    preStr = nowStr;
                    totalCount+=i;
                }

                //남은 문자열이 압축해야 하는 문자열 길이보다 적을 경우 종료
                if(j+i > length) {
                    //남은 압축된 문자열 카운트
                    if(sameCount > 1)  totalCount += (sameCount + "").length();
                    break;
                }
            }

            //남은 문자열 길이를 더해줌
            totalCount += length - preNum;

            //가장 짧은 문자열로 갱신
            minLength = Math.min(minLength, totalCount);
        }

        answer = minLength;
        return answer;
    }
}
```
