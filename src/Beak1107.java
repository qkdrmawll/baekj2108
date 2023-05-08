import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak1107 { //리모컨
    static int N;
    static int M;
    static int[] Xnums;
    static boolean flag = false;
    public static int check(int num) {
        String num_str = String.valueOf(num);
        int num_length = (int)(Math.log10(num)+1);

        for (int i=0; i<num_length; i++) {
            for (int j=0; j<M; j++) {
                if (num_str.charAt(i)==(char)(Xnums[j])+'0') {
                    flag = true;
                }
            }
        }

        if (flag == true) return num_length + Math.abs(N-num);
        else return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int N_length = (int)(Math.log10(N)+1);
        int min = 500000;

        M = Integer.parseInt(br.readLine());
        Xnums = new int[M];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<M;i++) {
            Xnums[i] = Integer.parseInt(st.nextToken());
        }

        if (N==100) { // 이동하려고 하는 채널 == 현재 채널인 경우
            System.out.println("0");
            return;
        }

        check(N);

        if (flag == false) { // 숫자버튼만으로 이동할 수 있는 경우
            System.out.println(N_length);
        }
        else { //숫자버튼 + '+''-'
            for(int i=N;i<=500000;i++){
                flag = false;
                int temp = check(i);
                if (temp!=0 && temp<min) {
                    min = temp;
                }
            }
            for(int i=N;i>=0;i--){
                flag = false;
                int temp = check(i);
                if (temp!=0 && temp<min) {
                    min = temp;
                }
            }

            System.out.println(min);
        }
    }
}
