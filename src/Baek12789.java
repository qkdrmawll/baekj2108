import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek12789 { //도키도키 간식드리미
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int turn = 1;
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Stack line1 = new Stack();
        for (int i=n; i>0; i--) {
            line1.push(nums[i-1]);
        }
        Stack line2 = new Stack();

        while (turn < n) {
            if (!line1.isEmpty() && line1.peek().equals(turn)) {
                line1.pop();
                turn++;
            } else if (!line2.isEmpty() && line2.peek().equals(turn)) {
                line2.pop();
                turn++;
            } else if (line1.isEmpty()) {
                System.out.println("Sad");
                return;
            } else {
                line2.push(line1.pop());
            }
        }
        System.out.println("Nice");

    }
}
