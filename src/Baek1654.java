import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1654 { //랜선 자르기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[k];
        for (int i=0;i<k;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        System.out.println(binarySearch(arr, n));

    }
    public static long binarySearch(long[] arr, int num){
        long start = 1;
        long end = arr[arr.length-1];
        long mid = 0;

        while (end >= start) {
            long count = 0;
            mid = (start + end) / 2;

            for (long i : arr) {
                count += i / mid;
            }
            if (count >= num) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return (start+end)/2;
    }
}
