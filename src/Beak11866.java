import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak11866 { //요세푸스 문제 0
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count=0;

        Queue queue = new LinkedList();

        for (int i=0;i<N;i++) {
            queue.add(i+1);
        }

        while (!queue.isEmpty()) {
            if (count==K-1) {
                sb.append(queue.poll()).append(", ");
                count=0;
            }else{
                queue.add(queue.poll());
                count++;
            }
        }

        sb.insert(0,"<");
        sb.replace(sb.length()-2,sb.length(),">");
        System.out.println(sb);
    }
}
