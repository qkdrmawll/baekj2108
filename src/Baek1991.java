import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1991 { // 트리 순회

    static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new int[2][n+1];
        for (int i=1;i<=n;i++) {
            char[] c = br.readLine().toCharArray();
            int parent = c[0] - 64;
            int left = c[2] - 64;
            int right = c[4] - 64;

            tree[0][parent] = left;
            tree[1][parent] = right;
        }
        preOrder(1);
        System.out.println();
        inOrder(1);
        System.out.println();
        postOrder(1);
    }
    static void preOrder(int n) {
        System.out.print((char) (n + 64));
        if (tree[0][n] > 0) preOrder(tree[0][n]);
        if (tree[1][n] > 0) preOrder(tree[1][n]);
    }
    static void inOrder(int n) {
        if (tree[0][n] > 0) inOrder(tree[0][n]);
        System.out.print((char) (n + 64));
        if (tree[1][n] > 0) inOrder(tree[1][n]);
    }
    static void postOrder(int n) {
        if (tree[0][n] > 0) postOrder(tree[0][n]);
        if (tree[1][n] > 0) postOrder(tree[1][n]);
        System.out.print((char) (n + 64));
    }
}
