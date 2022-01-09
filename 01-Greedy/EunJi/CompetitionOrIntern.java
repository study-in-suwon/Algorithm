package greedy;

import java.util.Scanner;

public class CompetitionOrIntern {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int women = sc.nextInt();
		int men = sc.nextInt();
		int minus = sc.nextInt();
		int result = 0;
		
		if(women > men) women -= minus;
		else men -= minus;
		
		result = women / 2;
		if(result > men) result = men;
		
		System.out.println(result);
	}
}