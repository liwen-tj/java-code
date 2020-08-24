package dynamic_programmming;

import java.util.Arrays;
import java.util.Scanner;

public class MinimizingCoins {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int x = s.nextInt();
    int[] arr = new int[n];
    int[] dp = new int[1000001];
    Arrays.fill(dp, -1);
    for(int i = 0; i < n; ++i) {
      arr[i] = s.nextInt();
      dp[arr[i]] = 1;
    }

    for (int i = 1; i <= x; ++i) {
      for (int j = 0; j < n; j++) {
        if (i > arr[j] && dp[i-arr[j]] > 0) {
          if (dp[i] > 0) dp[i] = Math.min(dp[i], dp[i-arr[j]]+1);
          else {
            dp[i] = dp[i-arr[j]] + 1;
          }
        }
      }
    }

    System.out.println(dp[x]);
  }
}
