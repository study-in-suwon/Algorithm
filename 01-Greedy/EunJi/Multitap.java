package greedy;

import java.util.Scanner;
import java.util.stream.IntStream;

class CheckMultitap {
	int getIndex(int start, int find, int[] routine) {
		int result = 100;
		for (int i = start; i < routine.length; i++) if(find == routine[i]) {result = i; break;}
		
		return result;
	}
	
	int getMaxIndex(int[] ftPlug) {
		int maxIndex = 0;
		int value = 0;
		for (int i = 0; i < ftPlug.length; i++) if(ftPlug[i] > value) {maxIndex = i; value = ftPlug[i];}
		
		return maxIndex;
	}
}

public class Multitap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] plug = new int[sc.nextInt()];
		int[] ftPlug = new int[plug.length];
		int[] routine = new int[sc.nextInt()];
		int count = 0;
		
		for (int i = 0; i < routine.length; i++) {
			routine[i] = sc.nextInt();
			if(i < plug.length) plug[i] = routine[i];
		}
		
		CheckMultitap checkMultitap = new CheckMultitap();
		
		for (int i = plug.length; i < routine.length; i++) {
			int next = routine[i];
			if(!IntStream.of(plug).anyMatch(x -> x == next)) {																// 다음 사용할 제품이 플러그에 꽂혀있지 않을 때
				for (int j = 0; j < ftPlug.length; j++) ftPlug[j] = checkMultitap.getIndex(i, plug[j], routine);			// 현재 꽂힌 제품이 나중에 쓰일 순서 가져오기
				plug[checkMultitap.getMaxIndex(ftPlug)] = next;																// 가장 나중에 꽂힐 제품을 다음에 사용할 제품으로 교체
				count++;
			}
		}
		System.out.println(count);
	}
}