package kickstart.k2018.A;

import java.util.Arrays;
import java.util.Scanner;

public class A2 {

  private static int findIndex(long[] data, double target) {
    int lo = 0;
    int hi = data.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (data[mid] == target) return mid;
      else if (data[mid] < target) lo = mid + 1;
      else hi = mid - 1;
    }
    if (data[hi] < target) hi++;
    return hi;
  }

  public static double solve(Scanner s) {
    int n = s.nextInt();
    int k = s.nextInt();
    long[] data = new long[n];
    for (int i = 0; i < n; i++) {
      data[i] = s.nextLong();
    }
    if (n == 1) return data[0]; // only one element
    Arrays.sort(data);
    double[] sums = new double[n];
    sums[0] = data[0];
    for (int i = 1; i < n; i++) sums[i] = sums[i-1] + data[i];

    double expect = sums[n-1] / n;
    for (int i = 0; i < k; i++) {
      int id = findIndex(data, expect);
      expect = id * expect / n + (sums[n-1] - sums[id-1]) / n;
    }

    return expect;
  }


  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int i = 1; i <= T; i++) {
      double ans = A2.solve(s);
      System.out.println(String.format("Case #%d: %f", i, ans));
    }
  }
}
