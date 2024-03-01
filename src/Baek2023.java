import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2023 { //신기한 소수
    // dfs 응용 문제
    // depth를 자릿수의 개념으로 응용 & 인접 노드를 소수인 경우로 직접 설정(=가지치기)
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 자릿수
        // 1자리수에서 소수가 아닌 4,6,8,9를 가지치기
        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);

    }
    public static void dfs(int num, int depth) {
        // 소수 판별은 전 depth에서 했기 때문에 자릿수만 확인하고 출력
        if (depth == n) {
            System.out.println(num);
            return;
        }
        for (int i=1;i<10;i++) {
            int newNum = num *10 + i;
            if (isPrime(newNum)) { // 소수라면 자릿수를 늘림
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
