import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek9461 { //파도반 수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = 3;
        dp[7] = 4;
        dp[8] = 5;
        while (T>0){
            int N = Integer.parseInt(br.readLine());
            for (int i=9;i<=N;i++) {
                dp[i] = dp[i-1] + dp[i-5];
            }
            System.out.println(dp[N]);
            T--;
        }

    }
}
