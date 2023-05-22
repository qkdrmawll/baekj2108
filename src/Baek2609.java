import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2609 { //최대공약수 최소공배수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int temp;


        if(N<M){
            temp = N;
            N = M;
            M = temp;
        }
        int gcd = gcd(N,M);
        int lcm = N*M/gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }
    public static int gcd(int a,int b){
        if(a%b==0){
            return b;
        }
        return gcd(b,a%b);
    }
}
