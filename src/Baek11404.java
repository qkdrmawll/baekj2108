import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11404 { // 플루이드
    //플루이드-워셜 대표문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수
        long[][] costArr = new long[n+1][n+1];


        //출발도시, 도착도시가 같은 경우 0으로 초기화
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                if (i==j) {
                    costArr[i][i] = 0;
                }
                else costArr[i][j] = 10000001;
            }
        }

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 같은 노선이 여러 개 일 수 있기 때문
            if (costArr[s][e] > c) {
                costArr[s][e] = c;
            }
        }

        for (int k=1;k<=n;k++) {
            for (int s=1;s<=n;s++) {
                for (int e=1;e<=n;e++) {
                    if (costArr[s][e] > costArr[s][k] + costArr[k][e]) {
                        costArr[s][e] = costArr[s][k] + costArr[k][e];
                    }
                }
            }
        }

        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                if (costArr[i][j] == 10000001) {
                    System.out.print("0 ");
                }
                else System.out.print(costArr[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
