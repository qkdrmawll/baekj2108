import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek1033 { // 칵테일
    static ArrayList<Node>[] A;
    static long lcm;
    static long[] D;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        A = new ArrayList[n];
        D = new long[n];
        visited = new boolean[n];
        lcm = 1;

        for (int i=0;i<n;i++){
            A[i] = new ArrayList<>();
        }
        for (int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            A[a].add(new Node(b,p,q));
            A[b].add(new Node(a,q,p));
            lcm *= (p * q / gcd(p, q));
        }
        D[0] = lcm;
        dfs(0);
        long mgcd = D[0];
        for (int i=1;i<n;i++) {
            mgcd = gcd(mgcd,D[i]);
        }
        for (int i=0;i<n;i++) {
            System.out.print(D[i] / mgcd +" ");
        }

    }
    static void dfs(int node) {
        visited[node] = true;
        for (Node i : A[node]) {
            int next = i.getB();
            if (!visited[next]) {
                D[next] = D[node] * i.getQ()/i.getP();
                dfs(next);
            }
        }
    }
    static long gcd(long a, long b){
        if (b==0) {
            return a;
        }
        return gcd(b,a%b);
    }
    static class Node {
        int b;
        int p;
        int q;

        public Node(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }

        public int getB() {
            return b;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }
    }
}
