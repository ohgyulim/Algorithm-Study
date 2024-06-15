import java.util.Scanner;
import java.util.Stack;

public class B9252 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String firstStr = sc.next();
		String secondStr = sc.next();

		int firstStrLength = firstStr.length();
		int secondStrLength = secondStr.length();

		int[][] dp = new int[firstStrLength + 1][secondStrLength + 1];
		Stack<Character> stack = new Stack<>();

		for (int i = 1; i <= firstStrLength; i++) {
			for (int j = 1; j <= secondStrLength; j++) {
				if (firstStr.charAt(i - 1) == secondStr.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		int y = firstStrLength;
		int x = secondStrLength;

		while (y >= 1 && x >= 1) {
			if (dp[y][x] == dp[y - 1][x]) {
				y--;
			} else if (dp[y][x] == dp[y][x - 1]) {
				x--;
			} else {
				stack.push(firstStr.charAt(y - 1));
				y--;
				x--;
			}
		}

		System.out.println(dp[firstStrLength][secondStrLength]);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}
