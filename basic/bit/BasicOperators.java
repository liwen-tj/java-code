package basic.bit;


public class BasicOperators {

  public static void main(String[] args) {
    int x = 5;
    System.out.println(x << 2);
    System.out.println(x >> 1);
    System.out.println(x >>> 2);
    System.out.println("\n");

    int y = -1;
    System.out.println(x << 2);
    System.out.println(x >> 1);
    System.out.println(x >>> 2);

    System.out.println("\n");
    System.out.println(x & y);
    System.out.println(x | y);
    System.out.println(x ^ y);
    System.out.println(~x);
    System.out.println(~y);
    System.out.println(y);
  }
}
