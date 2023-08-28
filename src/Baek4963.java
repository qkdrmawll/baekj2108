import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek4963 { //섬의 개수
    static int[] dx = {-1,0,1,-1,1,-1,0,1};
    static int[] dy = {-1,-1,-1,0,0,1,1,1};
    static int[][] net;
    static int w;
    static int h;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w==0 && h==0) break;
            int count = 0;
            net = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    net[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (net[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    public static void dfs(int col, int row) {
        visited[col][row] = true;
        for (int i = 0; i < 8; i++) {
            int nCol = col + dx[i];
            int nRow = row + dy[i];
            if (nCol>=0 && nCol<h && nRow>=0 && nRow<w) {
               if (net[nCol][nRow]==1&&!visited[nCol][nRow]) {
                   dfs(nCol,nRow);
               }
            }
        }
    }
}
