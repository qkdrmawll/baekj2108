import java.io.*;
import java.util.StringTokenizer;

public class Beak1978 { //소수 찾기

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];
        int cnt=0;

        for (int i=0; i<N;i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }

       for(int num : nums){
           if(isPrimeNumber(num)) cnt++;
       }

        System.out.println(cnt);

    }
    public static boolean isPrimeNumber(int num){
        if(num==1) return false;
        int sqrt = (int)Math.sqrt(num);
        for(int i=2; i<=sqrt; i++){
            if((num%i)==0){
                return false;
            }
        }
        return true;
    }
}
