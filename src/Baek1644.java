import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek1644 { //소수의 연속합
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        boolean prime[] = new boolean[N+1];
        prime[0] = prime[1] = true;
        for(int i=2; i*i<=N; i++){
            if(!prime[i]) // 이게 소수가 아니면 이것의 배수도 이미 다 지워진 상태
                for(int j=i*i; j<=N; j+=i){
                    prime[j]=true;
                }
        }
        for(int i=1; i<=N;i++){
            if(!prime[i]) list.add(i);
        }
        int start = 0; //슬라이딩 윈도우의 시작 인덱스
        int end = 0; //슬라이딩 윈도우의 끝 인덱스
        int sum = 0; // 슬라이딩 윈도우 내의 합
        int count = 0;
        while(true) {
            if(sum >= N ) sum -= list.get(start++);
            else if(end == list.size()) break;
            else sum += list.get(end++);
            if(N==sum) {
                count++;
            }
        }
        System.out.println(count);
    }
}
