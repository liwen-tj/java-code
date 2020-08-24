package kickstart.k2020;

import java.util.*;

public class Solution {

  public static void solve(int T, Scanner s) {
    int n = s.nextInt();
    int q = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int ans = 0;
    for (int i = 0; i < q; i++) {
      String type = s.next();
      int x = s.nextInt();
      int y = s.nextInt();
      if (type.equals("Q")) {
        int tt = 1;
        int sign = 1;
        for (int j = x - 1; j < y; j++) {
          ans += tt * sign * arr[j];
          tt += 1;
          sign *= -1;
        }

      } else {
        arr[x-1] = y;
      }
    }

    System.out.println(String.format("Case #%d: %d", T, ans));
  }


  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int i = 1; i <= T; i++) {
      Solution.solve(i, s);
    }
  }
}
