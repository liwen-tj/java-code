package introductory_problems;

import java.util.Scanner;

public class Permutations {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    if (n > 4) {
      int x = n;
      int y = n;
      if (n % 2 == 0) y = n - 1;
      else x = n - 1;
      StringBuilder ans = new StringBuilder();
      for (int i = 2; i <= x; i+=2) ans.append(i).append(" ");
      for (int i = 1; i <= y; i+=2) ans.append(i).append(" ");
      System.out.println(ans);
    } else if (n == 4) System.out.println("3 1 4 2");
    else if (n == 1) System.out.println("1");
    else System.out.println("NO SOLUTION");
  }
}
