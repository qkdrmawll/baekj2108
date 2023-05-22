import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek15829 { //Hashing
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int sum = 0;
        String[] st = br.readLine().split("");
        for (int i=0;i<L;i++) {
            int ch = st[i].charAt(0) - 96;
            sum += ch * (int) Math.pow(31,i);
        }
        sum = sum%1234567891;
        System.out.println(sum);
    }
}
