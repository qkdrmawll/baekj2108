import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1717 { // 집합의 표현
    //유니온 파인드 알고리즘 대표 문제
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new int[n+1];
        for (int i=1;i<=n;i++) {
            A[i] = i;
        }

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (order == 0) {
                union(a,b);
            }else {
                if (find(a)==find(b)) {
                    System.out.println("YES");
                }else System.out.println("NO");
            }
        }
    }
    static void union(int a, int b) {
        int Arepresent = find(a);
        int Brepresent = find(b);
        A[Brepresent] = A[Arepresent];
    }
    static int find(int a) {
        if (a == A[a]) {
            return a;
        }else {
            return A[a] = find(A[a]);
        }
    }
}
