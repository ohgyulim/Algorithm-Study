import java.util.Scanner;

public class B2293 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n + 1];
		int[] dp = new int[k + 1];

		for (int i = 1; i <= n; i++)
			arr[i] = sc.nextInt();

		// 1. 동전의 가치를 하나씩 선택
		for (int i = 1; i <= n; i++) {
			// 2. dp[동전의 가치] += 1 -> 경우의 수가 동전의 가치만 있는 경우가 있기 때문에
			if (arr[i] <= k)
				dp[arr[i]] += 1;
			// 3. 이전까지 저장한 내용을 바탕으로 경우의 수 초기화
			for (int j = arr[i]; j <= k; j++)
				dp[j] += dp[j - arr[i]];
		}
		System.out.println(dp[k]);
	}
}
