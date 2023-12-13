import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek17298 {//오큰수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=0;i<n;i++) {
            int now = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] < now) {
                res[stack.pop()] = now;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0;i<n;i++) {
            bw.write(res[i]+" ");
        }
        bw.flush();
    }
}
