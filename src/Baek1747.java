import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1747 { // 소수&팰린드롬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[10000001];

        A[0] = -1;
        A[1] = -1;
        for (int i=2;i<Math.sqrt(A.length);i++) {
            if (A[i] == -1) continue;
            for (int j=2;i*j<A.length;j++) {
                A[i*j] = -1;
            }
        }

        for (int i=n;i<A.length;i++) {
            if (A[i] != -1) {
                if (isBalance(i)) {
                    System.out.println(i);
                    break;
                }
            }
        }

    }
    public static boolean isBalance(int num) {
        char[] temp = String.valueOf(num).toCharArray();
        int s = 0;
        int e = temp.length-1;
        while (s < e) {
            if (temp[s] != temp[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
