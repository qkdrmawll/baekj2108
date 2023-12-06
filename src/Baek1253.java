import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1253 {//좋다

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i=0;i<n;i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int count = 0;
        for (int k=0;k<n;k++) {
            int i = 0;
            int j = n-1;
            long find = arr[k];
            while (i<j) {
                long sum = arr[i] + arr[j];
                if (sum > find) {
                    j--;
                }else if (sum < find) {
                    i++;
                }else {
                    if (i != k && j!= k) {
                        count++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else {
                        j--;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
