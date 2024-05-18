import java.util.Scanner;

public class B5582 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int answer = 0;
		String firstStr = sc.next();
		String secondStr = sc.next();

		int firstStrLength = firstStr.length();
		int secondStrLength = secondStr.length();

		int[][] dp = new int[firstStrLength + 1][secondStrLength + 1];

		for (int i = 1; i <= firstStrLength; i++) {
			for (int j = 1; j <= secondStrLength; j++) {
				if (firstStr.charAt(i - 1) != secondStr.charAt(j - 1)) continue;
				dp[i][j] = dp[i - 1][j - 1] + 1;
				answer = Math.max(answer, dp[i][j]);
			}
		}

		System.out.println(answer);

	}
}
