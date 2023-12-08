import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2018 {//수들의 합5

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 1;

        while (end != n) {
            if (sum > n) {
                sum -= start++;
            }
            else if (sum < n) {
                sum += ++end;
            }else {
                count++;
                sum += ++end;
            }
        }
        System.out.println(count);
    }
}
