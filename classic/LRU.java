package classic;

import java.util.HashMap;

public class LRU<K, V> {

  private class Node<K, V> {
    Node<K, V> before;
    Node<K, V> after;
    K key;
    V value;
  }

  private Integer capacity;
  private Integer size;
  private Node<K, V> head;
  private HashMap<K, Node<K, V>> caches = new HashMap<>();

  public LRU(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    Node<K, V> node = new Node<K, V>();
    node.before = node;
    node.after = node;
    head = node;
  }

  public V get(K key) {
    final Node<K, V> node = caches.get(key);
    if (node != null) {
      afterNodeAccess(node);
      return node.value;
    }
    else return null;
  }

  public boolean put(K key, V value) {
    Node<K, V> node = new Node<K, V>();
    node.key = key;
    node.value = value;
    node.before = null;
    node.after = null;
    caches.put(key, node);
    insertIntoDoubleLinkedList(node);

    if (this.size < this.capacity) {
      this.size += 1;
    } else {
      Node<K, V> lru = deleteFromDoubleLinkedList();
      if (lru!= null) caches.remove(lru.key);
      else return false;
    }

    return true;
  }

  private void insertIntoDoubleLinkedList(Node<K, V> node) {
    node.after = head;
    node.before = head.before;
    head.before.after = node;
    head.before = node;
  }

  private void deleteFromDoubleLinkedList(Node<K, V> node) {
    node.before.after = node.after;
    node.after.before = node.before;
  }

  private Node<K, V> deleteFromDoubleLinkedList() {
    if (this.head == null || this.head.after == null) return null;
    Node<K, V> node = this.head.after;
    this.head.after = node.after;
    if (node.after != null) node.after.before = this.head;
    return node;
  }

  private void afterNodeAccess(Node<K, V> node) {
    // adjust double linked list
    deleteFromDoubleLinkedList(node);
    insertIntoDoubleLinkedList(node);
  }

  public static void main(String[] args) {
    LRU<Integer, String> lru = new LRU<Integer, String>(4);
    lru.put(1, "today");
    lru.put(2, "is");
    lru.put(3, "a");
    lru.put(4, "nice");
    lru.put(5, "day");
    String r3 = lru.get(3);
    String r2 = lru.get(2);
    System.out.println(r3);
    System.out.println(r2);
    lru.put(6,"yes");
  }

}
