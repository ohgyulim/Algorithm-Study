import java.util.Scanner;

public class B11058 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long[] dp = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i <= 6)
				continue;
			for (int j = 3; j < 6; j++) {
				dp[i] = Math.max(dp[i], dp[i - (j + 1)] * j);
			}
		}
		// dp[4] = aaaa -> 4
		// dp[5] = aaaaa -> 5
		// dp[6] = aa acv v = dp[2] * 3 -> 6
		// dp[7] = aaa acv v = dp[3] * 3 -> 9

		// dp[1] = a
		// dp[2] = aa
		// dp[3] = aaa

		// dp[i - 4] * 3 == acv v -> v 2개 = 3배: src + (src) * 2
		// dp[i - 5] * 4 == acv v v -> v 3개 = 4배: src + (src) * 3
		// dp[i - 6] * 5 == acv v v v -> v 4개 = 5배: src + (src) * 4

		//dp[7] = Math.max(dp[3] * 3, dp[2] * 4, dp[1] * 5)

		System.out.println(dp[n]);
	}
}
