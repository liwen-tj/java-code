package designPattern.singleton;

public class HungryPattern {
  private static final HungryPattern uniqueInstance = new HungryPattern();

  private HungryPattern() { }

  public static HungryPattern getInstance() {
    return uniqueInstance;
  }

}
