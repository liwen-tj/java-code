package kickstart.k2020;

import java.util.Arrays;
import java.util.Scanner;

public class AA2020Allocation {
  public static int solution(int[] arr, int B) {
    Arrays.sort(arr);
    int n = 0;
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (sum <= B) n++;
      else break;
    }
    return n;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();

    for (int i = 1; i <= T; i++) {
      int N = s.nextInt();
      int B = s.nextInt();
      int[] arr = new int[N];
      for (int j = 0; j < N; j++) {
        arr[j] = s.nextInt();
      }
      System.out.println(String.format("Case #%d: %d", i, AA2020Allocation.solution(arr, B)));
    }
    
  }
}
