import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek2217 { //로프
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] rope = new int[N];
        int max = 0;
        for (int i=0;i<N;i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);
        for (int i=0;i<N;i++) {
            int temp = rope[i] * (N-i);
            if (temp>max) max = temp;
        }
        System.out.println(max);

    }
}
