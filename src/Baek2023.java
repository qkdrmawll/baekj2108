import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2023 { //신기한 소수
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);

    }
    public static void dfs(int num, int depth) {
        if (depth == n) {
            System.out.println(num);
            return;
        }
        for (int i=1;i<10;i++) {
            int newNum = num *10 + i;
            if (isPrime(newNum)) {
                dfs(newNum,depth+1);
            }
        }
    }
    public static boolean isPrime(int n) {
        for (int i=2;i<n;i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
