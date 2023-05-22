import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek9012 { //괄호
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i =0; i<T;i++){
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();

            for (int j=0;j<line.length();j++) {
                char c = line.charAt(j);
                if (c == '(') {
                    stack.push(c);
                } else {
                    int size = stack.size();
                    if (size == 0) {
                        stack.push(c);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(stack.empty()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
            stack.clear();
        }
        System.out.println(sb);
    }
}
