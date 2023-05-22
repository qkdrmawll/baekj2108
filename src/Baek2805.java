import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2805 { //나무 자르기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max=0;
        int high,low,mid;

        st = new StringTokenizer(br.readLine());
        int[] trees = new int[N];
        for (int i=0;i<N;i++){
            trees[i] = Integer.parseInt(st.nextToken());
            if(trees[i]>max) max = trees[i];
        }
        high =max;
        low =0;
        while (high>=low) {

            mid = (high + low) / 2;
            long sum = 0;
            for (int i = 0; i < trees.length; i++) {
                if (trees[i] > mid) sum += trees[i] - mid;
            }
            if(sum>M) low = mid+1;
            else if (sum<M) high = mid-1;
            else if (sum == M) {
                high = mid;
                break;
            }
        }
        System.out.println(high);
    }
}
