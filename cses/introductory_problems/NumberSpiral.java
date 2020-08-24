package introductory_problems;

import java.util.Scanner;

public class NumberSpiral {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < t; i++) {
      long x = s.nextLong();
      long y = s.nextLong();
      long square = Math.max(x, y);
      long ans;
      if (square % 2 == 0) {
        if (x <= y) ans = (square - 1) * (square - 1) + x;
        else ans = square * square + 1 - y;
      } else {
        if (x <= y) ans = square * square + 1 - x;
        else ans = (square - 1) * (square - 1) + y;
      }
      res.append(ans).append("\n");
    }
    System.out.println(res);
  }
}
