import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10986 {//나머지 합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] s = new long[n];
        long[] count = new long[m];
        long result = 0;

        st = new StringTokenizer(br.readLine());
        s[0] = Integer.parseInt(st.nextToken());
        for (int i=1;i<n;i++) {
            s[i] += s[i-1] + Integer.parseInt(st.nextToken());
        }
        for (int i=0;i<n;i++) {
            int remainder = (int) (s[i] % m);
            if (remainder == 0) {
                result++;
            }
            count[remainder]++;

        }
        for (int i=0;i<m;i++) {
            long c = count[i];
            if (c > 1) {
                result += c * (c-1) /2;
            }
        }
        System.out.println(result);
    }
}
