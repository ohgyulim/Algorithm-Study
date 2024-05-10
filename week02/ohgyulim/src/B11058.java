import java.util.Scanner;

public class B11058 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long[] dp = new long[n + 1];

		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i <= 6)
				continue;
			for (int j = 3; j < 6; j++) {
				dp[i] = Math.max(dp[i], dp[i - (j + 1)] * j);
			}
		}
		// dp[4] = aaaa -> 4
		// dp[5] = aaaaa -> 5
		// dp[6] = aa acv v -> 6
		// dp[7] = aaa acv v -> 9
		System.out.println(dp[n]);
	}
}
