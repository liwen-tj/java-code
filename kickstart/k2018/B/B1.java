package kickstart.k2018.B;

import java.util.Scanner;

public class B1 {

  // 这道题目如果用Math.pow会有精度问题，造成大数据集的溢出
  private static long powLong(long base, int n) {
    long ans = 1;
    for (int i = 0; i < n; i++) ans *= base;
    return ans;
  }

  public static long utils(long n) {
    long[] nums = new long[19];
    int length = 0;
    long N = n;
    while(n > 0L) {
      nums[length++] = n % 10L;
      n /= 10L;
    }
    long ans = 0;
    for (int i = 1; i < length; i++) ans += nums[i] * powLong(9L, i - 1) * 8L;
    for (long i = N - N % 10L; i <= N; i++) {
      if (i % 9L != 0L) ans = ans + 1L;
    }
    return ans;
  }

  public static long solve(Scanner s) {
    long ff = s.nextLong();
    long ll = s.nextLong();
    return utils(ll) - utils(ff) + 1;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int i = 1; i <= T; i++) {
      long ans = B1.solve(s);
      System.out.println(String.format("Case #%d: %d", i, ans));
    }
  }
}
