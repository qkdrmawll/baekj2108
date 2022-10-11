import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak1966 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfTestcase = Integer.parseInt(br.readLine());
        int[] result = new int[numOfTestcase];

        int N ;
        int M ;



        for(int i=0;i<numOfTestcase;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            Queue<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());


            for(int j=0;j<N;j++) {
                queue.add(new int[] {j, Integer.parseInt(st.nextToken())});
            }

            int count = 0;

            while(!queue.isEmpty()){

                int front[] = queue.poll();
                boolean flag = true;

                for (int q[] : queue){
                    if (q[1]>front[1]){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    count++;
                    if (front[0]==M) break;
                }else {
                    queue.add(front);
                }
            }
            result[i] = count;

        }

        for ( int k : result ){
            System.out.println(k);
        }
    }



}
