import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1697 { //숨바꼭질

    static int[] check = new int[100001];
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(0);
        } else bfs(n);

    }
    static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        check[num] = 1;
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i=0;i<3;i++) {
                int next;
                if (i==0) {
                    next = temp+1;
                } else if (i==1) {
                    next = temp-1;
                }else {
                    next = temp*2;
                }
                if (next == k) {
                    System.out.println(check[temp]);
                    return;
                }
                if (next>=0 && next< check.length && check[next]==0) {
                    q.add(next);
                    check[next] = check[temp] + 1;
                }
            }
        }
    }
}
