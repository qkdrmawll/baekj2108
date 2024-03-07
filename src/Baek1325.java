import java.io.*;
import java.util.*;

public class Baek1325 { // 효율적인 해킹

    //시간 초과
    // DFS 보단 BFS가 시간 절약
    // ArrayList보단 List가 시간 절약
    // 신뢰 관계에 따라 A[b].add(a)를 하면 방문 효율이 떨어짐
    // A[a].add[b]를 하고 b가 해킹할 수 있는 카운트를 세는 것이 효율이 좋음

    static List<Integer>[] A;
    static boolean[] visited;
    static int count;
    static int[] counting;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n+1];
        visited = new boolean[n+1];
        counting = new int[n+1];

        for (int i=0;i<n+1;i++) {
            A[i] = new ArrayList<>();
        }
        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
        }

        for (int i=1;i<n+1;i++) {
            visited = new boolean[n+1];
            BFS(i);
        }
        int max = 0;
        for (int i =1;i<=n;i++) {
            if (max<counting[i]) max = counting[i];
        }
        for (int i=0;i<=n;i++) {
            if (counting[i] == max) bw.append(String.valueOf(i)).append(" ");
        }
        bw.flush();
    }

    static void BFS(int s) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[s]= true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int i : A[n]) {
                if (!visited[i]) {
                    visited[i]=true; // 방문 배열에 이동 거리 기록
                    counting[i]++; //n이 i를 신뢰하므로 i의 해킹 가능 카운트를 늘려줌
                    queue.add(i);
                }
            }
        }
    }
}
