import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1722 { // 순열의 순서
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long[] factorial = new long[21];
        boolean[] visit = new boolean[21];
        factorial[0] = 1;
        for(int i = 1; i<=20 ;i++) factorial[i] = i*factorial[i-1];


        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        int[] arr = new int[N]; // 순열을 담을 배열

        if (q == 1) { // 소문제 1번 k를 입력 받아 k번째 순열을 출력
            long k = Long.parseLong(st.nextToken());
            for (int i=0; i<N ;i++) { //
                for (int j=1;j<=N;j++) {
                    if (visit[j]) continue;
                    if (factorial[N -i -1] < k) {
                        k-= factorial[N -i -1];
                    } else {
                        arr[i] = j;
                        visit[j] = true;
                        break;
                    }
                }
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+ " ");
            }
        }else { // 소문제 2번 순열을 입력 받아 몇번째 순열인지 출력
            for (int i = 0; i < N ; i++) {
                 arr[i] = Integer.parseInt(st.nextToken());
            }
            long answer = 1; // factorial 을 더해가며 몇번째 순열인지 구하기
            for (int i = 0; i < N ; i++) {
                for (int j = 1; j < arr[i]; j++) {
                    if (visit[j]) continue;
                    answer += factorial[N-i-1];
                }
                visit[arr[i]] = true;
            }
            System.out.println(answer);
        }

    }

}
