import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak10773 { //제로
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int []arr = new int[k];
        int idx=0;
        int sum=0;

        for (int i=0;i<k;i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if (idx!=0){
                    idx--;
                }
            }
            else {
                arr[idx]=num;
                idx++;
            }
        }
        for (int i=0;i<idx;i++){
            sum+=arr[i];
        }
        System.out.println(sum);
    }
}
