import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9252 {

    static int[][] dp;
    static String[] str1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine().split("");
        String[] str2 = br.readLine().split("");

        dp = new int[str1.length + 1][str2.length + 1];
        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                if (str1[i - 1].equals(str2[j - 1])){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[str1.length][str2.length]);
        LCS(str1.length, str2.length);
    }

    static void LCS(int i, int j){
        Stack<String> stack = new Stack<>();

        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j]){
                i--;
            } else if (dp[i][j] == dp[i][j - 1]){
                j--;
            } else {
                stack.push(str1[i - 1]);
                i--;
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }
}