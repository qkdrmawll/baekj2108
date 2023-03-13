import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak1926 { //그림

    static int n,m;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx;
    static int[] dy;
    static Queue<Pair> que;


    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];
        que = new LinkedList<>();

        dx = new int[]{1,0,-1,0};
        dy = new int[]{0,1,0,-1};

        for (int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int area = 0;
        int max = 0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (arr[i][j]==0 || visit[i][j]) continue;
                count++;
                que.offer(new Pair(i,j));
                visit[i][j] = true;
                area = 0;
                while(!que.isEmpty()){
                    Pair p = que.poll();
                    area++;
                    for (int k=0;k<4;k++){
                        int nx = p.x + dx[k];
                        int ny = p.y + dy[k];
                        if (nx<0 || nx>=n || ny<0 || ny>=m) continue;
                        if (arr[nx][ny] == 1 && !visit[nx][ny]){
                            que.offer(new Pair(nx,ny));
                            visit[nx][ny] = true;
                        }
                    }
                }
                if (area > max) {
                    max = area;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);


    }

    public static class Pair {
        int x,y;

        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
