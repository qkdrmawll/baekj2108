import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek9184 { //신나는 함수 실행
    static int[][][] w = new int[51][51][51];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a==-1 && b==-1&& c==-1) {
                break;
            }
            sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(func(a ,b ,c)).append('\n');
        }
        System.out.println(sb);
    }
    public static int func(int a,int b,int c) {
        if (a<=0 || b<=0 || c<=0) return 1;
        else if (inRange(a,b,c) && w[a][b][c]!=0) return w[a][b][c];
        else if (a>20 || b>20 || c>20){
            return w[20][20][20] = func(20,20,20);
        }else if (a<b && b<c) {
             return w[a][b][c] = func(a, b, c - 1) + func(a, b - 1, c - 1) - func(a,b-1,c);
        }else{
            return w[a][b][c] = func(a-1,b,c)+func(a-1,b-1,c)+func(a-1,b,c-1)-func(a-1,b-1,c-1);
        }
    }
    static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}
