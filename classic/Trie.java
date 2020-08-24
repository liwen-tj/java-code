package classic;

import java.util.HashMap;
import java.util.Map;

public class Trie {

  public static class TrieNode {
    public int path; // 表示当前节点所能链接到其他节点的个数
    public int end; // 表示以当前节点为结尾的单词的个数
    public Map<Character, TrieNode> next;

    public TrieNode(){
      path = 0;
      end = 0;
      next = new HashMap<>();
    }
  }

  private TrieNode root;

  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
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
    node.end++;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    if (word == null || word.length() == 0) return false;
    TrieNode node = root;
    char[] words = word.toCharArray();
    for (char w : words) {
      if (!node.next.containsKey(w)) {
        return false;
      }
      node = node.next.get(w);
    }
    if (node.end == 0) return false;
    return true;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    if (prefix == null || prefix.length() == 0) return false;
    TrieNode node = root;
    char[] words = prefix.toCharArray();
    for (char w : words) {
      if (!node.next.containsKey(w)) {
        return false;
      }
      node = node.next.get(w);
    }
    return true;
  }

  public static void main(String[] args) {
    // Your Trie object will be instantiated and called as such:
    Trie obj = new Trie();
    obj.insert("hello");
    boolean param_2 = obj.search("hell");
    boolean param_3 = obj.startsWith("hl");
    System.out.println(param_2);
    System.out.println(param_3);
  }

}