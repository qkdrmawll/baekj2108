import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1219 { // 오만식의 고민
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[m];
        long[] cityMax = new long[n];
        long[] money = new long[n];

        Arrays.fill(money, Long.MIN_VALUE);

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(s,e,c);
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            cityMax[i] = Integer.parseInt(st.nextToken());
        }

        //변형된 벨만-포드 알고리즘 수행
        money[start] = cityMax[start];
        //양수 사이클이 전파되도록 충분히 큰수로 반복하기
        for (int i=0;i<n+100;i++) {
            for (int j=0;j<m;j++) {
                int s = edges[j].s;
                int e = edges[j].e;
                int c = edges[j].cost;
                //출발노드가 방문하지 않은 노드면 스킵
                if (money[s] == Long.MIN_VALUE) continue;
                //출발노드가 양수 사이클에 연결된 노드라면 종료 노드도 연결 노드로 업데이트
                else if (money[s] == Long.MAX_VALUE)
                    money[e] = Long.MAX_VALUE;
                //돈을 더 많이 벌 수 있는 새로운 경로가 발견됐을 때 새로운 경로 값으로 업데이트
                else if (money[e] < money[s] + cityMax[e] - c) {
                    money[e] = money[s] + cityMax[e] - c;
                    if (i >= n-1) money[e] = Long.MAX_VALUE;
                }
            }

        }
        if (money[end] == Long.MIN_VALUE) System.out.println("gg");
        else if (money[end] == Long.MAX_VALUE) System.out.println("Gee");
        else System.out.println(money[end]);

    }

    static class Edge {
        int s;
        int e;
        int cost;

        public Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }
}
