import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10986 {// 나머지 합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수열의 개수
        int m = Integer.parseInt(st.nextToken()); // 나누어 떨어져야 하는 수
        long[] s = new long[n]; // 합 배열
        long[] count = new long[m]; // 같은 나머지 인덱스를 카운트하는 배열
        long result = 0;

        st = new StringTokenizer(br.readLine());
        s[0] = Integer.parseInt(st.nextToken());
        for (int i=1;i<n;i++) {
            s[i] += s[i-1] + Integer.parseInt(st.nextToken());
        }
        /*
        구간의 합이 M으로 나눠지는 특정 구간을 구하는 것으로
        (S[j] - S[i]) % M = 0 를 만족하는 i,j의 개수를 구하는 것임
        (S[j] - S[i]) % M = (S[j] % M - S[i] % M) %M 이므로
        S[j]%M - S[i]%M = 0이거나
        S[j]%M - S[i]%M 이 M이어야 하는데 후자는 가능한 경우가 없으므로
        S[j]%M = S[i]%M인 경우를 찾는다
         */
        for (int i=0;i<n;i++) {
            int remainder = (int) (s[i] % m); //구간의 개수를 구하는 것이기 때문에 인덱스는 필요없어서 따로 배열을 만들지 않음
            if (remainder == 0) {
                result++;
            }
            count[remainder]++; // 나머지가 같은 인덱스의 개수 카운팅하기

        }
        for (int i=0;i<m;i++) {
            long c = count[i];
            if (c > 1) {
                result += c * (c-1) /2; //S[i]%M이 같은 원소 2개를 뽑는 경우의 수를 구함
            }
        }
        System.out.println(result);
    }
}
