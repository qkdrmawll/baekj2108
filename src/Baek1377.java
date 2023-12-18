import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek1377 { //버블 소트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        myData[] arr = new myData[n];
        for (int i=0;i<n;i++) {
            int v = Integer.parseInt(br.readLine());
            arr[i] = new myData(v,i);
        }
        Arrays.sort(arr);
        int max = 0;
        for (int i=0;i<n;i++) {
            if (max < arr[i].index - i)
                max = arr[i].index -i;
        }
        System.out.println(max+1);
    }
    static class myData implements Comparable<myData>{
        int value;
        int index;

        public myData(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(myData myData) {
            return this.value - myData.value;
        }
    }
}
