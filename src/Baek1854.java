import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1854 { //k번째 최단경로 찾기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도시 수
        int m = Integer.parseInt(st.nextToken()); // 도로 수
        int k = Integer.parseInt(st.nextToken()); // k

        int[][] w = new int[1001][1001];
        PriorityQueue<Integer>[] dist = new PriorityQueue[n+1];
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        };
        for (int i=0;i<=n;i++) {
            dist[i] = new PriorityQueue<>(k,cp); //크기가 k 이고, Comparator를 cp로 갖는 우선순위 큐 생성
        }

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            w[a][b] = v;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));
        dist[1].add(0);
        while (!pq.isEmpty()) {
            Node u = pq.poll();
            for (int i=1;i<=n;i++) {
                if (w[u.end][i]!=0) {
                    if (dist[i].size() < k) {
                        dist[i].add(u.value + w[u.end][i]);
                        pq.add(new Node(i, u.value + w[u.end][i]));
                    }
                    else if (dist[i].peek() > u.value + w[u.end][i]) {
                        dist[i].poll();
                        dist[i].add(u.value + w[u.end][i]);
                        pq.add(new Node(i,u.value + w[u.end][i]));
                    }
                }
            }
        }
        for (int i=1;i<=n;i++) {
            if (dist[i].size() == k) {
                System.out.println(dist[i].peek());
            }else {
                System.out.println(-1);
            }
        }
    }
    static class Node implements Comparable<Node>{
        int end;
        int value;

        public Node(int end, int value) {
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node node) {
            return value - node.value;
        }
    }
}
