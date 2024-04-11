import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1389 { // 케빈 베이컨의 6단계 법칙
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 유저의 수
        int m = Integer.parseInt(st.nextToken()); // 친구 관계의 수
        int[][] friends = new int[n+1][n+1];

        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                if (i==j) {
                    friends[i][j] = 0;
                }else {
                    friends[i][j] =  1000000;
                }
            }
        }
        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a][b] = 1;
            friends[b][a] = 1;
        }

        for (int k=1;k<=n;k++) {
            for (int i=1;i<=n;i++) {
                for (int j=1;j<=n;j++) {
                    friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
                }
            }
        }
        int[] sum = new int[n+1];
        sum[0] = 100000;
        int min = 100000;
        int minIdx = 0;
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                sum[i]+= friends[i][j];
            }
            if (min > sum[i]) {
                min = sum[i];
                minIdx = i;
            }
        }
        System.out.println(minIdx);

    }
}
