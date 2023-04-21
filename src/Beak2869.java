import java.io.*;
import java.util.StringTokenizer;

public class Beak2869 { //달팽이는 올라가고 싶다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int res= (V-A)/(A-B)+1;
        if ((V-A)%(A-B)!=0) res++;

        bw.write(String.valueOf(res));
        bw.close();
    }
}
