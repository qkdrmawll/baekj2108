import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1992 { //쿼드트리
    static int [][]arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;
        for (int i=0;i<N;i++) {
            String line = br.readLine();
            for (int j=0;j<N;j++) {
                arr[i][j] = (int)line.charAt(j)-'0';
            }
        }
        partition(0,0,N);

    }
    public static void partition(int row,int col,int size) {
        if (check(row,col,size)==1) {
            System.out.print(arr[row][col]);
            return;
        }
        int newsize = size/2;
        System.out.print("(");

        partition(row, col, newsize);
        partition(row, col + newsize, newsize);
        partition(row + newsize, col, newsize);
        partition(row + newsize, col + newsize, newsize);
        System.out.print(")");
    }
    public static int check(int row,int col,int size) {
        int temp = arr[row][col];
        for (int i=row;i<row+size;i++) {
            for (int j=col;j<col+size;j++){
                if (temp != arr[i][j]) return 0;
            }
        }
        return 1;
    }
}
