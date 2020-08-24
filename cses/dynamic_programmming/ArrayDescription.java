package dynamic_programmming;

import java.util.Scanner;

public class ArrayDescription {

  public static final Long MOD = 1000000007L;

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int m = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = s.nextInt();

    long[][] dp = new long[n][m+1];
    for (int i = 0; i < n; i++) {
      // arr[i] > 0
      if (arr[i] > 0) {
        if (i == 0) dp[i][arr[i]] = 1;
        else {
          dp[i][arr[i]] = dp[i-1][arr[i]];
          if (arr[i] > 1) dp[i][arr[i]] += dp[i-1][arr[i]-1];
          if (arr[i] < m) dp[i][arr[i]] += dp[i-1][arr[i]+1];
        }
        dp[i][arr[i]] %= MOD;
        continue;
      }
      // arr[i] == 0
      if (i == 0) {
        for (int j = 1; j <= m; j++) dp[0][j] = 1;
        continue;
      }
      for (int j = 1; j <= m; j++) {
        dp[i][j] = dp[i-1][j];
        if (j > 1) dp[i][j] += dp[i-1][j-1];
        if (j < m) dp[i][j] += dp[i-1][j+1];
        dp[i][j] %= MOD;
      }
    }

    long ans = 0;
    for (int i = 1; i <= m; i++) ans = (ans + dp[n-1][i]) % MOD;
    System.out.println(ans);
  }
}
