import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2110 { //공유기 설치
    static int[] x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        x = new int[n];
        for (int i=0;i<n;i++) {
            x[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(x);
        System.out.println(binarySearch(c)-1);

    }
    public static int binarySearch(int quantity) {
        int start = 1;
        int end = x[x.length-1]- x[0];
        while (start <= end) {
            int mid = (start+end)/2;
            if (installCheck(mid) < quantity) {
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return start;
    }
    public static int installCheck(int distance) {
        int count = 1;
        int lastInstall = x[0];
        for (int i=1;i<x.length;i++) {
            if (x[i] - lastInstall >= distance) {
                count++;
                lastInstall = x[i];
            }
        }
        return count;
    }
}
