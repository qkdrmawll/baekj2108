import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak1107 { //리모컨
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String N_str = String.valueOf(N);
        int N_length = (int)(Math.log10(N)+1);
        int M = Integer.parseInt(br.readLine());
        int[] Xnums = new int[M];
        boolean flag = false;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<M;i++) {
            Xnums[i] = Integer.parseInt(st.nextToken());
        }

        if (N==100) { // 이동하려고 하는 채널 == 현재 채널인 경우
            System.out.println("0");
            return;
        }
        for (int i=0; i<N_length; i++) {
            for (int j=0; j<M; j++) {
                if (N_str.charAt(i)==(char)(Xnums[j])+'0') {
                    flag = true;
                }
            }
        }
        if (flag == false) { // 숫자버튼만으로 이동할 수 있는 경우
            System.out.println(N_length);
        }
        else { //숫자버튼 + '+''-'
            ''
        }


    }
}
