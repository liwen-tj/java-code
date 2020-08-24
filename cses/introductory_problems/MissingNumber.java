package introductory_problems;

import java.util.Scanner;

public class MissingNumber {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    long n = s.nextLong();
    long sum = 0;
    for (int i = 0; i < n-1; i++) sum += s.nextLong();
    System.out.println((1L+n)*n / 2L - sum);
  }
}
