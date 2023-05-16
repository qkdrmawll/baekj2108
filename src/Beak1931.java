import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Beak1931 { //회의실 배정
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] time = new int[N][2];
        int max=0;

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1]){
                    return o1[0] - o2[0];
                }else return o1[1] - o2[1];
            }
        });

        int preEnd = 0;
        int count=0;

        for (int i=0;i<N;i++){

            if (preEnd <= time[i][0]) {
                preEnd = time[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
