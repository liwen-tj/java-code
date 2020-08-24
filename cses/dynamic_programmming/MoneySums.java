package dynamic_programmming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MoneySums {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int[] x = new int[n];
    int ss = 0;
    for (int i = 0; i < n; i++) {
      x[i] = s.nextInt();
      ss += x[i];
    }
    boolean[] sum = new boolean[ss + 1];
    Arrays.fill(sum, false);
    for (int i = 0; i < n; i++) {
      for (int j = ss; j > 0; j--) if (sum[j]) sum[j + x[i]] = true;
      sum[x[i]] = true;
    }

    List<Integer> res = new ArrayList<Integer>();
    for (int i = 1; i <= ss; i++) if (sum[i]) res.add(i);

    int rs = res.size();
    System.out.println(rs);
    for (int i = 0; i < rs - 1; ++i) System.out.print(res.get(i) + " ");
    System.out.println(res.get(rs - 1));
  }
}
