import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek14940 { //쉬운 최단거리
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        int x =0;
        int y =0;
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j]==2) {
                    x=i;
                    y=j;
                } else if (map[i][j] == 1) {
                    map[i][j] = -1;
                }
            }
        }
        visited[x][y] = true;
        bfs(x,y);
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (map[i][j]>0) System.out.print(map[i][j]-2 + " ");
                else System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void bfs (int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        while (!q.isEmpty()) {
            Point point = q.poll();

            for (int i=0;i<4;i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx<0||ny<0||nx>=n||ny>=m) continue;
                if (map[nx][ny]==-1) {
                    map[nx][ny] = map[point.x][point.y] + 1;
                    q.add(new Point(nx,ny));
                }
            }
        }
    }
    private static class Point{
        public int x,y;
        public Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

}
