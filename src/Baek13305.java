import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek13305 { //주유소
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] length = new long[N-1];
        long[] price = new long[N];
        long res = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i< N-1;i++) {
            length[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0;i< N;i++) {
            price[i] = Long.parseLong(st.nextToken());
        }
        
        long minPrice = price[0];
        for (int i=0;i<N-1;i++) {
            if (price[i] < minPrice) minPrice = price[i];
            res += minPrice * length[i];
        }
        System.out.println(res);
    }
}
