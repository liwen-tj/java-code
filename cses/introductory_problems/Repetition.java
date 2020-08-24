package introductory_problems;

import java.util.Scanner;

public class Repetition {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String str = s.next();
    char[] arr = str.toCharArray();
    int max = 1;
    int times = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == arr[i-1]) {
        times += 1;
        if (times > max) max = times;
      } else times = 1;
    }
    System.out.println(max);
  }
}
