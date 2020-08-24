package kickstart.k2018.A;

import java.util.Scanner;

public class A1 {
  public static long getLarge(long[] nums, int length, int odd) {
    long ans = 0;
    long base = 1;
    for (int i = 0; i < length; i++) {
      if (i < odd) ans += 0;
      else if (i == odd) ans += (nums[i] + 1) * base;
      else ans += nums[i] * base;
      base *= 10;
    }
    return ans;
  }

  public static long getSmall(long[] nums, int length, int odd) {
    long ans = 0;
    long base = 1;
    for (int i = 0; i < length; i++) {
      if (i < odd) ans += 8 * base;
      else if (i == odd) ans += (nums[i] - 1) * base;
      else ans += nums[i] * base;
      base *= 10;
    }
    return ans;
  }


  public static long solve(Scanner s) {
    long N = s.nextLong();
    long n = N;
    long[] nums = new long[17];
    int length = 0;
    int odd = -1;
    while (n > 0) {
      long digit = n % 10;
      nums[length] = digit;
      if (digit % 2 == 1) odd = length;
      n /= 10;
      length++;
    }

    if (odd < 0) return 0;
    if (nums[odd] == 9) return N - getSmall(nums, length, odd);
    else return Math.min(N - getSmall(nums, length, odd), getLarge(nums, length, odd) - N);
  }


  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int i = 1; i <= T; i++) {
      long ans = A1.solve(s);
      System.out.println(String.format("Case #%d: %d", i, ans));
    }
  }
}
