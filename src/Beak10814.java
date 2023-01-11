import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak10814 { //나이순 정렬
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int numOfMenmber = Integer.parseInt(br.readLine());
        int []ageArr = new int[numOfMenmber];
        String []nameArr = new String[numOfMenmber];

        for(int i=0;i<numOfMenmber;i++){
            st = new StringTokenizer(br.readLine());
            ageArr[i] = Integer.parseInt(st.nextToken());
            nameArr[i] = st.nextToken();
        }

        for (int i=1;i<numOfMenmber;i++){
            int itemp = ageArr[i];
            String stemp = nameArr[i];
            int prev = i-1;
            while (prev >=0 && ageArr[prev]>itemp){
                ageArr[prev+1] = ageArr[prev];
                nameArr[prev+1] = nameArr[prev];
                prev--;
            }
            ageArr[prev+1] = itemp;
            nameArr[prev+1] = stemp;
        }
        for (int i=0;i<numOfMenmber;i++){
            System.out.println(ageArr[i]+" "+nameArr[i]);
        }
    }
}
