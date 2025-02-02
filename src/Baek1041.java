import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1041 { // 주사위
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[6];
        for (int i=0;i<6;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int m1 = Arrays.stream(nums).min().getAsInt();
        int m2 = getM2(nums);
        int m3 = getM3(nums);


        if (n==1) {
            System.out.println(Arrays.stream(nums).sum()- Arrays.stream(nums).max().getAsInt());
            return;
        }
        long sum = 0;
        sum += m3 * 4;
        sum += m2 * (4*(long)(n-1 + n-2));
        sum += (m1 * ((long)4* (n-2) * (n-1) + (long)(n-2)*(n-2)));
        System.out.println(sum);
    }

    private static int getM2(int[] nums) {
        int min = 101;
        for (int i=0;i< nums.length-1;i++) {
            for (int j=i+1;j< nums.length;j++) {
                if (i+j==5) continue;
                if (nums[i]+nums[j]<min) {
                    min = nums[i]+nums[j];
                }
            }
        }
        return min;
    }

    private static int getM3(int[] nums) {
        int min = 151;
        for (int i=0;i< nums.length-2;i++) {
            for (int j=i+1;j< nums.length-1;j++) {
                if (i+j==5) continue;
                for (int k= j+1;k< nums.length;k++) {
                    if (i+k==5 || j+k==5) continue;
                    if (nums[i]+nums[j]+nums[k]<min) {
                        min = nums[i]+nums[j]+nums[k];
                    }
                }

            }
        }
        return min;
    }
}
/**
 * n=1일때
 * 보여지는 면의 개수
 * 최소 - 5 최대 - 5
 *
 * n=2일때
 * 최소 - 2 최대 -3
 *
 * n=3일때
 * 최소 0 최대 3
 *
 * n=4일때
 * 최소 0 촤대 3
 *
 * n=2 주사위를 2*2*2개 가지고 있다.
 * 이 주사위를 쌓아서 2x2x2 크기의 정육면체를 만든다
 * 3 3 3 3 2 2 2 2
 * 1 2 3 24 12 36
 *
 * n=3 주사위 3*3*3개 가지고 있다.
 * 2 1 2
 * 1 0 1
 * 2 1 2
 * 2 1 2
 * 1 0 1
 * 2 1 2
 * 3 2 3
 * 2 1 2
 * 3 2 3
 */
