import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek1021 { //회전하는 큐
    public static void main(String[] args) throws IOException {
        Deque<Integer> que = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int []pos = new int[M];
        int res=0;

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<M;i++) {
            pos[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=0;i<N;i++) {
            que.add(i+1);
        }

        for (int i=0;i<M;i++) {
            int size = que.size();
            int index=0;
            while (que.peek()!=pos[i]) {
                que.addLast(que.poll());
                index++;
            }
            que.poll();
            if (index<(size-index)) res += index;
            else res += size-index;
        }
        System.out.println(res);
    }
}
