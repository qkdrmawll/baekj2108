import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baek2346 { //풍선 터뜨리기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>(); //new LinkedList<>() 이건 메모리 초과
        int[] paper = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            paper[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=1; i<n; i++) {
            deque.add(new int[] {i+1,paper[i]});
        }
        int move = paper[0];
        sb.append("1 ");
        while (!deque.isEmpty()) {
            if (move>0) {
                for (int i=0;i<move-1;i++) {
                    deque.addLast(deque.pollFirst());
                }
                int[] next = deque.pollFirst();
                move = next[1];
                sb.append(next[0]).append(" ");
            }else {
                for (int i=0;i<-move;i++) {
                    deque.addFirst(deque.pollLast());
                }
                int[] next = deque.pollFirst();
                move = next[1];
                sb.append(next[0]).append(" ");
            }
        }
        System.out.println(sb);
    }
}
