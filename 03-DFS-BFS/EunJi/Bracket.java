package bfs_dfs;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {
	static int position;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(solution(sc.next()));
	}

	public static String solution(String str) {
		if (str.isEmpty()) return str;

		boolean correct = isCorrect(str);

		String u = str.substring(0, position);
		String v = str.substring(position, str.length());

		if (correct) return u + solution(v);				// u가 올바른 괄호 문자열일 경우 나머지 v도 solution 반복
		
		String answer = "(" + solution(v) + ")";			// ex) ))(( -> ( solution(")(") )

		for (int i = 1; i < u.length() - 1; i++) {
			if (u.charAt(i) == '(') answer += ")";
			else  answer += "(";
		}

		return answer;
	}

	static boolean isCorrect(String str) {
		boolean check = true;
		int left = 0;
		int right = 0;
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				left++;
				stack.push('(');
			} else {
				right++;
				if (stack.isEmpty()) check = false;			// "(" 괄호가 없을 경우 올바른 괄호 문자열이 아님
				else stack.pop();							// "(" 괄호가 있을 경우 꺼내기
			}

			if (left == right) {							// "(" 와 ")" 개수가 같을 경우
				position = i + 1;							// 위치 저장
				return check;
			}
		}
		return true;
	}
}