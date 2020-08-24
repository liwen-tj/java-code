package kickstart.k2020;

import java.util.Scanner;


public class CA2020Countdown {

  public static void solve(int T, Scanner s) {
    int n = s.nextInt();
    int k = s.nextInt();
    int ans = 0;
    int kk = 0;
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
      if (arr[i] == (k - kk)) {
        kk += 1;
        if (kk == k) {
          ans += 1;
          kk = 0;
        }
      } else {
        if (arr[i] == k) {
          kk = 1;
        } else {
          kk = 0;
        }
      }
    }
    System.out.println(String.format("Case #%d: %d", T, ans));
  }


  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int i = 1; i <= T; i++) {
      CA2020Countdown.solve(i, s);
    }
  }
}
