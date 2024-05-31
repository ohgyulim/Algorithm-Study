import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16423 {

    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> union; // 연합을 이루고 있는 나라
    static int peopleSum;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N;
    static int L;
    static int R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int dayCnt = 0; // 인구이동이 발생하는 날짜 카운트
        while(true){
            /* 다시 처음부터 인구이동을 진행하므로 초기화 */
            boolean movePeople = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]){
                        union = new LinkedList(); // 연합 이룰 queue 초기화
                        union.add(new int[]{i, j});
                        peopleSum = map[i][j];

                        if (bfs(i, j)){
                            movePeople = true; // 인구이동이 발생함
                            int people = peopleSum / union.size();
                            // 연합을 이루는 땅들의 인구 나눠주기
                            while(!union.isEmpty()){
                                int[] poll = union.poll();
                                map[poll[0]][poll[1]] = people;
                            }

                        }
                    }
                }
            }

            if (!movePeople){
                break;
            }

            dayCnt++;
        }

        System.out.println(dayCnt);

    }

    // 국경선이 열려있는 나라가 있다면 true
    static boolean bfs(int x, int y){
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>(); // 탐색용 queue
        queue.add(new int[]{x, y});

        boolean open = false;
        while(!queue.isEmpty()){
            int[] d = queue.poll(); // 상하좌우 탐색할 위치

            for (int i = 0; i < 4; i++) {
                int nx = d[0] + dx[i];
                int ny = d[1] + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]){
                    int minus = Math.abs(map[d[0]][d[1]] - map[nx][ny]);
                    if (L <= minus && minus <= R){
                        visited[nx][ny] = true;
                        open = true;
                        queue.add(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                        peopleSum += map[nx][ny];
                    }
                }
            }
        }

        return open;
    }

}