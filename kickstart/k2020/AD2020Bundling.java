package kickstart.k2020;

import java.util.*;

public class AD2020Bundling {

  public static class TrieNode {
    public int path;
    public Map<Character, TrieNode> next;

    public TrieNode(){
      path = 0;
      next = new HashMap<>();
    }
  }

  public static void insert(String word, TrieNode root) {
    if (word == null || word.length() == 0) return;
    TrieNode node = root;
    char[] words = word.toCharArray();
    for (char w : words) {
      if (!node.next.containsKey(w)) {
        node.next.put(w, new TrieNode());
      }
      node = node.next.get(w);
      node.path++;
    }
  }

  public static int solve(Scanner s) {
    TrieNode root = new TrieNode();
    int n = s.nextInt();
    int k = s.nextInt();
    for (int i = 0; i < n; i++) {
      insert(s.next(), root);
    }

    int ans = 0;
    Queue<TrieNode> queue = new LinkedList<>();
    for (Character c : root.next.keySet()) {
      queue.add(root.next.get(c));
    }

    while(!queue.isEmpty()) {
      TrieNode node = queue.poll();
      ans += node.path / k;
      for (Character c : node.next.keySet()) {
        queue.add(node.next.get(c));
      }
    }

    return ans;
  }


  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int i = 1; i <= T; i++) {
      int ans = AD2020Bundling.solve(s);
      System.out.println(String.format("Case #%d: %d", i, ans));
    }
  }
}
