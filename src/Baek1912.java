import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1912 { //연속합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = nums[0];
        for (int i=1;i<n;i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
