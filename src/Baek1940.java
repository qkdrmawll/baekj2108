import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1940 {//주몽

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int i = 0;
        int j = n-1;
        int count = 0;

        while (i<j) {
            int sum = arr[i] + arr[j];
            if (sum > m) {
                j--;
            } else if (sum < m) {
                i++;
            } else {
                count++;
                i++;
            }
        }
        System.out.println(count);
    }
}
