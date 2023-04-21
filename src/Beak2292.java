import java.util.Scanner;

public class Beak2292 { //벌집
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int i=0;
        int plus=1; // i에 더해주는 수
        while(N>6*i+1){
            i+=plus;
            plus++;
        }
        System.out.println(plus);
    }

}
