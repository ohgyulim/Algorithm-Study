import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13975 {
    static int K;
    static PriorityQueue<Long> pQ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            K = Integer.parseInt(br.readLine());
            pQ = new PriorityQueue<>(K);

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                pQ.add(Long.parseLong(st.nextToken()));
            }

            sb.append(calculate() + "\n");
        }

        System.out.print(sb);
    }

    static long calculate(){
        long ans = (long) 0;
        while(true){

            long num1 = pQ.poll();

            if (pQ.isEmpty()){
                return ans;
            }

            long num2 = pQ.poll();
            ans += num1 + num2;
            pQ.add(num1 + num2);

        }

    }
}
