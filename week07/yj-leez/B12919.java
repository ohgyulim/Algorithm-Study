import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B12919 {
    /**
     * S에서 'A' 또는 'B'를 더하면서 T가 될 수 있는지 확인하는 방법 -> 단어가 중복되는 경우가 있어 메모리 초과
     * T에서 규칙에 따라 'A'를 빼거나 'B'를 빼면서 S가 되는지 확인 -> 중복되는 경우가 없어 성공
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        Queue<String> q = new ArrayDeque<>();
        q.add(T);

        while(!q.isEmpty()){
            String tmp = q.poll();
            if (tmp.equals(S)) {
                System.out.println(1);
                return;
            }

            if (tmp.length() <= S.length()) continue;
            if (tmp.charAt(tmp.length() - 1) == 'A'){
                q.add(tmp.substring(0, tmp.length() - 1));
            }
            if (tmp.charAt(0) == 'B'){
                q.add(new StringBuilder(tmp.substring(1)).reverse().toString());
            }
        }

        System.out.println(0);
    }
}