import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11004 { // K번째 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[]arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(arr,0,n-1,k-1);
        System.out.println(arr[k-1]);
    }

    private static void quickSort(int[] arr, int start, int end, int k) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            if (pivot == k) {
                return;
            } else if (pivot > k) {
                quickSort(arr, 0, pivot-1, k);
            } else {
                quickSort(arr, pivot+1, end, k);
            }
        }
    }

    private static int partition(int[] arr, int start, int end) {
        if (start + 1 == end) {
            if (arr[start] > arr[end]) {
                swap(arr,start, end);
                return end;
            }
        }
        int m = (start + end) /2;
        swap(arr, start, m);
        int pivot = arr[start];
        int i = start + 1;
        int j = end;
        while (i<=j) {
            while (j >= start+1 && pivot < arr[j]) {
                j--;
            }
            while (i <= end && pivot > arr[i]) {
                i++;
            }
            if (i<=j) {
                swap(arr,i++,j--);
            }
        }
        arr[start] = arr[j];
        arr[j] = pivot;
        return j;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
