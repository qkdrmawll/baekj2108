import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak2775 { //부녀회장이 될테야
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int apt[][] = new int[k+1][n];
            for (int i=0;i<n;i++){
                apt[0][i] = i+1;
            }
            for(int i=0;i<=k;i++){
                apt[i][0] = 1;
            }
            for(int i=1;i<=k;i++){
                for(int j=1;j<n;j++){
                    apt[i][j] = apt[i][j-1]+apt[i-1][j];
                }
            }
            sb.append(apt[k][n-1]).append("\n");

        }
        System.out.println(sb);

    }
}
