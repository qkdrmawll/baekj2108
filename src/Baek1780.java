import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1780 { //종이의 개수
    static int[][] arr;
    static int[] count = {0,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0,0,N);
        for (int i=0;i<3;i++) {
            System.out.println(count[i]);
        }
    }

    public static void partition(int row,int col,int size) {
        if(check(row,col,size)==1) {
            int temp = arr[row][col];
            count[temp+1]++;
            return;
        }
        int newsize = size/3;
        partition(row, col, newsize);
        partition(row, col+newsize, newsize);
        partition(row, col+newsize*2, newsize);
        partition(row+newsize, col, newsize);
        partition(row+newsize, col+newsize, newsize);
        partition(row+newsize, col+newsize*2, newsize);
        partition(row+newsize*2, col, newsize);
        partition(row+newsize*2, col+newsize, newsize);
        partition(row+newsize*2, col+newsize*2, newsize);
    }

    private static int check(int row, int col, int size) {
        int temp = arr[row][col];
        for (int i=row;i<row+size;i++) {
            for (int j=col;j<col+size;j++) {
                if (arr[i][j]!=temp) return 0;
            }
        }
        return 1;
    }
}
