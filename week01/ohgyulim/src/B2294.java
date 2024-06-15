import java.util.Arrays;
import java.util.Scanner;

public class B2294 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] arr = new int[n + 1];
		int[] dp = new int[k + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.fill(dp, 10_000_001);

		for (int i = 1; i <= n; i++) {
			if (arr[i] <= k)
				dp[arr[i]] = 1;
			for (int j = arr[i] + 1; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
			}
		}
		System.out.println(dp[k] == 10_000_001 ? -1 : dp[k]);
	}

}
