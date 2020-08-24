package dynamic_programmming;

import java.util.Scanner;

public class RemovalGame {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    long[] arr = new long[n];
    long[] prefix = new long[n];
    for(int i = 0; i < n; ++i) {
      arr[i] = s.nextLong();
      if (i == 0) prefix[i] = arr[i];
      else prefix[i] = prefix[i-1] + arr[i];
    }

    long[][] dp = new long[n][n];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i; j < n; j++) {
        if (j == i) dp[i][j] = arr[i];
        else {
          long xi = arr[i] + prefix[j] - prefix[i] - dp[i+1][j];
          long pi_1 = i == 0 ? 0 : prefix[i - 1];
          long xj = arr[j] + prefix[j - 1] - pi_1 - dp[i][j - 1];
          dp[i][j] = Math.max(xi, xj);
        }
      }
    }
    System.out.println(dp[0][n-1]);
  }
}
