import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1456 { // 거의 소수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int n = (int) Math.sqrt(b);
        long [] A = new long[n+1];
        int count = 0;
        A[0] = -1;
        A[1] = -1;

        for (int i=2;i<=n;i++) {
            if (A[i] == -1) continue;
            for (int j=2;j<= n/2;j++) {
                if (i*j > n) {
                    break;
                }
                A[i*j] = -1;
            }
        }

        for (int i=2;i<=n;i++) {
            if (A[i] == -1) continue;
            long temp = i;
            while ((double) i <= (double) b/(double) temp) {
                if ((double) i >= (double) a/(double) temp) {
                    count++;
                }
                temp *= i;
            }
        }
        System.out.println(count);
    }
}
