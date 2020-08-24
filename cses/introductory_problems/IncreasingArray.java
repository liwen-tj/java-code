package introductory_problems;

import java.util.Scanner;

public class IncreasingArray {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    long[] arr = new long[n];
    for(int i = 0; i < n; ++i) arr[i] = s.nextLong();
    long[] tar = new long[n];
    tar[0] = arr[0];
    long ans = 0;
    for (int i = 1; i < n; ++i) {
      if (arr[i] >= tar[i-1]) tar[i] = arr[i];
      else tar[i] = tar[i-1];
      ans = ans + tar[i] - arr[i];
    }
    System.out.println(ans);
  }
}
