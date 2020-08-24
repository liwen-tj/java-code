package kickstart.k2020;

import java.util.Arrays;
import java.util.Scanner;

public class AC2020Workout {
  public static int solve(Scanner s) {
    int n = s.nextInt();
    int k = s.nextInt();
    int[] arr = new int[n];
    int[] diff = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
      diff[i] = arr[i] - arr[Math.max(0, i-1)];
    }
    Arrays.sort(diff);

    // binary search
    int low = 1;
    int high = diff[n-1];
    while (low < high) {
      int ans = (high + low) / 2;
      int kk = 0;
      for (int i = n - 1; diff[i] > ans; --i) {
        kk = kk + (diff[i] + ans - 1) / ans - 1;
      }
      if (kk <= k) high = ans; // `high = ans` instead of `ans - 1`
      else low = ans + 1;
    }

    return low;
  }


  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int i = 1; i <= T; i++) {
      int ans = AC2020Workout.solve(s);
      System.out.println(String.format("Case #%d: %d", i, ans));
    }
  }
}
