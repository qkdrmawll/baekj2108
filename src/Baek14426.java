import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baek14426 { // 접두사 찾기
//     트라이 알고리즘
//    문자를 저장하고 검색하는 효율적인 알고리즘
    static Node root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        root = new Node();
        for (int i=0;i<n;i++) {
            insert(br.readLine());
        }
        for (int i=0;i<m;i++) {
            if (search(br.readLine())) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void insert(String s) {
        Node node = root;
        for (char c : s.toCharArray()) {
            node.childNode.putIfAbsent(c,new Node());
            node = node.childNode.get(c);
        }
        node.isEndOfWord = true;
    }

    static boolean search(String s) {
        Node node = root;
        for (int i=0;i<s.length();i++) {
            node = node.childNode.getOrDefault(s.charAt(i),null);
            if (node == null) {
                return false;
            }
        }
        return true;
    }
    static class Node {
        Map<Character, Node> childNode;
        boolean isEndOfWord;

        public Node() {
            this.childNode = new HashMap<>();
            this.isEndOfWord = false;
        }
    }
}
