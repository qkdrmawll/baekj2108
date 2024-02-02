import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Baek1744 { // 수 묶기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int res = 0;
        int cntZero = 0;
        int cntOne = 0;
        for (int i=0;i<n;i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 1) {
                cntOne++;
            } else if (num > 0) {
                plus.add(num);
            } else if (num < 0) {
                minus.add(num);
            }else {
                cntZero++;
            }
        }
        while (plus.size()>1) {
            res += plus.poll() * plus.poll();

        }
        while (minus.size()>1) {
            res += minus.poll() * minus.poll();
        }
        if (!minus.isEmpty()) {
            int temp = minus.poll();
            if (cntZero == 0) {
                res+= temp;
            }
        }
        if (!plus.isEmpty()) {
            res+= plus.poll();
        }
        while (cntOne > 0) {
            res += 1;
            cntOne--;
        }

        System.out.println(res);

    }
}
