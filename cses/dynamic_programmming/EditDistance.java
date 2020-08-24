package dynamic_programmming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class EditDistance {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String sn = s.next();
    String sm = s.next();
    int n = sn.length();
    int m = sm.length();

    int[][] dp = new int[n+1][m+1];
    for (int i = 0; i <= n; i++) dp[i][0] = i;
    for (int i = 0; i <= m; i++) dp[0][i] = i;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (sn.charAt(i-1) == sm.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
        else dp[i][j] = Collections.min(Arrays.asList(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])) + 1;
      }
    }

    System.out.println(dp[n][m]);
  }
}
