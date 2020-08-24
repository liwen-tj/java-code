package kickstart.k2020;

import java.util.Scanner;

public class AB2020Plates {

  public static int solve(Scanner s) {
    int n = s.nextInt();
    int k = s.nextInt();
    int p = s.nextInt();
    int[][] arr = new int[n][k];
    int[][] sum = new int[n][k];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k; j++) {
        arr[i][j] = s.nextInt();
        sum[i][j] = sum[i][Math.max(0, j-1)] + arr[i][j];
      }
    }

    int[] dp = new int[p+1];
    for (int i = 0; i < n; i++) {
      for (int j = p; j > 0; j--) {
        for (int m = 0; m < Math.min(j, k); m++) {
          dp[j] = Math.max(dp[j], dp[j-m-1] + sum[i][m]);
        }
      }
    }

    return dp[p];
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int i = 1; i <= T; i++) {
      int ans = AB2020Plates.solve(s);
      System.out.println(String.format("Case #%d: %d", i, ans));
    }
  }

}
