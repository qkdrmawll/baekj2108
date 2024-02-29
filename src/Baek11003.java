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
        int N = Integer.parseInt(st.nextToken()); // 수열
        int L = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우 크기
        Deque<Node> deque = new LinkedList<>(); // 슬라이딩 윈도우 덱
        int[] result = new int[N]; // 최소값을 담을 배열
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            int now = Integer.parseInt(st.nextToken());
            //새로운 값이 들어올 때마다 정렬 대신 현재 수 보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임
            while (!deque.isEmpty() && deque.getLast().value > now) {
                deque.removeLast();
            }
            //새로운 값(=현재 값) 덱에 넣기
            deque.offer(new Node(i,now));
            //범위에서 벗어난 값은 덱에서 제거
            if (i-deque.getFirst().index>=L) {
                deque.removeFirst();
            }
            //맨 앞에 있는 값이 최솟값
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
