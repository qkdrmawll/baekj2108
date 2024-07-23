import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek28018 { //시간이 겹칠까?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] used = new int[1000001];
        int n = Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            used[s] +=1;
            if (e+1 < 1000001)
                used[e+1] -=1;
        }
        for (int i=1;i<used.length;i++) {
            used[i] += used[i-1];
        }
        int q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<q;i++) {
            System.out.println(used[Integer.parseInt(st.nextToken())]);
        }
    }
}

