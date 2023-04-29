import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beak2667 { //단지번호붙이기
    static int arr[][];
    static boolean visited[][]= new boolean[25][25];
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int N;
    static int[] aparts = new int[25*25];
    static int apartNum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++) {
            String line = br.readLine();
            for(int j=0;j<N;j++) {
                arr[i][j] = line.charAt(j)-'0';
            }
        }
        for (int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if (arr[i][j]==1 && !visited[i][j]) {
                    dfs(i,j);
                    apartNum++;
                }
            }
        }
        Arrays.sort(aparts);
        System.out.println(apartNum);
        for(int i=0; i<aparts.length; i++){
            if (aparts[i]!=0) {
                System.out.println(aparts[i]);
            }
        }

    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        aparts[apartNum]++;

        for (int i=0;i<4;i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if (nx>=0 && ny>=0 && nx <N && ny<N){
                if (arr[nx][ny] ==1 && !visited[nx][ny]) {
                    dfs(nx,ny);
                }
            }
        }
    }

}
