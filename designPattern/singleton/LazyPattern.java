package designPattern.singleton;

/**
 * 所谓 “饿汉方式” 就是说单例实例在第一次被使用时构建
 * 而不是在JVM在加载这个类时就马上创建此唯一的单例实例。
 */
public class LazyPattern {
  private static LazyPattern uniqueInstance;

  private LazyPattern() {}

  // 加入 synchronized 确保线程安全
  public static synchronized LazyPattern getInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new LazyPattern();
    }
    return uniqueInstance;
  }
}
