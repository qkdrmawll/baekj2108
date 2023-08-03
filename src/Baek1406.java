import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek1406 { //에디터
    public static void main(String[] args) throws IOException {
        Deque<Character> front = new LinkedList<>();
        Deque<Character> back = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();
        int orderNum = Integer.parseInt(br.readLine());
        for (int i=0;i<line.length();i++) {
            front.add(line.charAt(i));
        }
        StringTokenizer st;
        for (int i=0;i<orderNum;i++){
            st = new StringTokenizer(br.readLine());
            String[] order = new String[2];
            order[0] = st.nextToken();
            switch (order[0]) {
                case "L" :
                    if (!front.isEmpty()) {
                        back.addLast(front.pollLast());
                    }
                    break;
                case "D" :
                    if (!back.isEmpty()) {
                        front.addLast(back.pollLast());
                    }
                    break;
                case "B" :
                    if (!front.isEmpty()) {
                        front.pollLast();
                    }
                    break;
                case "P" :
                    order[1] = st.nextToken();
                    front.addLast(order[1].charAt(0));
                    break;
            }
        }
        while (!front.isEmpty()) sb.append(front.pollFirst());
        while (!back.isEmpty()) sb.append(back.pollLast());
        System.out.println(sb);
    }
}
