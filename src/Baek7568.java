import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek7568 { //덩치
    public static void main(String[] args) throws IOException {
        ArrayList<int[]> arrayList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arrayList.add(arr);
        }
        for(int i=0;i<N;i++){
            int k=0;
            for(int j=0;j<N;j++){
                if (arrayList.get(i)[0]<arrayList.get(j)[0]){
                    if (arrayList.get(i)[1]<arrayList.get(j)[1]){
                        k++;
                    }
                }
            }
            sb.append(k+1).append(" ");
        }
        System.out.println(sb);
    }
}
