package classic;

import java.util.*;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
  private static final long serialVersionUID = 1L;
  protected int maxElements;

  public LRUCache(int maxSize) {
    super(maxSize, 0.75F, true);
    this.maxElements = maxSize;
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
    return (size() > this.maxElements);
  }

  public static void main(String[] args) {
//    LRUCache<Integer, String> lru = new LRUCache<Integer, String>(4);
//    lru.put(1, "today");
//    lru.put(2, "is");
//    lru.put(3, "a");
//    lru.put(4, "nice");
//    lru.put(5, "day");
//    String r3 = lru.get(3);
//    String r2 = lru.get(2);
//    System.out.println(r3);
//    System.out.println(r2);
//    lru.put(6,"yes");
//    String s4 = lru.get(4);
//    System.out.println(s4);
//
//    System.out.println(lru.keySet());

    Map<String, String> hashMap = new LinkedHashMap<>();
    hashMap.put("name1", "josan1");
    hashMap.put("name2", "josan2");
    hashMap.put("name3", "josan3");
    hashMap.put("n1", "josan1");
    hashMap.put("n2", "josan2");
    hashMap.put("name3", "josan4");

    System.out.println(hashMap.keySet());
  }
}
