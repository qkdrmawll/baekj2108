import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11660 {//구간 합 구하기5

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 표의 크기
        int m = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수
        int[][] arr = new int[n+1][n+1]; // 원본 배열
        int[][] s = new int[n+1][n+1]; // 2차원 합 배열

        for (int i=1;i<=n;i++) { // i-1 연산이 필요하므로 1부터 n까지
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=n;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + arr[i][j]; //2차원 합 채우는 공식
            }
        }

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(s[x2][y2] - s[x2][y1-1] - s[x1-1][y2] + s[x1-1][y1-1]); // 2차원 구간 합 구하는 공식
        }

    }
}
