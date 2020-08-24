package dynamic_programmming;

import java.util.Scanner;

public class RemoveDigits {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int[] dp = new int[n+1];
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      int mx = 0;
      int t = i;
      while (t > 0) {
        mx = Math.max(t % 10, mx);
        t /= 10;
      }
      dp[i] = dp[i - mx] + 1;
    }
    System.out.println(dp[n]);
  }
}
