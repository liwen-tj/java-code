package dynamic_programmming;

import java.util.Scanner;

public class CoinCombinationsI {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int x = s.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; ++i) arr[i] = s.nextInt();

    long[] dp = new long[x+1];
    dp[0] = 1;
    for (int i = 1; i <= x; i++) {
      for (int j = 0; j < n; j++) {
        if (i >= arr[j] && dp[i-arr[j]] >= 0) dp[i] += dp[i-arr[j]];
      }
      dp[i] %= 1000000007L;
    }
    System.out.println(dp[x]);
  }

}
