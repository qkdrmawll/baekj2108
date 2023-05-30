import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1541 { //잃어버린 괄호
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MAX_VALUE;
        StringTokenizer sub = new StringTokenizer(br.readLine(),"-");

        while (sub.hasMoreTokens()) {
            int temp = 0;

            StringTokenizer add = new StringTokenizer(sub.nextToken(),"+");
            while (add.hasMoreTokens()) {
                temp += Integer.parseInt(add.nextToken());
            }
            if (min==Integer.MAX_VALUE) {
                min = temp;
            }else min -= temp;
        }
        System.out.println(min);
    }
}
