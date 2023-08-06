import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek10799 {//쇠막대기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String line = br.readLine();
        int result = 0;
        for (int i=0;i<line.length();i++) {
            char cur = line.charAt(i);
            char pre = '(';
            if (i!=0) pre = line.charAt(i-1);
            if (cur == '(') stack.push(cur);
            else {
                if (pre == '(') {
                    stack.pop();
                    result += stack.size();
                }else {
                    stack.pop();
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}
