import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11399 { //ATM
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int []time = new int[N];
        int res=0;
        int sum=0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);
        for (int i=0;i<N;i++) {
            sum = sum + time[i];
            res +=sum;
        }
        System.out.println(res);
    }
}
