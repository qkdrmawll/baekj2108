import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1018 { //체스판 다시 칠하기
    static char[][] chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        chess = new char[N][M];
        int min = Integer.MAX_VALUE;
        for (int i=0;i<N;i++) {
            String line = br.readLine();
            for (int j=0;j<M;j++) {
                chess[i][j] = line.charAt(j);
            }
        }
        for (int i=0;i<=N-8;i++) {
            for (int j=0;j<=M-8;j++) {
                int cnt = check(i,j);
                if (cnt<min) min = cnt;
            }
        }
        System.out.println(min);
    }

    private static int check(int startrow, int startcol) {
        String[] line = {"WBWBWBWB", "BWBWBWBW"};
        int count = 0;
        for (int i=0;i<8;i++) {
            int row = startrow + i;
            for (int j=0;j<8;j++) {
                int col = startcol + j;
                if(chess[row][col] != line[i%2].charAt(j)) {
                    count++;
                }
            }
        }
        return Math.min(count,64-count);
    }
}
