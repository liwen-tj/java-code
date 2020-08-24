package introductory_problems;

import java.util.Scanner;

public class TwoSets {

  private static void printF(int[] a, int[] b) {
    StringBuilder x = new StringBuilder("YES\n");
    x.append(a.length).append("\n");
    for (int i = 0; i < a.length - 1; i++) x.append(a[i]).append(" ");
    x.append(a[a.length-1]).append("\n");

    x.append(b.length).append("\n");
    for (int i = 0; i < b.length - 1; i++) x.append(b[i]).append(" ");
    x.append(b[b.length-1]).append("\n");
    System.out.println(x);
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    if (n < 3) System.out.println("NO");
    else {
      if (n % 2 == 0) {
        if (n % 4 != 0) System.out.println("NO");
        else {
          int[] x1 = new int[n/2];
          int[] x2 = new int[n/2];
          for (int i=1,p=0,q=0; i <= n; ++i) {
            if (i <= n/4 || i > n - n/4) x1[p++] = i;
            else x2[q++] = i;
          }
          TwoSets.printF(x1, x2);
        }
      } else {
        if ((n-3) % 4 != 0) System.out.println("NO");
        else {
          int pp = (n-3) / 4;
          int[] x1 = new int[pp*2+2];
          x1[0] = 1; x1[1] = 2;
          int[] x2 = new int[pp*2+1];
          x2[0] = 3;
          for (int i=4,p=2,q=1; i <= n; ++i) {
            if (p < pp + 2 || q == pp*2+1) x1[p++] = i;
            else x2[q++] = i;
          }
          TwoSets.printF(x1, x2);
        }
      }
    }
  }
}
