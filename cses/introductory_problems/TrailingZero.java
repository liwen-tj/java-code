package introductory_problems;

import java.util.Scanner;

public class TrailingZero {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    long ans = 0;
    for (int i = 5; i <= n; i+=5) {
      int j = i;
      while (j % 5 == 0) {
        j = j / 5;
        ans += 1;
      }
    }
    System.out.println(ans);
  }

  public static class GridPaths {

    public static char[] limits;

    public static int solve(int row, int col, int step, boolean[][] visited) {
      if (step == 48) return row == 6 && col == 0 ? 1 : 0;
      else if (visited[6][0]) return 0;
      if(6 - row + col > 48 - step) return 0;

      if (col > 0 && col < 6 && !visited[row][col-1] && !visited[row][col+1]) {
        int up = Math.max(0, row - 1);
        int down = Math.min(6, row + 1);
        if (visited[up][col] && visited[down][col]) return 0;
      }

      if (col == 0 && row > 0 && row < 6 && !visited[row-1][0] && !visited[row+1][0]) return 0;
      if (col == 6 && row > 0 && row < 6 && !visited[row-1][6] && !visited[row+1][6]) return 0;

      if (limits[step] == '?') {
        int ans = 0;
        if (row > 0 && !visited[row - 1][col]) { // UP
          visited[row - 1][col] = true;
          ans += solve(row - 1, col, step + 1, visited);
          visited[row - 1][col] = false;
        }

        if (row < 6 && !visited[row + 1][col]) { // DOWN
          visited[row + 1][col] = true;
          ans += solve(row + 1, col, step + 1, visited);
          visited[row + 1][col] = false;
        }

        if (col > 0 && !visited[row][col - 1]) { // LEFT
          visited[row][col - 1] = true;
          ans += solve(row, col - 1, step + 1, visited);
          visited[row][col - 1] = false;
        }

        if (col < 6 && !visited[row][col + 1]) { // RIGHT
          visited[row][col + 1] = true;
          ans += solve(row, col + 1, step + 1, visited);
          visited[row][col + 1] = false;
        }
        return ans;
      } else {
        int ans;
        char limit = limits[step];
        switch (limit) {
          case 'U':
            if (row > 0 && !visited[row - 1][col]) { // UP
              visited[row - 1][col] = true;
              ans = solve(row - 1, col, step + 1, visited);
              visited[row - 1][col] = false;
              return ans;
            }
            break;
          case 'D':
            if (row < 6 && !visited[row + 1][col]) { // DOWN
              visited[row + 1][col] = true;
              ans = solve(row + 1, col, step + 1, visited);
              visited[row + 1][col] = false;
              return ans;
            }
            break;
          case 'L':
            if (col > 0 && !visited[row][col - 1]) { // LEFT
              visited[row][col - 1] = true;
              ans = solve(row, col - 1, step + 1, visited);
              visited[row][col - 1] = false;
              return ans;
            }
            break;
          case 'R':
            if (col < 6 && !visited[row][col + 1]) { // RIGHT
              visited[row][col + 1] = true;
              ans = solve(row, col + 1, step + 1, visited);
              visited[row][col + 1] = false;
              return ans;
            }
            break;
          default:
            return 0;
        }
        return 0;
      }
    }

    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      limits = s.next().toCharArray();
      boolean[][] visited = new boolean[7][7];
      visited[0][0] = true;
      long start = System.currentTimeMillis();
      int ans = solve(0, 0, 0, visited);
      System.out.println(System.currentTimeMillis() - start + "ms");
      System.out.println(ans);
    }
  }
}
