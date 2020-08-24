package designPattern.singleton;

/**
 * 懒汉式(双重检查加锁版本)
 */
public class LazyPatternRefine {
  // 注意此处的 volatile 关键字
  private volatile static LazyPatternRefine uniqueInstance;

  private LazyPatternRefine() { }

  public static LazyPatternRefine getInstance() {
    if (uniqueInstance == null) {
      // 进入同步代码块后，再检查一次，如果仍是null，才创建实例
      synchronized (LazyPatternRefine.class) {
        if (uniqueInstance == null) uniqueInstance = new LazyPatternRefine();
      }
    }
    return uniqueInstance;
  }
}
