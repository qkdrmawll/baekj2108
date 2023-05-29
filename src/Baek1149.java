import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1149 { //RGB거리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        int[][] dp = new int[N][3];

        StringTokenizer st;
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<3;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i=0;i<3;i++){
            dp[0][i] = arr[0][i];
        }

        for (int i=1;i<N;i++){
            dp[i][0] = arr[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = arr[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = arr[i][2]+Math.min(dp[i-1][1],dp[i-1][0]);
        }

        System.out.println(Arrays.stream(dp[N-1]).min().getAsInt());
    }
}
