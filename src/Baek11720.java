import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek11720 { //숫자의 합 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] numbers = br.readLine().toCharArray();
        int sum = 0;
        for (int i=0;i<n;i++) {
            sum += numbers[i]-'0';
        }
        System.out.println(sum);
    }
}
