import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2252 { // 줄세우기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 학생 수
        int m = Integer.parseInt(st.nextToken()); // 키를 비교한 횟수
        int[] D = new int[n+1];
        Queue<Integer> queue = new ArrayDeque<>();

        ArrayList<Integer>[] A = new ArrayList[n+1];
        for (int i=1;i<=n;i++) {
            A[i] = new ArrayList<>();
        }


        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 앞에 설 학생
            int b = Integer.parseInt(st.nextToken()); // 뒤에 설 학생

            A[a].add(b);
            D[b]++;
        }

        while (queue.size()<n) {
            for (int i=1;i<=n;i++) {
                if (D[i]==0) {
                    queue.add(i);
                    D[i] = -1;
                    for (int j : A[i]) {
                        D[j]--;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }


    }
}
