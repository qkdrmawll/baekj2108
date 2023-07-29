import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baek14425 { //문자열 집합
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> nhs = new HashSet<>();
        for (int i=0;i<N;i++) {
            nhs.add(br.readLine());
        }
        String[] mlist = new String[M];
        for (int i=0;i<M;i++) {
            mlist[i] = br.readLine();
        }
        int count = 0;
        for (int i=0;i<M;i++) {
            if (nhs.contains(mlist[i])) count++;
        }
        System.out.println(count);
    }
}
