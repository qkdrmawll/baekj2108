import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek9375 { //패션왕 신해빈
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            HashMap<String,Integer> kindMap = new HashMap();
            int n = Integer.parseInt(br.readLine());
            for (int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();
                if (kindMap.containsKey(kind)) {
                    kindMap.put(kind,kindMap.get(kind) + 1);
                }else {
                    kindMap.put(kind,1);
                }
            }
            int res = 1;
            for (int num : kindMap.values()) {
                res *= num+1;
            }
            sb.append(res-1).append("\n");
        }
        System.out.println(sb);
    }
}
