import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baek1931 { //회의실 배정
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] time = new int[N][2]; // 타임테이블 2차원 배열

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        /**
         * 종료 시간이 같으면 시작 시간이 빠른 순으로 정렬해야 하는 이유
         * (2,2)(0,2)가 있을 때 (0,2)가 먼저 배정되고 (2,2)가 나오면
         * 최근 회의 종료 시간이 2와 다음 회의 시작 시간인 2가 같거나 큰 경우에 해당 하기 때문에
         * 두 회의 모두 배정될 수 있는데
         * (2,2)가 먼저 배정될 경우 (0,2)의 회의 시작 시간이 빠르기 때문에 (2,2)만 배정이 되기 때문
         */
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1]){ // 종료 시간이 같을 때
                    return o1[0] - o2[0];
                }else return o1[1] - o2[1];
            }
        });

        int preEnd = 0; // 최근 회의 종료 시간
        int count=0; // 배정된 회의 개수

        for (int i=0;i<N;i++){

            if (preEnd <= time[i][0]) { // 최근 회의 종료 시간보다 시작 시간이 늦는 경우 = 겹치지 않는 경우
                preEnd = time[i][1]; // 최근 회의 종료 시간 업데이트
                count++;
            }
        }
        System.out.println(count);
    }
}
