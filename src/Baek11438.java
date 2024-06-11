import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek11438 { // LCA2
    //빠르게 최소 공통 부모 구하기
    static ArrayList<Integer>[] tree;
    static int[][] parent;
    static int[] depth;
    static int kmax;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        depth = new int[n+1];
        for (int i=0;i<=n;i++) {
            tree[i] = new ArrayList<>();
        }
        int tmp = 1;
        kmax = 0;
        while (tmp <= n) {
            tmp <<= 1;
            kmax++;
        }

        //System.out.println("kmax = " + kmax);
        parent = new int[kmax+1][n+1];

        StringTokenizer st;
        for (int i=0;i<n-1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        init(1,1,0);
        for (int k = 1; k<= kmax; k++) {
            for (int i=1;i<=n;i++) {
                parent[k][i] = parent[k-1][parent[k-1][i]];
            }
        }
        int m = Integer.parseInt(br.readLine());
        for (int i =0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            LCA(a,b);
        }
    }

    private static void LCA(int a, int b) {
        if (depth[a] > depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        for (int k=kmax;k>=0;k--) {
            if (Math.pow(2,k) <= depth[b] - depth[a]) {
                if (depth[a] <= depth[parent[k][b]]) {
                    b = parent[k][b];
                }
            }
        }

        for (int k=kmax;k>=0;k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }
        int lca = a;
        if (a != b) {
            lca = parent[0][lca];
        }
        System.out.println(lca);
    }

    static void init(int node, int d, int p) {
        parent[0][node] = p;
        depth[node] = d;

        for (int next : tree[node]) {
            if (next != p) {
                init(next,d+1,node);
            }
        }
    }
}
