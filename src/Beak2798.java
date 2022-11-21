import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak2798 { //블랙잭
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result=0;

        st = new StringTokenizer(br.readLine());
        int arr[] = new int[N];
        for (int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int sum=0,min=300000;

        for (int i=0;i<N-2;i++){
            for (int j=i+1;j<N-1;j++){
                for (int k=j+1;k<N;k++){
                    sum = arr[i]+arr[j]+arr[k];
                    if (min>M-sum&&(M-sum)>=0){
                        min = M - sum;
                        result = sum;
                    }

                }
            }
        }
        System.out.println(result);

    }
}
