package ohgyulim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));

		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			if (minHeap.size() == maxHeap.size()) {
				maxHeap.offer(number);
			} else minHeap.offer(number);

			if(!minHeap.isEmpty() && !maxHeap.isEmpty())
				if(minHeap.peek() < maxHeap.peek()){
					int tmp = minHeap.poll();
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(tmp);
				}
			sb.append(maxHeap.peek()).append("\n");
		}
		System.out.print(sb);
	}
}
