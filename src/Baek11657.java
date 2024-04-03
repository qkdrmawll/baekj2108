import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11657 { // 타임머신
    // 벨만-포드 알고리즘의 대표적인 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[m+1];
        long[] dist = new long[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(s,e,v);
        }

        // 벨만-포드 알고리즘
        dist[1] = 0;
        for (int i=1;i<n;i++) {
            for (int j=0;j<m;j++) {
                Edge edge = edges[j];
                // 더 작은 최단 거리가 있을 때 업데이트
                if (dist[edge.s] != Integer.MAX_VALUE
                && dist[edge.e] > dist[edge.s] + edge.v) {
                    dist[edge.e] = dist[edge.s] + edge.v;
                }
            }
        }
        // 음의 사이클 확인하기
        boolean flag = false;
        for (int j=0;j<m;j++) {
            Edge edge = edges[j];

            if (dist[edge.s] != Integer.MAX_VALUE
                    && dist[edge.e] > dist[edge.s] + edge.v) {
                flag = true;
            }
        }
        if (!flag) {
            for (int i=2;i<=n;i++) {
                if (dist[i] == Integer.MAX_VALUE) {
                    System.out.println(-1);
                }else {
                    System.out.println(dist[i]);
                }
            }
        } else System.out.println(-1);
    }
    static class Edge {
        int s;
        int e;
        int v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
    }
}
