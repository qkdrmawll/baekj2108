import java.util.Scanner;

public class Beak2839 { //설탕배달
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int result;
        int count =0;

        while (true){
            if(N==4||N==7){
                result = -1;
                break;
            }
            if (N%5==0){
                count += N/5;
                result = count;
                break;
            }
            else {
                N -=3;
                count++;
            }
        }
        System.out.println(result);

    }
}
