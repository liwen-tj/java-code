package kickstart.k2020;

import java.util.Scanner;

public class BA2020BikeTour {
  public static int solve(Scanner s) {
    int n = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }
    int ans = 0;
    for (int i = 1; i < n - 1; i++) {
      if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) ans++;
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int i = 1; i <= T; i++) {
      int ans = BA2020BikeTour.solve(s);
      System.out.println(String.format("Case #%d: %d", i, ans));
    }
  }
}
