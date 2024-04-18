import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek11725 { //트리의 부모 찾기
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        A = new ArrayList[n+1];
        visited = new boolean[n+1];
        parent = new int[n+1];
        for (int i=1;i<=n;i++) {
            A[i] = new ArrayList<>();
        }
        for (int i=0;i<n-1;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        DFS(1);
        for (int i=2;i<=n;i++) {
            System.out.println(parent[i]);
        }
    }
    static void DFS(int i) {
        visited[i] = true;
        for (int j: A[i]) {
            if (!visited[j]) {
                parent[j] = i;
                DFS(j);
            }
        }
    }
}
