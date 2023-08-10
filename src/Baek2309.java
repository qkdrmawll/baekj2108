import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek2309 { // 일곱 난쟁이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] h = new int[9];
        int idx1 = 0;
        int idx2 = 0;
        int sum = 0;

        for (int i=0;i<9;i++) {
            h[i] = Integer.parseInt(br.readLine());
        }
        for (int i=0;i<9;i++) {
            sum += h[i];
        }

        loop:
        for (int i=0;i<8;i++) {
            for (int j=i+1;j<9;j++) {
                int temp = sum - h[i] -h[j];
                if (temp==100) {
                    idx1 = i;
                    idx2 = j;
                    break loop;
                }
            }
        }
        h[idx1] = 0;
        h[idx2] = 0;
        Arrays.sort(h);
        for (int i=0;i<9;i++) {
            if (h[i]!=0) System.out.println(h[i]);
        }
    }
}
