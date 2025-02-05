import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1213 { //팰린드롬 만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Map<Character,Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (char c : line.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        Deque<Character> deque = new ArrayDeque<>();
        boolean flag = false;
        for (Character c : map.keySet()) {
            if (map.get(c)%2!=0) {
                if (flag) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                flag = true;
                deque.add(c);
                map.put(c,map.get(c)-1);
            }
        }
        for (Character c : map.keySet()) {
            while (map.get(c) > 1) {
                deque.addFirst(c);
                deque.addLast(c);
                map.put(c,map.get(c)-2);
            }
        }
        for (Character c : deque) {
            System.out.print(c);
        }

    }
}