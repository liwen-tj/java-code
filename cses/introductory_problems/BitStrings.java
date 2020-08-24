package introductory_problems;

import java.util.Scanner;

public class BitStrings {

  private static final long MOD = 1000000007L;

  public static long fastPower(int x, int n) {
    if (n == 1) return x;
    long m = fastPower(x, n/2);
    if (n % 2 == 0) return m * m % MOD;
    else return (m * m % MOD) * x % MOD;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    long ans = BitStrings.fastPower(2, n);
    System.out.println(ans);
  }
}
