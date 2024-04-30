import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2042 { //구간 합 구하기
    /**
     * 중간중간 배열의 값이 변경되기 때문에 합배열 X
     * -> 세그먼트 트리 자료구조 이용
     */
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int treeSize = 2;
        int k=1;
        while (Math.pow(treeSize,k) < N) {
            k++;
        }
        treeSize = (int) (Math.pow(treeSize,k) * 2);
        tree = new long[treeSize];
        int leafStart = (int) Math.pow(2,k);
        for (int i = 0; i<N; i++) {
            tree[i+leafStart] = Long.parseLong(br.readLine());
        }
        setTree(treeSize-1);
        for (int i=0;i<M+K;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) { // 데이터 업데이트
                int index = b+leafStart-1;
                long diff = c - tree[index];
                while (index > 0) {
                    tree[index] = tree[index] + diff;
                    index/=2;
                }
                //print();
            }else { //구간 합 출력
                partSum(b, leafStart, (int) c);
            }
        }
    }

    private static void print() {
        System.out.println("-------------출력---------------");
        for (int i=1;i< tree.length;i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
        System.out.println("------------------------------");
    }

    private static void partSum(int b, int leafStart, int c) {
        long sum = 0;
        int startIndex = b + leafStart -1;
        int endIndex = c + leafStart -1;
        while (startIndex <= endIndex) {
            if (startIndex % 2 == 1) {
                sum += tree[startIndex];
            }
            if (endIndex % 2 == 0) {
                sum += tree[endIndex];
            }
            startIndex = (startIndex+1)/2;
            endIndex = (endIndex-1)/2;
        }
        System.out.println(sum);
    }

    private static void setTree(int i) {
        while (i != 1) {
            tree[i/2] += tree[i];
            i--;
        }
    }
}
