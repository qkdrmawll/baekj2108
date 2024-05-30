import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWA1860 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int totalMade = 0;
            int current = 0;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //붕켓팅 성공한 n명의 사람
            int m = Integer.parseInt(st.nextToken()); // k개의 붕어빵을 만드는 데에 걸리는 시간
            int k = Integer.parseInt(st.nextToken());
            boolean flag = true;
            st = new StringTokenizer(br.readLine());
            int[] s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(s);
            for (int i = 0; i < n; i++) {
                int seconds = s[i];
                int preMade = totalMade;
                totalMade = (seconds / m) * k; // 붕어빵 생성;
                current += totalMade - preMade;
                if (current > 0) {
                    current--;
                } else {
                    flag = false;
                    break;
                }
                System.out.println("current = " + current);
            }
            if (flag) System.out.println("#" + t + " Possible");
            else System.out.println("#" + t + " Impossible");
        }
    }
}
/**
 *
 * n명만 붕어빵을 살 수 있다
 * m초  k개
 */
