package introductory_problems;

import java.util.Scanner;

public class TwoKnights {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    if (n < 4) {
      switch (n){
        case 1:
          System.out.println("0\n");
          break;
        case 2:
          System.out.println("0\n6\n");
          break;
        case 3:
          System.out.println("0\n6\n28\n");
          break;
      }
      return;
    }

    StringBuilder res = new StringBuilder("0\n6\n28\n");
    int x = 8;
    for (int i = 4; i <= n; i++) {
      x = x + (4 * i - 6) * 2 - 2 - 2;
      long ii = i * i;
      long ans = ii * (ii - 1) / 2 - x;
      res.append(ans).append("\n");
    }
    System.out.println(res);
  }
}
