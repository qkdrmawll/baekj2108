import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1010 { // 다리 놓기

    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t=0;t<T;t++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            dp = new long[n+1][n+1];

            for (int i=0;i<n+1;i++) {
                dp[i][0] = 1;
            }

            for (int i=1;i<n+1;i++) {
                for (int j=1;j<=i;j++) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }

            System.out.println(dp[n][m]);
        }
    }
}
/**
 * 서쪽에는 N개의 사이트
 * 동쪽에는 M개의 사이트
 * 서쪽의 사이트 - 동쪽의 사이트 연결
 * 서쪽의 사이트만큼 다리 짓기
 */