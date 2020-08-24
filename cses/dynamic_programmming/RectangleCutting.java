package dynamic_programmming;

import java.util.Scanner;

public class RectangleCutting {

  public static int solve(int[][] ans, int i, int j) {
    if (i == 1) return j - 1;
    if (j == 1) return i - 1;
    int res = Integer.MAX_VALUE;
    for (int k = 1; k <= i / 2; k++) res = Math.min(ans[i-k][j] + ans[k][j] + 1, res);
    for (int k = 1; k <= j / 2; k++) res = Math.min(ans[i][j-k] + ans[i][k] + 1, res);
    return res;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int m = s.nextInt();

    int[][] ans = new int[n+1][m+1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (i == j) ans[i][j] = 0;
        else ans[i][j] = solve(ans, i, j);
      }
    }

    System.out.println(ans[n][m]);
  }
}
