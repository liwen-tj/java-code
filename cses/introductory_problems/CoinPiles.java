package introductory_problems;

import java.util.Scanner;

public class CoinPiles {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      int a = s.nextInt();
      int b = s.nextInt();
      int x = Math.max(a, b);
      int y = Math.min(a, b);
      int k3 = 2 * y - x;
      if (x >= 2 && k3 >= 0 && k3 % 3 == 0 || (x==0&&y==0)) sb.append("YES\n");
      else sb.append("NO\n");
    }
    System.out.println(sb);
  }
}
