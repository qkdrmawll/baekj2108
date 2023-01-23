import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Beak10866 { //덱
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque deque = new LinkedList();

        for (int i=0;i<N;i++) {
            String str = br.readLine();
            String[] arr = str.split(" ");

            switch (arr[0]) {
                case "push_front":
                    deque.offerFirst(Integer.parseInt(arr[1]));
                    break;
                case "push_back":
                    deque.offerLast(Integer.parseInt(arr[1]));
                    break;
                case "pop_front":
                    if (!deque.isEmpty()) {
                        sb.append(deque.pollFirst()).append("\n");
                    }else sb.append(-1).append("\n");
                    break;
                case "pop_back":
                    if (!deque.isEmpty()) {
                        sb.append(deque.pollLast()).append("\n");
                    }else sb.append(-1).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if (!deque.isEmpty()) sb.append(deque.peekFirst()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "back":
                    if (deque.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deque.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
