import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek1197 { // 최소 스패닝 트리
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        parent = new int[n+1];
        for (int i=0;i<n;i++) {
            parent[i] = i;
        }
        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pq.add(new Edge(s,e,v));
        }
        int result = 0;
        for (int i=0;i<n-1;i++) {
            Edge now = pq.poll();
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                result += now.v;
            }
        }
        System.out.println(result);
    }
    static void union(int a, int b) {
        parent[find(b)] = find(a);
    }
    static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
    static class Edge implements Comparable<Edge>{
        int s;
        int e;
        int v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return this.v - o.v;
        }
    }
}
