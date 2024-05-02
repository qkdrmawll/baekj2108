import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10868 { // 최솟값
    // 최솟값을 구하는 범위가 여러개이기 때문에 세그먼트 트리 사용
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k=1;
        while (Math.pow(2,k) < n) {
            k++;
        }
        int treeSize = (int) Math.pow(2,k)*2;
        tree = new long[treeSize];
        int leafStart = (int) Math.pow(2,k);
        for (int i=0;i<n;i++) {
            tree[i+leafStart] = Integer.parseInt(br.readLine());
        }
        for (int i = n+leafStart; i<treeSize; i++) {
            tree[i] = Long.MAX_VALUE;
        }
        setTree(treeSize-1);

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int startIndex = a + leafStart-1;
            int endIndex = b + leafStart-1;
            long min = getMin(startIndex, endIndex);
            System.out.println("min = " + min);
        }
    }

    private static long getMin(int startIndex, int endIndex) {
        long min = Long.MAX_VALUE;
        while (startIndex <= endIndex) {
            if (startIndex % 2 == 1) {
                min = Math.min(min,tree[startIndex]);
                startIndex++;
            }
            startIndex /=2;
            if (endIndex % 2 == 0) {
                min = Math.min(min,tree[endIndex]);
                endIndex--;
            }
            endIndex /=2;
        }
        return min;
    }


    private static void setTree(int i) {
        while (i>0) {
            tree[i/2] = Math.min(tree[i],tree[i-1]);
            i -= 2;
        }
    }
}
