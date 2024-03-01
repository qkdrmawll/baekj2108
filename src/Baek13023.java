import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek13023 { //ABCDE
    //dfs
    //인접 노드를 방문하면서 depth가 5 이상인 경우를 판별
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean arrive;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n];
        visited = new boolean[n];

        for (int i=0;i<n;i++) {
            A[i] = new ArrayList<>();
        }

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 양방향 연결 데이터 저장
            A[a].add(b);
            A[b].add(a);
        }
        // 인접 노드를 방문하면서 depth>=5를 판별해야하므로 depth와 dfs, 1부터 시작
        for (int i=0;i<n;i++) {
            if (!visited[i]) {
                dfs(i,1);
            }
        }
        if (arrive) System.out.println(1);
        else System.out.println(0);

    }
    public static void dfs(int num, int depth) {
        if (depth == 5) {
            arrive = true;
            return;
        }
        if (visited[num]) {
            return;
        }
        visited[num] = true;

        for (int i : A[num]) {
            if (!visited[i]) {
                dfs(i,depth+1); // 인접 노드를 depth를 늘리면서 방문
            }
        }
    }
}
