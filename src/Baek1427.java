import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Baek1427 { // 소트인사이드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        Integer[] nums = new Integer[num.length()];
        for (int i=0;i<num.length();i++) {
            nums[i] = num.charAt(i) - 48;
        }
        Arrays.sort(nums,Collections.reverseOrder());
        for (int i:nums) {
            System.out.print(i);
        }
    }
}
