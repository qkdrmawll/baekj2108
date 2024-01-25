import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek1715 { // 카드 정렬하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        for (int i=0;i<n;i++) {
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
        }

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
