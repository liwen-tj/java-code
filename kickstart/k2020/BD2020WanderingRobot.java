package kickstart.k2020;

import java.util.*;


// TLE<Time Limit Exceeded> for test case#2
public class BD2020WanderingRobot {

  public static void solve(int T, Scanner s) {
    int w = s.nextInt();
    int h = s.nextInt();
    int l = s.nextInt();
    int u = s.nextInt();
    int r = s.nextInt();
    int d = s.nextInt();

    if (l == 1 && u == 1) {
      System.out.println(String.format("Case #%d: 0.0", T));
      return;
    }

    double prob1 = w == 1 ? 1.0 : 0.5;
    double prob2 = h == 1 ? 1.0 : 0.5;
    double[] prob = new double[w+1];
    prob[1] = 1.0;
    for (int i = 2; i <= r; i++) {
      prob[i] = prob[i - 1] * prob2;
    }
    double ans = 0.0;

    // part 1 <down>
    if (u > 1) {
      for (int i = 2; i < u; ++i) {
        prob[1] = prob[1] * prob1;
        for (int j = 2; j < r; j++) {
          prob[j] = prob[j] * 0.5 + prob[j - 1] * 0.5;
        }

        if (r == w && w > 1) prob[w] = prob[w] + prob[w - 1] * 0.5;
        else if (r > 1) prob[r] = prob[r] * 0.5 + prob[r - 1] * 0.5;
      }

      for (int i = l; i <= r; i++) ans += prob[i] * 0.5;
      ans += r == w ? prob[r] * 0.5 : 0;
    }

    // part 2 <right>
    if(l > 1) {
      for (int i = u; i <= d; i++) {
        if (i == 1) {
          ans += prob[l-1] * prob2;
          continue;
        }
        prob[1] = prob[1] * prob1;
        double right = 0.5;
        if (i == h) right = 1.0;
        for (int j = 2; j < l; j++) {
          prob[j] = prob[j] * 0.5 + prob[j - 1] * right;
        }
        ans += right * prob[l-1];
      }
    }

    System.out.println(String.format("Case #%d: %f", T, 1.0 - ans));

  }


  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int i = 1; i <= T; i++) {
      BD2020WanderingRobot.solve(i, s);
    }
  }
}
