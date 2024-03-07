import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek18352 { // 특정 거리의 도시 찾기
    static ArrayList<Integer>[] A;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 도시의 개수
        int m = Integer.parseInt(st.nextToken()); // 도로의 개수
        int k = Integer.parseInt(st.nextToken()); // 최단 거리
        int x = Integer.parseInt(st.nextToken()); // 출발 도시 번호

        A = new ArrayList[n+1]; // 도시와 도로 관계를 담을 데이터
        visited = new int[n+1]; // 방문 여부와 거리 정보를 저장할 데이터
        ArrayList<Integer> res = new ArrayList<>(); // 최단 거리가 k인 모든 도시의 정보를 오름차순으로 출력 해야하므로

        for (int i=0;i<=n;i++) {
            A[i] = new ArrayList<>();
        }

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
        }

        BFS(x);

        for (int i=0;i<visited.length;i++) {
            if (visited[i] == k+1) {
                res.add(i);
            }
        }
        Collections.sort(res);
        if (res.isEmpty()) {
            System.out.println("-1");
        }else {
            for (int i : res) {
                System.out.println(i);
            }
        }
    }
    static void BFS(int s) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[s]++;
        queue.add(s);

        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int i : A[n]) {
                if (visited[i]==0) {
                    visited[i] = visited[n]+1; // 방문 배열에 이동 거리 기록
                    queue.add(i);
                }
            }
        }
    }
}
