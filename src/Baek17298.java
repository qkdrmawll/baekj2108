import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek17298 {//오큰수
    //스택을 사용해 나의 오른쪽에서 가장 왼쪽에 있는 큰 수 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //수열의 크기
        int[] arr = new int[n]; //수열 배열
        int[] res = new int[n]; //오큰수를 담을 결과 배열
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=0;i<n;i++) {
            int now = arr[i]; //스택에 새로 들어갈 현재 값
            //스택이 비어있지 않고 현재 수열이 top인덱스의 값보다 클 경우
            while (!stack.isEmpty() && arr[stack.peek()] < now) {
                res[stack.pop()] = now; // 정답 배열에 현재 값을 오큰수로 저장
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            //스택이 빌 때까지 스택에 남아 있는 index 결과 배열에 -1 저장
            res[stack.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0;i<n;i++) {
            bw.write(res[i]+" ");
        }
        bw.flush();
    }
}
