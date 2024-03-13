import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek1043 { // 거짓말
    static int[] present;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 파티의 수

        present = new int[n+1];
        int count = 0;

        for (int i=1;i<=n;i++) {
            present[i] = i;
        }

        //진실을 아는 사람 입력받기
        st = new StringTokenizer(br.readLine());
        int truPeople = Integer.parseInt(st.nextToken());
        int[] truth = new int[truPeople];
        for (int i=0;i<truPeople;i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }
        // 각 파티에 온 사람 저장
        ArrayList<Integer>[] party = new ArrayList[m];
        for (int i=0;i<m;i++){
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int perParty = Integer.parseInt(st.nextToken());
            for (int j=0;j<perParty;j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        // 파티 별로 union
        for (int i=0;i<m;i++){
            int first = party[i].get(0);
            for (int j : party[i]) {
                union(first, j);
            }
        }

        // 과장 vs 진실 판별
        for (int i=0;i<m;i++){
            int first = party[i].get(0);
            boolean flag = true;
            for (int j=0;j<truPeople;j++) {
                if (find(first) == find(truth[j])) {
                    flag = false;
                }
            }
            if (flag) count++;
        }

        System.out.println(count);



    }
    static void union(int a, int b) {
        present[find(b)] = present[find(a)];
    }
    static int find(int a){
        if (a == present[a]) {
            return a;
        }
        return present[a] = find(present[a]);
    }
}
