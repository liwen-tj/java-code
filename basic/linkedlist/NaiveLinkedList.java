package basic.linkedlist;

import java.util.LinkedList;

public class NaiveLinkedList {

  public static void main(String[] args) {
    LinkedList<String> ll = new LinkedList<String>();
    ll.add("a");
    ll.add("b");
    System.out.println(ll.get(0));
    System.out.println(ll.contains("a"));
    System.out.println(ll.indexOf("b"));
    // remove有两种方式
    System.out.println(ll.remove("a"));
    System.out.println(ll.remove(0));
    
  }
}
