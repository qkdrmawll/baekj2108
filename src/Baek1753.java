import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek1753 { // 최단경로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken()); //정점 개수
        int e = Integer.parseInt(st.nextToken()); //간선 개수
        int k = Integer.parseInt(br.readLine()); //시작 정점 번호
        int[] distance = new int[v+1];
        boolean[] visited = new boolean[v+1];

        PriorityQueue<Node> q = new PriorityQueue<>();

        for (int i=0;i<=v;i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        ArrayList<Node>[] A = new ArrayList[v+1];
        for (int i=1;i<=v;i++) {
            A[i] = new ArrayList<>();
        }

        for (int i=0;i<e;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            A[start].add(new Node(end,w));
        }

        q.add(new Node(k,0));
        distance[k] = 0;

        while (!q.isEmpty()) {
            Node current = q.poll();
            int cEnd = current.end;
            if (visited[cEnd]) continue;
            visited[cEnd] = true;
            for (int i=0; i<A[cEnd].size();i++) {
                Node temp = A[cEnd].get(i);
                int next = temp.end;
                int weight = temp.weight;
                if (distance[next] > distance[cEnd] + weight) {
                    distance[next] = distance[cEnd] + weight;
                    q.add(new Node(next, distance[next]));
                }
            }
        }

        for (int i=1;i<=v;i++) {
            if (visited[i]) System.out.println(distance[i]);
            else System.out.println("INF");
        }

    }

}

class Node implements Comparable<Node>{
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    public int compareTo(Node e) {
        if (this.weight > e.weight) return 1;
        else return -1;
    }
}