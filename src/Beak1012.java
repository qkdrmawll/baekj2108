import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak1012 { //유기농 배추

    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    static int map[][];
    static boolean visit[][];
    static int nowX, nowY;
    static int N,M,K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T>0) {
            int count = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visit = new boolean[N][M];

            for (int i=0;i<K;i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            for (int i=0;i<N;i++) {
                for (int j=0;j<M;j++) {
                    if (map[i][j]==1 && visit[i][j]==false) {
                        count++;
                        DFS(i,j);
                    }
                }
            }
            sb.append(count).append("\n");
            T--;
        }
        System.out.println(sb);
    }
    static void DFS(int x,int y){
        visit[x][y] = true;

        for (int i=0;i<4;i++) {
            nowX = x + dx[i];
            nowY = y + dy[i];

            if (RangrCheck() && visit[nowX][nowY]==false && map[nowX][nowY]==1){
                DFS(nowX,nowY);
            }
        }
    }

    private static boolean RangrCheck() {
        return (nowX<N && nowY>=0 && nowY<M && nowX>=0);
    }
}
