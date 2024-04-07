import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11403 { // 경로 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] dist = new int[n+1][n+1];

        for (int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=n;j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k=1;k<=n;k++) {
            for (int i=1;i<=n;i++) {
                for (int j=1;j<=n;j++) {
                    if (dist[i][k] == 1 && dist[k][j]==1)
                        dist[i][j] = 1;
                }
            }
        }

        for (int i=1;i<=n;i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
