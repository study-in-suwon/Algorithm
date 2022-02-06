package sorting;

public class Failure_05 {
	public static void main(String[] args) {
		int N = 5;
		int stages[] = {2, 1, 2, 6, 2, 4, 3, 3};
		int answer[] = new int[N];
		double fail[] = new double[N];
		
		for (int i = 1; i <= N; i++) {						// i = 스테이지 단계
			int m = 0;						// 실패한 사람
			int n = 0;							// 실패율 대상
			for (int j = 0; j < stages.length; j++) {
				if(i == stages[j]) m++;
				if(i <= stages[j]) n++;
			}
			
			fail[i-1] = (double) m / n;
			answer[i-1] = i;
		}
		
		for (int i = 0; i < fail.length; i++) {
			for (int j = i + 1; j < fail.length; j++) {				// 실패율 내림차순
				if (fail[i] < fail[j]) {
					int temp = answer[i];
					answer[i] = answer[j];
					answer[j] = temp;
					double temp2 = fail[i];
					fail[i] = fail[j];
					fail[j] = temp2;
				} else if (fail[i] == fail[j]) {				// 같을 경우 오름차순
					if (answer[i] > answer[j]) {
						int temp = answer[i];
						answer[i] = answer[j];
						answer[j] = temp;
						double temp2 = fail[i];
						fail[i] = fail[j];
						fail[j] = temp2;
					}
				}
			}
		}
		
		for (int i = 0; i < answer.length; i++) System.out.print(answer[i] + "\t");
	}
}