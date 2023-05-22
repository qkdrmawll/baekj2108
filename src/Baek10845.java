import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek10845 { //큐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue queue = new LinkedList();
        int last=0;
        for (int i=0;i<N;i++) {
            String str = br.readLine();
            String[] arr = str.split(" ");

            switch (arr[0]) {
                case "push":
                    queue.offer(Integer.parseInt(arr[1]));
                    last = Integer.parseInt(arr[1]);
                    break;
                case "pop":
                    if (!queue.isEmpty()) {
                        sb.append(queue.poll()).append("\n");
                    }else sb.append(-1).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if (!queue.isEmpty()) sb.append(queue.peek()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "back":
                    if (queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(last).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
