import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11724 { //연결 요소의 개수
    static int[][]net;
    static boolean[] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int connect = 0;
        net = new int[n+1][n+1];
        visited = new boolean[n+1];
        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            net[a][b]=net[b][a]=1;
        }
        for (int i=1;i<=n;i++) {
            if (!visited[i]) {
                dfs(i);
                connect++;
            }
        }
        System.out.println(connect);
    }
    public static void dfs(int start) {
        visited[start] = true;
        for (int i=1;i<=n;i++) {
            if (net[start][i]==1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
