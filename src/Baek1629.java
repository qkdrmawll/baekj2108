import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1629 { //곱셈
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A,B));
    }
    public static long pow(long A, long B) {
        if (B==1) return A%C;

        long temp = pow(A,B/2);

        if (B % 2 ==1){
            return ((temp*temp%C) * (A%C))%C;
        }
        return (temp*temp)%C;
    }
}
