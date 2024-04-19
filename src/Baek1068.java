import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek1068 { // 트리
    // 리프노드의 개수를 구하는 문제
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int answer;
    static int delete;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        A = new ArrayList[n];
        visited = new boolean[n];

        for (int i=0;i<n;i++) {
            A[i] = new ArrayList<>();
        }
        int root = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            int j = Integer.parseInt(st.nextToken());
            if (j == -1) root = i;
            else {
                A[i].add(j);
                A[j].add(i);
            }
        }
        delete = Integer.parseInt(br.readLine());
        DFS(root);
        if (delete == root) System.out.println(0);
        else System.out.println(answer);
    }
    static void DFS(int n) {
        visited[n] = true;
        int leaf = 0;
        for (int i: A[n]) {
            if (!visited[i] && i!=delete) {
                leaf++;
                DFS(i);
            }
        }
        if (leaf == 0) {
            answer++;
        }
    }
}
