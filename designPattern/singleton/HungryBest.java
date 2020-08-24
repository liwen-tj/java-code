package designPattern.singleton;

// 最好的方式（枚举方式）
// 它不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
public enum HungryBest {

  INSTANCE;

  public void doSomeThing() {
    System.out.println(Math.min(1,2));
    Runtime.getRuntime();
  }

  public static void main(String[] args) {
    HungryBest singleton = HungryBest.INSTANCE;
    singleton.doSomeThing();
  }

}
