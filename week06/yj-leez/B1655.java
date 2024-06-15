import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class B1656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 힙
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (maxHeap.size() == minHeap.size()){
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            // maxHeap이 더 클 경우 원소 switch
            if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if(maxHeap.peek() > minHeap.peek()) {
                    int tmp = maxHeap.poll();
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(tmp);
                }
            }
            sb.append(maxHeap.peek() + "\n");

        }

        System.out.println(sb);
    }
}


/**
 * 시간초과 :
 * Collections.sort() -> O(n logn)
 * 이것을 n번 반복하므로 O(N^2 log N) = 최악 시 10,000,000,000이므로 시간초과가 발생한다.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());

            list.add(tmp);
            Collections.sort(list);

            if (list.size() % 2 == 0){
                sb.append(list.get(list.size() / 2 - 1));
                sb.append("\n");
            } else {
                sb.append(list.get(list.size() / 2));
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}