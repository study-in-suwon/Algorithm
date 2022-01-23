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

		if (correct) return u + solution(v);				// u�� �ùٸ� ��ȣ ���ڿ��� ��� ������ v�� solution �ݺ�
		
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
				if (stack.isEmpty()) check = false;			// "(" ��ȣ�� ���� ��� �ùٸ� ��ȣ ���ڿ��� �ƴ�
				else stack.pop();							// "(" ��ȣ�� ���� ��� ������
			}

			if (left == right) {							// "(" �� ")" ������ ���� ���
				position = i + 1;							// ��ġ ����
				return check;
			}
		}
		return true;
	}
}