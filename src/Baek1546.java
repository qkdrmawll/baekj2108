import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1546 {//평균 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;

        for (int i=0;i<n;i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            if (max < num) {
                max = num;
            }
        }
        double abs = (sum *100.0/max) /n ;
        System.out.println(abs);

    }
}
