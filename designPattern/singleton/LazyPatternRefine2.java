package designPattern.singleton;

/**
 * 懒汉式（登记式/静态内部类方式）
 * 这种方式是 LazyPatternRefine2 类被装载了，uniqueInstance不一定被初始化。
 * 因为SingletonHolder类没有被主动使用，只有显示通过调用getInstance方法时，
 * 才会显示装载SingletonHolder类，从而实例化uniqueInstance。
 */
public class LazyPatternRefine2 {
  private static class SingletonHolder {
    private static final LazyPatternRefine2 uniqueInstance = new LazyPatternRefine2();
  }

  private LazyPatternRefine2() { }

  public static LazyPatternRefine2 getInstance() {
    return SingletonHolder.uniqueInstance;
  }

}
