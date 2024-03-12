import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1976 { // 여행 가자

    static int[] present;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시 개수
        int m = Integer.parseInt(br.readLine()); // 여행 갈 도시 개수
        int[][] dosi = new int[n+1][n+1]; // 도시 연결 데이터
        int[] route = new int[m+1]; // 여행 갈 도시 저장 배열
        present = new int[n+1]; // 대표 노드 저장

        // 도시 연결 데이터 저장
        StringTokenizer st;
        for (int i=1;i<n+1;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<n+1;j++) {
                dosi[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 여행 갈 도시 배열 저장
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=m;i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }
        // 대표 노드 초기화
        for (int i=1;i<=n;i++) {
            present[i] = i;
        }
        // 연결이 있을 경우 결합
        for (int i=1;i<n+1;i++) {
            for (int j = 1; j < n + 1; j++) {
                if (dosi[i][j] == 1) {
                    union(i,j);
                }
            }
        }
        // 여행 계획 도시들이 1개의 대표 도시로 연결돼 있는지 확인하기
        int temp = find(route[1]);
        for (int i=2;i<=m;i++) {
            if (find(route[i])!=temp) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static void union(int a, int b) {
        present[find(b)] = present[find(a)];
    }
    static int find(int a) {
        if (a == present[a]) return a;
        else {
            return present[a] = find(present[a]);
        }
    }
}

