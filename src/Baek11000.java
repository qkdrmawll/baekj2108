import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek11000 { // 강의실 배정
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] lecture = new int[N][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st;
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            lecture[i][0] = Integer.parseInt(st.nextToken());
            lecture[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(lecture, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        pq.add(lecture[0][1]);
        for (int i=1;i<N;i++) {
            if (pq.peek()<=lecture[i][0]) { //i번째 강의를 하기위해 남는 강의실이 있는지 확인
                pq.poll(); //끝난 강의 빼기
            }
            pq.add(lecture[i][1]); // 강의실이 없는 경우 새 강의실
        }
        System.out.println(pq.size()); // 강의실 수
    }
}
