import java.util.Scanner;

public class B9251 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		String firstStr = sc.next();
		String secondStr = sc.next();

		int firstLength = firstStr.length();
		int secondLength = secondStr.length();

		int[][] dp = new int[firstLength + 1][secondLength + 1];

		for (int i = 1; i <= firstLength; i++) {
			for (int j = 1; j <= secondLength; j++) {
				if (firstStr.charAt(i - 1) == secondStr.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		System.out.println(dp[firstLength][secondLength]);
	}
}
