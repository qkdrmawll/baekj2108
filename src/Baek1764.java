import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1764 { //듣보잡
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> nhs = new HashSet<>();
        for (int i=0;i<N;i++) {
            nhs.add(br.readLine());
        }
        HashSet<String> mhs = new HashSet<>();
        for (int i=0;i<M;i++) {
            mhs.add(br.readLine());
        }
        nhs.retainAll(mhs);
        ArrayList<String> list = new ArrayList<>(nhs);
        Collections.sort(list);
        System.out.println(list.size());
        for (int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
    }
}
