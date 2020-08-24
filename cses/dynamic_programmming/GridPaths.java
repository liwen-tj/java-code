package dynamic_programmming;

import java.util.Scanner;

public class GridPaths {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    long[][] ans = new long[n][n];
    for (int i = 0; i < n; i++) {
      String str = s.next();
      for (int j = 0; j < n; j++) {
        char t = str.charAt(j);
        if (t == '.') {
          if (i > 0) ans[i][j] += ans[i-1][j];
          if (j > 0) ans[i][j] += ans[i][j-1];
          if (i == 0 && j == 0) ans[i][j] = 1;
        }
        ans[i][j] %= 1e9 + 7;
      }
    }
    System.out.println(ans[n-1][n-1]);
  }
}
