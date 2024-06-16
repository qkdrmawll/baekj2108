import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2512 { // 예산
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] budget = new int[n];
        for (int i=0;i<n;i++) {
            budget[i] = Integer.parseInt(st.nextToken());
        }
        int totalBudget = Integer.parseInt(br.readLine());

        Arrays.sort(budget);
        int low = 1;
        int high = budget[n-1];
        while (low<=high) {
            int mid = (low+high)/2;
            int sum = 0;
            for (int i : budget) {
                if (i > mid) {
                    sum += mid;
                }else {
                    sum += i;
                }
            }
            if (sum >totalBudget) {
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        System.out.println(high);

    }
}