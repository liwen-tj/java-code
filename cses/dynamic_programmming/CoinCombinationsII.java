package dynamic_programmming;

import java.util.Scanner;

public  class CoinCombinationsII {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int x = s.nextInt();
    int[] c = new int[n];
    for(int i = 0; i < n; ++i) c[i] = s.nextInt();

    long[] dp = new long[x+1];
    dp[0] = 1;
    for (int j = 0; j < n; j++) {
      for (int i = 1; i <= x; i++) {
        if (i >= c[j]) dp[i] = (dp[i] + dp[i-c[j]]) % 1000000007L;
      }
    }

    System.out.println(dp[x]);

  }
}