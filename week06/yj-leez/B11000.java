import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B11000 {
    /**
     * 시작 시간이 빠른 순서대로 우선순위 큐에 넣고,
     * 종료 시간이 빠른 순대로 우선순위 큐 내에서 정렬하여
     * 새로운 강의를 가장 빨리 종료하는 강의와 비교하여 확인한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] lecture = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lecture[i] = new int[]{start, end};

        }

        Arrays.sort(lecture, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        pQ.add(lecture[0][1]);

        for (int i = 1; i < N; i++) {
            if (pQ.peek() <= lecture[i][0]){
                pQ.poll();
            }

            pQ.add(lecture[i][1]);
        }

        System.out.println(pQ.size());
    }
}