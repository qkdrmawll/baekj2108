import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baek11286 { // 절댓값 힙
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);
                if (abs1==abs2) return o1>o2? 1:-1;
                return abs1 - abs2;
            }
        });
        for (int i=0;i<N;i++) {
            int in = Integer.parseInt(br.readLine());
            if (in==0) {
                int out = pq.isEmpty()? 0: pq.poll();
                System.out.println(out);
            } else {
                pq.add(in);
            }
        }
    }
}
