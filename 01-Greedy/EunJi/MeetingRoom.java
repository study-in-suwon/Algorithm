package greedy;

import java.util.Scanner;

public class MeetingRoom {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] mtRm = new int[sc.nextInt()][2];
		int endTm;
		int startTm = 0;
		int count = 0;
		int checkCnt = 0;
		
		for (int i = 0; i < mtRm.length; i++) {
			mtRm[i][0] = sc.nextInt();
			mtRm[i][1] = sc.nextInt();
		}
		
		while(true) {
			endTm = 2147483647;
			checkCnt = count;
			
			for (int i = 0; i < mtRm.length; i++) if(startTm <= mtRm[i][0] && endTm >= mtRm[i][1]) endTm = mtRm[i][1];		// ����ð��� ���� ���� ȸ�� ã��
			
			for (int i = 0; i < mtRm.length; i++) {
				if(startTm <= mtRm[i][0] && endTm == mtRm[i][1]) {
					startTm = mtRm[i][1];
					count++;
				}
			}
			if(checkCnt == count) break;
		}
		System.out.println(count);
	}
}
