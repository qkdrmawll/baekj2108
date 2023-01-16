import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak10816 { //숫자카드

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int []nums1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            nums1[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums1);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(key,nums1)-lowerBound(key,nums1)).append(" ");
        }
        System.out.println(sb);
    }
    static int lowerBound(int key,int[] arr){

        int low=0;
        int high=arr.length;

        while (low<high){
            int mid = (low + high)/2;
            if (key<=arr[mid]){
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
    static int upperBound(int key,int[] arr){
        int low=0;
        int high=arr.length;

        while(low<high){
            int mid =(low+high)/2;
            if (key<arr[mid]){
                high=mid;
            }else {
                low=mid+1;
            }
        }
        return low;
    }
}