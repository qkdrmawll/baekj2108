import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek24479 { //알고리즘 수업 - 깊이 우선 탐색1
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> graph;
    static int[] seq;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        seq = new int[n+1];
        visited = new boolean[n+1];

        for (int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }
        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i=1;i<=n;i++) {
            Collections.sort(graph.get(i));
        }
        seq[r] = 1;
        visited[r] = true;
        cnt = 2;
        dfs(r);
        for (int i=1;i<=n;i++) {
            System.out.println(seq[i]);
        }
    }
    public static void dfs(int start) {
        for (int vertex:graph.get(start)) {
            if (!visited[vertex]) {
                seq[vertex] = cnt++;
                visited[vertex] = true;
                dfs(vertex);
            }
        }
    }
}
