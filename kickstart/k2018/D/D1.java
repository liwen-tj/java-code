package kickstart.k2018.D;


import java.util.Scanner;
import java.util.TreeSet;

public class D1 {
  private static long[] genData(Scanner s, int n) {
    long x1 = s.nextLong();
    long x2 = s.nextLong();
    long a = s.nextLong();
    long b = s.nextLong();
    long c = s.nextLong();
    long m = s.nextLong();
    long l = s.nextLong();

    long[] xx = new long[n];
    xx[0] = x1;
    xx[1] = x2;
    for (int i = 2; i < n; i++) {
      xx[i] =  (a * xx[i-1] + b * xx[i-2] + c) % m;
    }

    long[] data = new long[n];
    for (int i = 0; i < n; i++) {
      data[i] = xx[i] + l;
    }
    return data;
  }

  private static int getRightId(int ll, int[]so, int o, int x) {
    int target = o + so[ll] - x;

    int low = ll;
    int high = so.length - 1;
    while (low <= high) {
      int mid = (high + low) / 2;
      if (so[mid] > target) high--;
      else if(so[mid] <= target) low++;
    }

    if (high < ll) return -1;
    else return high;
  }

  public static long solve(Scanner s) {
    int n = s.nextInt();
    int o = s.nextInt();
    long d = s.nextLong();
    long[] data = genData(s, n);

    long[] ss = new long[n];
    int[] so = new int[n];
    ss[0] = data[0];
    so[0] = (int)(data[0] % 2);
    for (int i = 1; i < n; i++) {
      ss[i] = ss[i-1] + data[i];
      so[i] = so[i-1] + (int) (data[i] % 2);
    }

    long ans = Long.MIN_VALUE;
    TreeSet<Long> tree = new TreeSet<>();
    int rightNext = 0;
    for (int ll = 0; ll < n; ll++) {
      tree.add(ss[ll]);
      int rid = getRightId(ll, so, o, (int)(data[ll] % 2));
      if (rid >= 0) {
        for (int i = rightNext; i <= rid; i++) {
          if (i != ll) tree.add(ss[i]);
        }
        rightNext = rid + 1;
        Long tmp = tree.floor(d + ss[ll] - data[ll]);
        if (tmp != null && tmp - ss[ll] + data[ll] > ans) ans = tmp - ss[ll] + data[ll];
      }
      tree.remove(ss[ll]);
    }
    
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(-7 % 2);
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int i = 1; i <= T; i++) {
      long ans = D1.solve(s);
      if (ans == Long.MIN_VALUE) System.out.println(String.format("Case #%d: IMPOSSIBLE", i));
      else System.out.println(String.format("Case #%d: %d", i, ans));
    }
  }
}
