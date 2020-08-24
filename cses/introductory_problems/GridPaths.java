package introductory_problems;

import java.util.Scanner;


// C++ version can pass OJ.
public class GridPaths {

  public static char[] limits;
  public static boolean[][] visited = new boolean[7][7];

  public static int ans = 0;

  private static boolean ee(int i, int j) {
    return i < 7 && i >= 0 && j >= 0 && j < 7 && !visited[i][j];
  }

  public static void solve(int row, int col, int step) {
    if(row == 6 && col == 0) {
      if (step == 48) ans++;
      return;
    }

    visited[row][col] = true;
    if (limits[step] == '?' || limits[step] == 'L') {
      if (col > 0 && !visited[row][col - 1]) {
        if (!(!ee(row, col - 2) && ee(row - 1, col - 1) && ee(row + 1, col - 1))) {
          solve(row, col-1, step+1);
        }
      }
    }

    if (limits[step] == '?' || limits[step] == 'R') {
      if (col < 6 && !visited[row][col+1]) {
        if (!(!ee(row, col + 2) && ee(row - 1, col + 1) && ee(row + 1, col + 1))) {
          solve(row, col+1, step+1);
        }
      }
    }

    if (limits[step] == '?' || limits[step] == 'U') {
      if (row > 0 && !visited[row - 1][col]) {
        if (!(!ee(row - 2, col) && ee(row - 1, col + 1) && ee(row - 1, col - 1))) {
          solve(row-1, col, step+1);
        }
      }
    }

    if (limits[step] == '?' || limits[step] == 'D') {
      if (row < 6 && !visited[row + 1][col]) {
        if (!(!ee(row + 2, col) && ee(row + 1, col + 1) && ee(row + 1, col - 1))) {
          solve(row+1, col, step+1);
        }
      }
    }

    visited[row][col] = false;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    limits = s.next().toCharArray();
    long start = System.currentTimeMillis();
    solve(0, 0, 0);
    System.out.println(System.currentTimeMillis() - start);
    System.out.println(ans);
  }
}