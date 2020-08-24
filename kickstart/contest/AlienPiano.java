package kickstart.contest;

import java.util.Scanner;

public class AlienPiano {

  private static int minValue(int a, int b, int c, int d) {
    int m = Math.min(a, b);
    int n = Math.min(c, d);
    return Math.min(m, n);
  }

  public static int solve(Scanner s) {
    int n = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = s.nextInt();
    if (n < 5) return 0;

    int[][] dp = new int[n][4];
    for (int i = 0; i < 4; i++) dp[0][i] = 0;
    for (int i = 1; i < n; i++) {
      if (arr[i] == arr[i-1]) System.arraycopy(dp[i - 1], 0, dp[i], 0, 4);
      else if (arr[i] < arr[i-1]) {
        dp[i][0] = minValue(dp[i-1][0] + 1, dp[i-1][1], dp[i-1][2], dp[i-1][3]);
        dp[i][1] = minValue(dp[i-1][0] + 1, dp[i-1][1] + 1, dp[i-1][2], dp[i-1][3]);
        dp[i][2] = minValue(dp[i-1][0] + 1, dp[i-1][1] + 1, dp[i-1][2] + 1, dp[i-1][3]);
        dp[i][3] = minValue(dp[i-1][0] + 1, dp[i-1][1] + 1, dp[i-1][2] + 1, dp[i-1][3] + 1);
      } else {
        dp[i][0] = minValue(dp[i-1][0] + 1, dp[i-1][1] + 1, dp[i-1][2] + 1, dp[i-1][3] + 1);
        dp[i][1] = minValue(dp[i-1][0], dp[i-1][1] + 1, dp[i-1][2] + 1, dp[i-1][3] + 1);
        dp[i][2] = minValue(dp[i-1][0], dp[i-1][1], dp[i-1][2] + 1, dp[i-1][3] + 1);
        dp[i][3] = minValue(dp[i-1][0], dp[i-1][1], dp[i-1][2], dp[i-1][3] + 1);
      }
    }

    return minValue(dp[n-1][0], dp[n-1][1], dp[n-1][2], dp[n-1][3]);
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int i = 1; i <= T; i++) {
      int ans = AlienPiano.solve(s);
      System.out.println(String.format("Case #%d: %d", i, ans));
    }
  }
}
