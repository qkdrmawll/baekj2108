import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Beak2108 { //통계학

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        for(int i=0;i<N;i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(nums);


        System.out.println(mean(nums));
        System.out.println(median(nums));
        System.out.println(mode(nums));
        System.out.println(range(nums));


    }

    public static int mean(int[] nums){
        double sum=0;
        for(int num : nums){
            sum+=num;
        }
        return (int)Math.round(sum/ nums.length);
    }
    public static int median(int[] nums){
        return nums[nums.length/2];
    }
    public static int mode(int[] nums){
        int cnt[] = new int[8001];
        ArrayList<Integer> arrayList = new ArrayList<>();
        int max=0;
        for (int num:nums){
            if(num<0){
                cnt[Math.abs(num)+4000]++;
            }else cnt[num]++;
        }

        for(int i=0; i<cnt.length; i++){
            if(cnt[i]>max){
                max = cnt[i];
            }
        }
        for(int i=0; i<cnt.length; i++){
            if(cnt[i]==max){
                if(i>4000){
                    arrayList.add((i-4000)*(-1));
                }else arrayList.add(i);
            }
        }
        Collections.sort(arrayList);
        if(arrayList.size()>1) return arrayList.get(1);
        else return arrayList.get(0);
    }

    public static int range(int nums[]){
        return nums[nums.length-1] - nums[0];
    }

}
