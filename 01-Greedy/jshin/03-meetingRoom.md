## 백준 회의실

### 풀이 
1. 시간별로 가질 수 있는 최대 회의실 스케줄을 갱신하는 방식으로 구현
2. Meeting 객체를 만들어 Comparable 인터페이스를 상속받아 시작 시간을 오름 차순으로 정렬하고 같을 경우 종료시간을 오름차순으로 정렬하여 List로 받음
3. 시작 시간 그룹별로 나눠 List로 묶음
4. 가장 마지막 종료 시간만큼 배열을 만들어 가장 처음 시작시간 부터 반복문을 통해 각 시간마다 사용할 수 있는 최대 회의실의 값을 입력함
5. 값을 계속 갱신하여 어떤 회의실 스케줄을 사용하든 배열의 마지막 값이 최대값이 됨

### 풀이 2
1. 처음 풀었던 방식으로도 백준 제출시 통과했으나 그리디 알고리즘을 사용한 것 같지 않아 다른 사람들이 구현한 내용을 보고 다시 구현함
2. 처음 풀이와 똑같이 Meeting 객체를 만들어 Comparable 인터페이스를 상속받아 종료 시간을 오름차순으로 정렬하고 같을경우 시작시간을 오름차순으로 정렬하여 List로 받음
3. List를 반복문으로 돌려 종료 시간과 시작시간이 겹치치 않도록 카운팅함
4. 마지막 종료 시간까지 카운팅이 되면 최대 값이 나옴


### 구현 코드 1
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Meeting implements Comparable<Meeting> {

		int start;
		int end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting others) {
			if (this.start == others.start) {
				return Integer.compare(this.end, others.end);
			}
			return Integer.compare(this.start, others.start);
		}
	}

	static List<List<Meeting>> meetingArr = new ArrayList<>();
	static List<Meeting> meetings = new ArrayList<>();
	static int[] result;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			max = Math.max(max, end);
			meetings.add(new Meeting(start, end));
		}

		// 정렬

		Collections.sort(meetings);

		for (int i = 0; i <= max; i++) {
			meetingArr.add(new ArrayList<>());
		}

		for (int i = 0; i < meetings.size(); i++) {
			Meeting meeting = meetings.get(i);
			meetingArr.get(meeting.start).add(meeting);
		}

		result = new int[max + 1];

		for (int i = 0; i <= max; i++) {
			int pre;
			if (i == 0){
				pre = 0;
			} 
			else {
				pre = result[i - 1];
			}

			result[i] = Math.max(result[i], pre);
			List<Meeting> meetingI = meetingArr.get(i);

			if (meetingI.size() > 0) {
				for (Meeting meeting : meetingI) {
					result[meeting.end] = result[i] + 1;
				}
			}
		}
		System.out.println(result[max]);

	}
}
```

### 구현 코드 2
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static class Meeting implements Comparable<Meeting> {

		int start;
		int end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting others) {
			if (this.end == others.end) {
				return Integer.compare(this.start, others.start);
			}
			return Integer.compare(this.end, others.end);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Meeting> meetings = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			meetings.add(new Meeting(start, end));
		}

		Collections.sort(meetings);
		
		int start = -1;
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (meetings.get(i).start < start) {
				continue;
			}
			start = meetings.get(i).end;
			count++;
		}
		System.out.println(count);
	}
}
```
