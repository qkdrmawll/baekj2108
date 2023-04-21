import java.util.Arrays;
import java.util.Scanner;

public class Beak1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        int M = sc.nextInt();
        int[] nums = new int[M];
        for(int i=0;i<M;i++){
            nums[i] = sc.nextInt();
        }
        for (int i=0;i<M;i++){
            System.out.println(binarySearch(A,nums[i]));
        }
    }

    public static int binarySearch(int arr[],int num){
        int low = 0;
        int high =arr.length-1;
        int mid =0;

        while (low<=high){
            mid = (low+high)/2;
            if(arr[mid] == num){
                return 1;
            } else if (arr[mid]<num) {
                low = mid+1;
            } else if (arr[mid]>num) {
                high = mid-1;
            }
        }
        return 0;
    }
}