import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek25305 { // 커트라인
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        int cutline = Integer.parseInt(st.nextToken());
        int[] score = new int[total];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<total;i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(score);
        System.out.println(score[total-cutline]);
    }

}
