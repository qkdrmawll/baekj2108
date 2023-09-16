import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek24416 { //알고리즘 수업 - 피보나치 수1
    static int[] f = new int[41];
    static int cnt1=0;
    static int cnt2=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        f[1] = f[2] = 1;
        fib(n);
        fibonacci(n);
        System.out.println(cnt1+ " "+ cnt2);
    }
    public static int fib(int n) {
        if (n==1 ||n==2) {
            cnt1++;
            return 1;
        }
        else return fib(n-1)+fib(n-2);
    }
    public static int fibonacci(int n) {
        for (int i=3;i<=n;i++) {
            cnt2++;
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}
