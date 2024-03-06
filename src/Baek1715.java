import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek1715 { // 카드 정렬하기
    // 현재 데이터 중 가장 작은 카드 2개를 뽑아 2개를 합친 새 카드 묶음을 다시 데이터에 넣고 정렬해야 한다.
    // 데이터의 삭제, 삽입, 정렬이 자주 일어난다 -> 우선순위 큐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        for (int i=0;i<n;i++) {
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
        }
        // 자동 정렬에 따라 큐에서 poll만 하면 작은 카드 묶음 2개를 얻을 수 있음
        // 계속 최솟깂이 필요한 경우 PriorityQueue 사용
        while (pq.size()>1){
            int out1 = pq.poll();
            int out2 = pq.poll();
            int temp = out1 + out2;
            sum += temp;
            pq.add(temp);
        }
        System.out.println(sum);
    }
}
