package kickstart.contest;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

  private static void printArr(int[] ans, int t) {
    System.out.print(String.format("Case #%d: ", t));
    for (int i = 0; i < ans.length - 1; ++i) {
      System.out.print(ans[i] + " ");
    }
    System.out.println(ans[ans.length-1]);
  }

  private static void printNo(int t) {
    System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
  }

  public static void solve(Scanner s, int t) {
    int n = s.nextInt();
    int a = s.nextInt();
    int b = s.nextInt();
    int c = s.nextInt();

    int[] ans = new int[n];
    if (n == 1) {
      ans[0] = 1;
      printArr(ans, t);
      return;
    } else if (n == 2) {
      if (c == 2) { // ok
        ans[0] = 2;
        ans[1] = 2;
        printArr(ans, t);
      } else if (a == 2) {
        ans[0] = 1;
        ans[1] = 2;
        printArr(ans, t);
      } else if (b == 2) {
        ans[0] = 2;
        ans[1] = 1;
        printArr(ans, t);
      } else {
        printNo(t);
      }
      return;
    }

    if (a - c + b > n) printNo(t);
    else {
      Arrays.fill(ans, 1);
      for (int i = a - c; i < a; ++i) ans[i] = n;
      for (int i = 0; i < b - c; ++i) ans[n-1-i] = 2;
      printArr(ans, t);
    }

  }


  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int i = 1; i <= T; i++) {
      Solution.solve(s, i);
    }
  }
}
