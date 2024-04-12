import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek1414 { // 불우이웃 돕기
    //최소신장트리 알고리즘
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int sum = 0;
        parent = new int[n];
        //대표노드 배열 초기화
        for (int i=0;i<n;i++) {
            parent[i] = i;
        }
        // 알파벳 -> 가중치 변환
        for (int i=0;i<n;i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j=0;j<n;j++) {
                char c = temp[j];
                int num;
                if (c > 96) {
                    num = c - 96;
                    pq.add(new Edge(i,j,num));
                } else if (c!='0') {
                    num = c - 38;
                    pq.add(new Edge(i,j,num));
                }else num = 0;
                sum += num;
            }
        }
        //최소신장트리
        int useE = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (find(now.s) != find(now.e)) { //출발노드와 도착노드의 대표노드가 같지 않다면 결합
                union(now.s, now.e);
                useE++;
                sum -= now.v;
            }
        }
        if (useE == n-1) { // n-1 개의 간선이 있어야 모든 노드가 연결된 상태
            System.out.println(sum);
        }else System.out.println(-1);

    }
    static void union(int a, int b) {
        parent[find(b)] = parent[find(a)];
    }
    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return find(parent[a]);
    }
    static class Edge implements Comparable<Edge>{
        int s,e,v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.v - edge.v;
        }
    }
}
