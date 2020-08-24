package sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class Apartments {

  private static boolean small(int x, int k, int room) {
    return room < x - k;
  }

  private static boolean inner(int x, int k, int room) {
    return room <= x + k;
  }

  public static int solve(int[] peop, int[] room, int k) {
    Arrays.sort(peop);
    Arrays.sort(room);
    int ans = 0;
    int r = 0, p = 0;
    while (r < room.length && p < peop.length) {
      if (small(peop[p], k, room[r])) ++r;
      else if (inner(peop[p], k, room[r])) {
        ++r;
        ++p;
        ++ans;
      } else ++p;
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int m = s.nextInt();
    int k = s.nextInt();
    int[] peop = new int[n];
    int[] room = new int[m];
    for(int i = 0; i < n; ++i) peop[i] = s.nextInt();
    for(int i = 0; i < m; ++i) room[i] = s.nextInt();
    int ans = Apartments.solve(peop, room, k);
    System.out.println(ans);
  }
}
