import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek12891 {//DNA 비밀번호

    static int[] current = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        char[] dna = br.readLine().toCharArray();
        int[] check = new int[4];
        int count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<4;i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=0;i<p;i++) {
            add(dna[i]);
        }

        int start = 0;
        int end = p-1;

        boolean flag = true;
        for (int i=0;i<4;i++) {
            if (current[i] < check[i]) {
                flag = false;
            }
        }
        if (flag) {
            count++;
        }
        end++;
        while (end != s) {
            remove(dna[start]);
            start++;
            add(dna[end]);
            end++;
            flag = true;
            for (int i=0;i<4;i++) {
                if (current[i] < check[i]) {
                    flag = false;
                }
            }
            if (flag) {
                count++;
            }
            /**
             * debug
             */
            System.out.println("start = " + start);
            System.out.println("end = " + end);
            System.out.print("current = ");
            for (int i=0;i<4;i++) {
                System.out.print(current[i]);
            }
            System.out.println();
            System.out.println("\n------------------");
        }
        System.out.println(count);
    }

    private static void add(char c) {
        switch (c) {
            case 'A' :
                current[0]++;
                break;
            case 'C' :
                current[1]++;
                break;
            case 'G' :
                current[2]++;
                break;
            case 'T' :
                current[3]++;
                break;
        }
    }
    private static void remove(char c) {
        switch (c) {
            case 'A' :
                current[0]--;
                break;
            case 'C' :
                current[1]--;
                break;
            case 'G' :
                current[2]--;
                break;
            case 'T' :
                current[3]--;
                break;
        }
    }
}
