import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek1927 { //최소 힙
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<N; i++) {
            int in = Integer.parseInt(br.readLine());
            if (in==0) {
                if (pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            } else {
                pq.add(in);
            }
        }
    }
}
