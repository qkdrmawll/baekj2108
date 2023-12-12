import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek11003 {//최솟값 찾기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Node> deque = new LinkedList<>();
        int result[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            int now = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.getLast().value > now) {
                deque.removeLast();
            }
            deque.offer(new Node(i,now));
            if (i-deque.getFirst().index>=L) {
                deque.removeFirst();
            }
            result[i] = deque.getFirst().value;
        }
        for (int i=0;i<N;i++){
            bw.write(result[i] + " ");
        }
        bw.flush();
    }
    static class Node {
        private int index;
        private int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

}
