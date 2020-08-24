package sorting_searching;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DistinctNumbers {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    Set<Integer> arr = new HashSet<Integer>();
    for (int i = 0; i < n; i++) arr.add(s.nextInt());
    System.out.println(arr.size());
  }
}
