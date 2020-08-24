package sorting_searching;

import java.util.Scanner;
import java.util.TreeSet;

public class ConcertTickets {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
//    int m = s.nextInt();
    TreeSet<Integer> tickets = new TreeSet<Integer>();
//    int[] prices = new int[m];
    for (int i = 0; i < n; i++) tickets.add(s.nextInt());
//    for (int i = 0; i < m; i++) prices[i] = s.nextInt();
    System.out.println(tickets.size());
  }
}
