import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek9465 { //스티커
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t=0;t<T;t++) {
            int col = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][col+1];
            int[][] dp = new int[2][col+1];
            /**
             * 스티커 배열
             */
            for (int i=0;i<2;i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= col; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            /**
             * dp 만들기
             */
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            for (int i=2;i<=col;i++) {
                dp[0][i] = Math.max(dp[1][i-1] + sticker[0][i], dp[1][i-2] + sticker[0][i]);
                dp[1][i] = Math.max(dp[0][i-1] + sticker[1][i], dp[0][i-2] + sticker[1][i]);
            }

            System.out.println(Math.max(dp[0][col],dp[1][col]));
        }
    }
}
