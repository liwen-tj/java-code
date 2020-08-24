package introductory_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppleDivision {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    long[] arr = new long[n];
    long sum = 0;
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextLong();
      sum += arr[i];
    }

    long half = sum / 2;
    long ans = 0;
    List<Long> candi = new ArrayList<Long>();
    candi.add(0L);
    for (int i = 0; i < n; ++i) {
      int ll = candi.size();
      for (int j = 0; j < ll; ++j) {
        long t = candi.get(j) + arr[i];
        if (t <= half) {
          candi.add(t);
          if(t > ans) ans = t;
        }
      }
    }

    System.out.println(sum - ans*2);
  }
}
