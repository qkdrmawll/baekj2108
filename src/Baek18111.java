import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek18111 { //마인크래프트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int max = 0;
        int min = 255;
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j]>max) max = arr[i][j];
                if (arr[i][j]<min) min = arr[i][j];

            }
        }
        int minCount=2147483647;
        int maxFloor = min;
        for (int floor = min;floor<=max;floor++) {
            int count=0;
            int inventory = B;
            Loop:
            for (int i=0;i<N;i++) {
                for (int j=0;j<M;j++) {
                    int gap = floor - arr[i][j];
                    if (count>minCount) break Loop;
                    if (gap>0) {
                        count += gap;
                        inventory -=gap;
                    } else if (gap<0) {
                        count += gap*-2;
                        inventory -=gap;
                    }
                }
            }
            if (count<=minCount && inventory>=0) {
                minCount = count;
                maxFloor = floor;
            }
        }

        System.out.println(minCount + " "+ maxFloor);

    }
}
