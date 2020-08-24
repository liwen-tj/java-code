package basic.queue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriQueue {
  public static void main(String[] args) {
    System.out.println("small:");
    // 默认都是小顶堆
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    queue.add(4);
    queue.add(5);
    queue.add(1);
    queue.add(6);
    queue.add(2);

//    queue.addAll(Arrays.asList(4,5,1,6,2));

//    Integer heap = queue.peek(); // peek方法只是获取数据，并不会拿掉这个元素
//    System.out.println(heap);
//    System.out.println(queue.poll()); // poll获取数据，并拿掉这个元素
//    System.out.println(queue.poll());

//    boolean t = queue.offer(2); // add和offer含义相同，完全一样
    while (!queue.isEmpty()) {
      System.out.println(queue.poll());
    }
    System.out.println("\nbig:");


    // 可以通过自定义comparator方法，实现大顶堆
    PriorityQueue<Integer> big = new PriorityQueue<>(11, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });

    big.add(4);
    big.add(5);
    big.add(1);
    big.add(6);
    big.add(2);

    while (!big.isEmpty()) {
      System.out.println(big.poll());
    }


    System.out.println("\ntest string:");
    PriorityQueue<String> bs = new PriorityQueue<>(11, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareTo(o2);
      }
    });

    bs.add("daily");
    bs.add("bob");
    bs.add("call");
    bs.add("amy");
    while(!bs.isEmpty()) System.out.println(bs.poll());

  }

}
