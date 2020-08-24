package introductory_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreatingStringI {

  private static int count = 0;
  private static List<String> strings = new ArrayList<String>();

  private static void getAns(int[] num, char[] pre, int pn) {
    if (pn == pre.length) {
      count += 1;
      strings.add(new String(pre));
      return;
    }
    for (int i = 0; i < 26; i++) {
      if (num[i] > 0) {
        int[] nn = new int[num.length];
        System.arraycopy(num, 0, nn, 0, num.length);
        nn[i] = num[i] - 1;
        char[] pp = new char[pre.length];
        System.arraycopy(pre, 0, pp, 0, pn);
        pp[pn] = (char)('a' + i);
        getAns(nn, pp, pn+1);
      }
    }
  }


  public static void solve(char[] arr) {
    int[] num = new int[26];
    for(char a : arr) num[a - 'a'] += 1;
    getAns(num, new char[arr.length], 0);
    System.out.println(count);
    for(String st : strings) System.out.println(st);
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String x = s.next();
    CreatingStringI.solve(x.toCharArray());
  }
}
