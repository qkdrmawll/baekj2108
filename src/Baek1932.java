import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1932 { //정수 삼각형
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][n];
        int dp[][] = new int[n][n];
        StringTokenizer st;
        for (int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<=i;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0]=arr[0][0];
        for (int i=0;i<n-1;i++) {
            for (int j=0;j<=i;j++) {
                int temp1 = dp[i][j]+arr[i+1][j];
                int temp2 = dp[i][j]+arr[i+1][j+1];
                if (dp[i+1][j]<temp1) dp[i+1][j] = temp1;
                if (dp[i+1][j+1]<temp2) dp[i+1][j+1] = temp2;
            }
        }
        System.out.println(Arrays.stream(dp[n-1]).max().getAsInt());
    }
}
