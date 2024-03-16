import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1516 { // 게임 개발
    // 먼저 지어야 하는 건물이 있다 -> 위상 정렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] time = new int[n+1]; // 건물 짓는 데 걸리는 시간
        int[] res = new int[n+1]; // 건물이 완성되기 까지 걸리는 최소 시간
        int[] d = new int[n+1]; // 진입 차수
        ArrayList<Integer>[] A = new ArrayList[n+1];

        for (int i=1;i<=n;i++) {
            A[i] = new ArrayList<>();
        }
        // 건물 짓는 시간과 진입 차수 저장
        for (int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int temp = Integer.parseInt(st.nextToken());
            while (temp != -1) {
                A[temp].add(i);
                d[i]++;
                temp = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> queue = new ArrayDeque();
        for (int i=1;i<=n;i++) {
            if (d[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : A[now]) {
                d[next]--;
                //먼저 지어야 하는 건물이 여러 개인 경우
                //앞에 건물을 다 짓고 가장 오래 걸리는 시간을 택함
                res[next] = Math.max(res[next], res[now] + time[now]);
                if (d[next] == 0) {
                    queue.add(next);
                }
            }
        }
        for (int i=1;i<=n;i++) {
            System.out.println(res[i]+time[i]);
        }
    }


}
