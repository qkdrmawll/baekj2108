import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2485 { // 가로수
    //최대공약수 GCD 함수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for (int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        int gcd = 0;
        for (int i=0;i<n-1;i++) {
            int dist = nums[i+1] - nums[i];
            gcd = findGCD(dist, gcd);
        }
        int result = (nums[nums.length - 1] - nums[0]) / gcd + 1 - nums.length;
        System.out.println(result);
    }

    private static int findGCD(int a, int b) {
        if (b==0) return a;
        else return findGCD(b,a%b);
    }
}


