import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1517 { // 버블 소트
    static int[] A;
    static int[] temp;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        A = new int[n];
        temp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(0,n-1);
        System.out.println(result);
    }

    private static void mergeSort(int s, int e) {
        if (e-s < 1) {
            return;
        }
        int m = s + (e-s)/2;
        mergeSort(s,m);
        mergeSort(m+1,e);

        for (int i = s; i<=e; i++) {
            temp[i] = A[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m+1;

        while (index1 <= m && index2 <= e) {
            if (temp[index1] > temp[index2]) {
                A[k] = temp[index2];
                result += index2 - k;
                k++;
                index2++;
            }
            else {
                A[k] = temp[index1];
                k++;
                index1++;
            }
        }
        while (index1 <= m) {
            A[k] = temp[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            A[k] = temp[index2];
            k++;
            index2++;
        }
    }
}
