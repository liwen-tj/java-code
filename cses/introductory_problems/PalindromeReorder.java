package introductory_problems;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromeReorder {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    char[] arr = s.next().toCharArray();
    int[] num = new int[26];
    Arrays.fill(num, 0);
    for (char c : arr) num[c - 'A'] += 1;

    boolean yes = true;
    int id = -1;
    for (int i = 0; i < 26; i++) {
      if (num[i] % 2 != 0) {
        if (id == -1) id = i;
        else {
          yes = false;
          break;
        }
      }
    }

    if (yes) {
      char[] ans = new char[arr.length];
      int p = 0;
      for (int i = 0; i < 26; i++) {
        if(i != id) {
          for (int j = 0; j < num[i] / 2; j++) {
            ans[p+j] = (char)('A' + i);
            ans[arr.length-1-p-j] = (char)('A' + i);
          }
          p = p + num[i] / 2;
        }
      }
      if (id >= 0) {
        int expand = num[id] / 2;
        ans[arr.length/2] = (char)('A' + id);
        for (int i = 1; i <= expand; i++) {
          ans[arr.length/2 - i] = (char)('A' + id);
          ans[arr.length/2 + i] = (char)('A' + id);
        }
      }
      System.out.println(new String(ans));
    } else System.out.println("NO SOLUTION");
  }
}
