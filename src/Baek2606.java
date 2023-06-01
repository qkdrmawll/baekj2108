import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2606 { //바이러스
    static boolean[] visited;
    static int[][] net;
    static int node;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[node+1];
        net = new int[node+1][node+1];
        StringTokenizer st;
        for (int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            net[a][b] = net[b][a] = 1;
        }
        dfs(1);
        System.out.println(count-1);

    }
    static void dfs(int start) {
        visited[start] = true;
        count++;
        System.out.println(start);
        for (int i=1;i<=node;i++) {
            if (net[start][i]==1 && !visited[i]) dfs(i);
        }
    }
}
