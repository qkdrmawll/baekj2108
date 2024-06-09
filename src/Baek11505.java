import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11505 { // 구간 곱 구하기
    static long[] tree;
    static int MOD;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        MOD = 1000000007;
        int k = 1;
        while (Math.pow(2,k) < N) {
            k++;
        }
        int treeSize = (int) (Math.pow(2,k) * 2);
        int leaf = (int) Math.pow(2,k);
        tree = new long[treeSize];

        Arrays.fill(tree,1);

        for (int i=leaf;i<leaf+N;i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }
        setTree(treeSize-1);
        //printTree(treeSize);

        for (int i=0;i<M+K;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) { // 숫자 변경
                int tempIndex = b+leaf-1;
                changeVal(tempIndex, c);
                printTree(treeSize);
            } else if (a == 2){ // 구간 곱 출력
                int s = b + leaf -1;
                int e = (int) c + leaf -1;
                long mul = getMul(s, e);
                System.out.println(mul);
            }else return;
        }
    }

    private static void changeVal(int index, long c) {
        tree[index] = c;
        while (index > 1) {
            index /= 2;
            tree[index] = tree[index*2] % MOD * tree[index*2+1] % MOD;
        }
    }

    private static long getMul(int s, int e) {
        long mul = 1;
        while (s <= e) {
            if (s % 2 == 1) {
                mul = mul *tree[s] % MOD;
                s++;
            }
            s /= 2;
            if (e % 2 == 0) {
                mul = mul *tree[e] % MOD;
                e--;
            }
            e /= 2;
        }
        return mul;
    }

    private static void printTree(int treeSize) {
        for (int i = 1; i< treeSize; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    private static void setTree(int i) {
        while (i>0) {
            tree[i/2] *= tree[i] % MOD;
            i--;
        }
    }
}
