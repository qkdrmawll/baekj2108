import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek1916 { // 최소비용 구하기
    static ArrayList<ArrayList<Node>> A; // 버스 정보
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        A = new ArrayList<>();
        visited = new boolean[n+1];
        distance = new int[n+1];

        for (int i=0;i<=n;i++) {
            A.add(new ArrayList<>());
        }

        // 거리 배열 큰 수로 초기화
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 버스 거리 정보 업데이트
        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A.get(s).add(new Node(e,v));
        }
        // 출발 - 도착 도시
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bw.write(dijkstra(start,end) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 다익스트라 알고리즘
    // 최단 경로 찾기
    static int dijkstra(int s, int e){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s,0));
        distance[s] = 0;

        while (!pq.isEmpty()) {
            Node newNode = pq.poll();
            int now = newNode.end;
            if (!visited[now]) {
                visited[now] = true;

                for (Node n : A.get(now)) {
                    if (!visited[n.end] && distance[n.end] > distance[now]+n.value) {
                        distance[n.end] = distance[now]+n.value;
                        pq.add(new Node(n.end, distance[n.end]));
                    }
                }
            }
        }
        return distance[e];
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
