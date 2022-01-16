package implementation;

import java.util.Scanner;

public class Compress {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String insert = sc.nextLine();										// 입력 된 문자열
		
		int cpMin = insert.length();										// 최소값
        
        for(int group = 1; group <= (insert.length() / 2); group++) {		// 자를 수 있는(입력 된 전체 문자열 길이의 절반) 최대값 만큼 for문 실행
            int totalLength = 0;
            int start = 0;
            
            while (start < (insert.length() - group)) {						// (입력 된 문자열 - 그룹핑 된 문자) 만큼 반복문 ex) abc abc dede -> de 이후로 볼 필요 없음
                String groupStr = insert.substring(start, start + group);
                int matched = 0;
                int index = start + group;
                
                while(index < insert.length()) {
                    if(insert.startsWith(groupStr, index)) {				// 입력 된 문자열의 index 번째에 그룹핑 된 문자로 시작하는지 체크
                        matched++;
                        index += group;										// 그룹핑 된 문자 만큼 자리 이동
                    } else break;
                }
                
                if(matched > 0) {
                	start = index;											// 다음 위치에서 다른 패턴 찾기위해 start 위치 이동
                    totalLength += groupStr.length() * matched - ((int) (Math.log10(1 + matched) + 1));		// 압축 된 길이 구함 ex) abc abcabc dede -> abcabc 6개가 줄어들고 맨 앞에 6이 입력되므로 1의자리 1을 더해줌 
                } else {
                	start += group;											// 그룹핑 된 문자 만큼 start 위치 이동
                }
            }
            int thisLen = insert.length() - totalLength;
            if(thisLen < cpMin) cpMin = thisLen;							// 가장 작은 값으로 최소값 update
        }
        System.out.println(cpMin);
	}
}


//		abcabcdede
//		de / 2 / 1
//		abc / 3 / 1
//		8