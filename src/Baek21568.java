import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek21568 { //Ax+By=C
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long gcd = gcd(a,b);
        if (c%gcd != 0) {
            System.out.println(-1);
            return;
        }
        long mok = (int)c/gcd;
        long[] ret = execute(a,b);
        System.out.println(ret[0]*mok +" "+ ret[1]*mok);

    }
    static long[] execute(long a, long b) {
        long[] ret = new long[2];
        if (b == 0) {
            ret[0] = 1;
            ret[1] = 0;
            return ret;
        }
        long q = a/b;
        long[] v = execute(b,a%b);
        ret[0] = v[1];
        ret[1] = v[0] - v[1] * q;
        return ret;
    }
    static long gcd(long a, long b) {
        while (b!=0) {
            long temp = a%b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }
}
