package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
	static class SetInfo {
		int row = 0;
		int col = 0;
		int homeCnt = 0;
		
		public SetInfo(int row, int col, int homCnt) {
			this.row = row;
			this.col = col;
			this.homeCnt = homCnt;
		}
	}
	
	private static int countHome(int area[][], int row, int col) {
		int count = 0;
		
		if(area[row-1][col] == 1) count++;
		if(area[row][col-1] == 1) count++;
		if(area[row+1][col] == 1) count++;
		if(area[row][col+1] == 1) count++;
		
		if(area[row-1][col-1] == 1) count++;
		if(area[row-1][col+1] == 1) count++;
		if(area[row+1][col-1] == 1) count++;
		if(area[row+1][col+1] == 1) count++;
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] area = new int[n+2][n+2];			// 마을
		int minStore = sc.nextInt();				// 최소 치킨집
		
		List<SetInfo> storeInfo = new ArrayList<>();
		
		
		for (int i = 1; i < area.length-1; i++)
			for (int j = 1; j < area[i].length-1; j++)
				area[i][j] = sc.nextInt();
		
		// 최소 치킨집만 남기고 제거
		// 주변에 집이 많은 치킨집 순으로 저장
		for (int i = 1; i < area.length-1; i++)
			for (int j = 1; j < area[i].length-1; j++)
				if(area[i][j] == 2)
					storeInfo.add(new SetInfo(i, j, countHome(area, i, j)));
		
		for (int i = 0; i < storeInfo.size(); i++) {
			System.out.println("(" + storeInfo.get(i).row + "," + storeInfo.get(i).col + ") / " + storeInfo.get(i).homeCnt);
		}
		
	}
}