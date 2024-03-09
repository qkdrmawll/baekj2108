import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1707 { // 이분 그래프
    static ArrayList<Integer>[] A;
    static int[] visited;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        //tc
        for (int t=0;t<T;t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 노드 개수
            int m = Integer.parseInt(st.nextToken()); // 간선 개수

            visited = new int[n+1];
            A = new ArrayList[n+1];
            flag = true;

            for (int i=0;i<=n;i++) {
                A[i] = new ArrayList<>();
            }
            for (int i=0;i<=n;i++) {
                visited[i] = -1;
            }

            for (int i=0;i<m;i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                A[a].add(b);
                A[b].add(a);
            }

            for (int i=1;i<=n;i++) {
                if (flag) {
                    BFS(i);
                } else break;
            }

            if (flag) System.out.println("YES");
            else System.out.println("NO");
        }

    }
    static void BFS(int s) {
        Queue<Integer> queue = new ArrayDeque<>();
        if (visited[s] > 0) {
            return;
        }
        queue.add(s);
        visited[s] = 1;

        while (!queue.isEmpty()){
            int n = queue.poll();
            int j = visited[n]== 1? 2:1;
            for (int i : A[n]) {
                if (visited[i]<0) {
                    visited[i] = j;
                    queue.add(i);
                }else if (visited[i] != j) {
                    flag = false;
                    return;
                }
            }
        }
    }
}
