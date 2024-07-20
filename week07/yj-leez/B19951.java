import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B19951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 연병장 크기
        int M = Integer.parseInt(st.nextToken()); // 조교 수

        int[] amount = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            amount[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int k = Integer.parseInt(st.nextToken());

            sum[start] += k;
            sum[end + 1] -= k;
        }

        for (int i = 1; i < N; i++) {
            sum[i] += sum[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append((sum[i] + amount[i]) + " ");
        }
        System.out.println(sb);
    }
}