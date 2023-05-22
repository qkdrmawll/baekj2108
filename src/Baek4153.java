import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek4153 { //직각삼각형
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        long[] length = new long[3];
        for (int i = 0;i<3;i++){
            length[i] = Integer.parseInt(st.nextToken());
        }
        while(length[0]>0) {
            Arrays.sort(length);
            if(length[2]*length[2]==length[0]*length[0]+length[1]*length[1]){
                sb.append("right").append("\n");
            }
            else sb.append("wrong").append("\n");

            st = new StringTokenizer(br.readLine());
            for (int i = 0;i<3;i++){
                length[i] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(sb);
    }
}
