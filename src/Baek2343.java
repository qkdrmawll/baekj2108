import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2343 { // 기타 레슨
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] lesson = new int[n];
        int max = 0;
        int sum = 0;
        for (int i=0;i<n;i++) {
            int min = Integer.parseInt(st.nextToken());
            lesson[i] = min;
            if (min > max) {
                max = min;
            }
            sum += min;
        }
        int s = max;
        int e = sum;

        while (s <= e) {
            int mid = (s+e)/2;
            int count =0;
            int temp = 0;
            for (int i=0;i<n;i++) {
                if (temp+lesson[i] > mid) {
                    count++;
                    temp = 0;
                }
                temp += lesson[i];
            }
            if (temp != 0) {
                count++;
            }
            if (count <= m) {
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        System.out.println(s);


    }
}
