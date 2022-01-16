package implementation;

import java.util.Scanner;

public class Compress {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String insert = sc.nextLine();										// �Է� �� ���ڿ�
		
		int cpMin = insert.length();										// �ּҰ�
        
        for(int group = 1; group <= (insert.length() / 2); group++) {		// �ڸ� �� �ִ�(�Է� �� ��ü ���ڿ� ������ ����) �ִ밪 ��ŭ for�� ����
            int totalLength = 0;
            int start = 0;
            
            while (start < (insert.length() - group)) {						// (�Է� �� ���ڿ� - �׷��� �� ����) ��ŭ �ݺ��� ex) abc abc dede -> de ���ķ� �� �ʿ� ����
                String groupStr = insert.substring(start, start + group);
                int matched = 0;
                int index = start + group;
                
                while(index < insert.length()) {
                    if(insert.startsWith(groupStr, index)) {				// �Է� �� ���ڿ��� index ��°�� �׷��� �� ���ڷ� �����ϴ��� üũ
                        matched++;
                        index += group;										// �׷��� �� ���� ��ŭ �ڸ� �̵�
                    } else break;
                }
                
                if(matched > 0) {
                	start = index;											// ���� ��ġ���� �ٸ� ���� ã������ start ��ġ �̵�
                    totalLength += groupStr.length() * matched - ((int) (Math.log10(1 + matched) + 1));		// ���� �� ���� ���� ex) abc abcabc dede -> abcabc 6���� �پ��� �� �տ� 6�� �ԷµǹǷ� 1���ڸ� 1�� ������ 
                } else {
                	start += group;											// �׷��� �� ���� ��ŭ start ��ġ �̵�
                }
            }
            int thisLen = insert.length() - totalLength;
            if(thisLen < cpMin) cpMin = thisLen;							// ���� ���� ������ �ּҰ� update
        }
        System.out.println(cpMin);
	}
}


//		abcabcdede
//		de / 2 / 1
//		abc / 3 / 1
//		8