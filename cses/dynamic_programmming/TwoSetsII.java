package dynamic_programmming;

import java.util.Scanner;

public class TwoSetsII {
  public static int solve(int n) {
    int sum = n * (n + 1) / 2;
    if (sum % 2 != 0) return 0;

    int[] ans = new int[sum+1];
    int prefix = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = prefix; j >= 1; j--) {
        if (ans[j] > 0) ans[j+i] = (ans[j+i] + ans[j]) % 1000000007;
      }
      ans[i] = (ans[i] + 1) % 1000000007;
      prefix += i;
    }

    if (ans[sum / 2] % 2 != 0) ans[sum / 2] += 1000000007;
    return (ans[sum / 2] / 2) % 1000000007;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    System.out.println(solve(n));
  }
}