import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Baek18258 { //큐 2
    public static void main(String[] args) throws IOException {
        Deque<Integer> que = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++) {
            String str = br.readLine();
            String[] arr = str.split(" ");

            switch (arr[0]) {
                case "push":
                    que.offer(Integer.parseInt(arr[1]));
                    break;
                case "pop":
                    if (!que.isEmpty()) {
                        sb.append(que.poll()).append("\n");
                    }else sb.append(-1).append("\n");
                    break;
                case "size":
                    sb.append(que.size()).append("\n");
                    break;
                case "empty":
                    if (que.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if (!que.isEmpty()) sb.append(que.peek()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "back":
                    if (que.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(que.peekLast()).append("\n");
                    break;
            }

        }
        System.out.println(sb);

    }
}
