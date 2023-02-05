import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak1003 { //피보나치 함수 미완성
    static int count0 = 0;
    static int count1 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++) {
            count0 = 0;
            count1 = 0;
            fibonacci(Integer.parseInt(br.readLine()));
            sb.append(count0).append(" ").append(count1).append("\n");
        }
        System.out.println(sb);
    }

    public static void fibonacci(int n) {
        if (n==0) {
            count0++;
        } else if (n==1) {
            count1++;
        } else {
            fibonacci(n-1);
            fibonacci(n-2);
        }
    }

}
