import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Beak4949 { //균형잡힌 세상
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        while(!line.equals(".")){
            char[] arr = new char[line.length()];
            for (int i = 0;i<line.length();i++){
                arr[i] = line.charAt(i);
            }
            for (int i=0;i<line.length();i++){
                if(arr[i]=='('||arr[i]=='[') {
                    stack.push(arr[i]);
                }
                if (arr[i]==')'){
                    if (stack.empty()) {
                        stack.push(arr[i]);
                        break;
                    }
                    if(stack.peek()=='(') stack.pop();
                    else {
                        stack.push(arr[i]);
                        break;
                    }
                }
                if (arr[i]==']'){
                    if (stack.empty()) {
                        stack.push(arr[i]);
                        break;
                    }
                    if(stack.peek()=='[') stack.pop();
                    else {
                        stack.push(arr[i]);
                        break;
                    }
                }
            }
            if(stack.empty()) sb.append("yes").append("\n");
            else {
                sb.append("no").append("\n");
                stack.clear();
            }
            line = br.readLine();
        }
        System.out.println(sb);
    }
}
