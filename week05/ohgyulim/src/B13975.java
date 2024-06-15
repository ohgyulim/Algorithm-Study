import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13975 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
			int K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				priorityQueue.add(Long.parseLong(st.nextToken()));
			}
			Long sum = 0L;
			while (priorityQueue.size() > 1) {
				Long a = priorityQueue.poll();
				Long b = priorityQueue.poll();
				sum += a + b;
				priorityQueue.add(a + b);
			}
			sb.append(sum);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
