import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split("");
        String[] str2  = br.readLine().split("");

        int[][] dp = new int[str1.length + 1][str2.length + 1];
        int ans = 0;
        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                if (str1[i - 1].equals(str2[j - 1])){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        System.out.println(ans);

    }
}