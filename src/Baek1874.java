import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek1874 { //스택 수열

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int num = 1;

        for (int i=0;i<N;i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        for (int i=0;i<N;i++) {
            if (stack.isEmpty()) {
                stack.push(num++);
                sb.append("+").append("\n");
            }
            while (nums[i] != stack.peek() && num <= N) {
                stack.push(num++);
                sb.append("+").append("\n");
            }
            if (nums[i] == stack.peek()){
                stack.pop();
                sb.append("-").append("\n");
            }
            else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}
