package kickstart.k2020;

import java.util.Scanner;

/**
 * 这个题目要注意d的范围，使用int会溢出，需要使用long
 * java:
 * Integer.MAX_VALUE: 2147483647 (2 * 10^9)
 * Long.MAX_VALUE: 9223372036854775807 (2 * 10^18)
 */
public class BB2020BusRoute {

  public static boolean check(long k, long[] arr, long d) {
    for (long value : arr) {
      long m = k % value;
      if (m != 0) {
        k += (value - m);
      }
    }
    return k <= d;
  }

  public static long solve(Scanner s) {
    int n = s.nextInt();
    long d = s.nextLong();
    long[] arr = new long[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextLong();
    }

    long low = 0;
    long high = d;
    while (low < high) {
      long mid = (low + high + 1) / 2;
      if (check(mid, arr, d)) low = mid;
      else high = mid - 1;
    }

    return low;
  }


  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int i = 1; i <= T; i++) {
      long ans = BB2020BusRoute.solve(s);
      System.out.println(String.format("Case #%d: %d", i, ans));
    }
  }
}

