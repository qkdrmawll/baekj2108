import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1436 { //영화감독 숌
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 1;
        int i =666;

        while (count<N) {
            i++;
            String check = String.valueOf(i);
            if (check.contains("666")) count++;
        }

        System.out.println(i);
    }
}
