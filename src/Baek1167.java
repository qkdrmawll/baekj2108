import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1167 { // 트리의 지름
    static ArrayList<Edge>[] A;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        A = new ArrayList[n+1];
        for (int i=1;i<=n;i++) {
            A[i] = new ArrayList<>();
        }
        for (int i=0;i<n;i++) {
            int s = sc.nextInt();
            while (true) {
            int e = sc.nextInt();
            if (e == -1) {
                break;
            }
            int w = sc.nextInt();
            A[s].add(new Edge(e,w));
            }
        }
        visited = new boolean[n+1];
        distance = new int[n+1];

        bfs(1);
        int max = 0;
        int index = 1;
        for (int i=1;i<=n;i++) {
            if (distance[i]>max){
                max = distance[i];
                index = i;
            }
        }
        visited = new boolean[n+1];
        distance = new int[n+1];
        bfs(index);

        max = 0;
        for (int i=1;i<=n;i++) {
            if (distance[i]>max){
                max = distance[i];
            }
        }
        System.out.println(max);
    }

    public static void bfs(int s) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Edge e : A[now] ) {
                if (!visited[e.e]) {
                    queue.add(e.e);
                    visited[e.e] = true;
                    distance[e.e] = distance[now] + e.weight;
                }
            }
        }
    }
    static class Edge {
        int e;
        int weight;

        public Edge(int e, int weight) {
            this.e = e;
            this.weight = weight;
        }
    }
}
