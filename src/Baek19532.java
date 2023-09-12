import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek19532 { //수학은 비대면강의입니다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<6;i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=-999;i<1000;i++) {
            for (int j=-999;j<1000;j++) {
                if (num[0] * i +num[1] *j == num[2]
                && num[3] * i + num[4] * j ==num[5])
                    System.out.println(i+ " "+ j);
            }
        }
    }
}
