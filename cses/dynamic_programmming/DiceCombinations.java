package dynamic_programmming;

import java.util.Scanner;

public class DiceCombinations {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    long[] fn = new long[1000001];
    fn[0] = 1;
    fn[1] = 1;
    fn[2] = 2;
    for (int i = 3; i <= n; i++) {
      fn[i] = 0;
      for (int j = 1; j <= Math.min(6, i); ++j) fn[i] += fn[i-j];
      fn[i] = fn[i] % 1000000007L;
    }

    System.out.println(fn[n]);
  }
}
