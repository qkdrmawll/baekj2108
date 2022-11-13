import java.util.Scanner;

public class Beak2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int temp;
        int arr[] = new int[6];
        int constructor = 0;

        for(int i=N;i>0;i--){
            temp = N - i;
            arr[0] = temp % 10;
            arr[1] = (temp/10)%10;
            arr[2] = (temp/100)%10;
            arr[3] = (temp/1000)%10;
            arr[4] = (temp/10000)%10;
            arr[5] = (temp/100000)%10;


            if (arr[0]+arr[1]+arr[2]+arr[3]+arr[4]+arr[5]+temp==N){
                constructor = temp;
                break;
            }
        }
        System.out.println(constructor);
    }
}
