import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baek1269 { //대칭차집합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        HashSet<Integer> aSet = new HashSet<>();
        HashSet<Integer> bSet = new HashSet<>();
        HashSet<Integer> cSet;

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<a;i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<b;i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }
        cSet = (HashSet<Integer>) aSet.clone();
        aSet.removeAll(bSet);
        bSet.removeAll(cSet);
        System.out.println(aSet.size() + bSet.size());
    }
}
