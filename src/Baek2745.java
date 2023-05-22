import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2745 { //진법 변환
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int len = N.length();
        int result = 0;
        int base;

        for (int i=0;i<len;i++) {
            if (N.charAt(len-i-1)>64){
                base = N.charAt(len - i-1) - 55;
            }
            else base = N.charAt(len - i-1) - '0';
            System.out.println(base * Math.pow(B,i));
            result += base * Math.pow(B,i);
        }
        System.out.println(result);
    }
}
