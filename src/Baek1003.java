import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1003 { //피보나치 함수

    static Integer[][] arr = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i=0;i<T;i++) {

            int n = Integer.parseInt(br.readLine());
            fibonacci(n);
            sb.append(arr[n][0]).append(" ").append(arr[n][1]).append("\n");
        }
        System.out.println(sb);
    }

    public static Integer[] fibonacci(int n) {
        if (n == 0) {
            arr[n][0]=1;
            arr[n][1]=0;
        }
        else if (n == 1) {
            arr[n][0]=0;
            arr[n][1]=1;
        }
        if (arr[n][0]==null){
            arr[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
            arr[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
        }
        return arr[n];
    }

}