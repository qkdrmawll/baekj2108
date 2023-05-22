import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek2164 { //카드2
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int temp;
        int N = scanner.nextInt();
        for(int i = 0;i<N;i++){
            queue.offer(i+1);
        }
        while(queue.size()>1) {
            queue.poll();
            queue.offer(queue.poll());
        }
        System.out.println(queue.poll());

    }
}
