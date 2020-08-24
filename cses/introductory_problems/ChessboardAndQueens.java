package introductory_problems;

import java.util.Scanner;

public class ChessboardAndQueens {

  private static boolean check(char[][] data, int row, int col) {
    for (int i = 0; i < 8; ++i) if (data[row][i] == '-' || data[i][col] == '-') return false;
    for (int r = 1; row >= r && col >= r; ++r) if (data[row-r][col-r] == '-') return false;
    for (int r = 1; row >= r && col + r < 8; ++r) if (data[row-r][col+r] == '-') return false;
    return true;
  }

  public static int solve(char[][] data, int layer) {
    if (layer == 7) {
      for (int i = 0; i < 8; i++) if (data[layer][i] == '.' && check(data, layer, i)) return 1;
      return 0;
    }
    int ans = 0;
    for (int i = 0; i < 8; i++) {
      if (data[layer][i] == '.' && check(data, layer, i)) {
        data[layer][i] = '-';
        ans += solve(data, layer + 1);
        data[layer][i] = '.';
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    char[][] data = new char[8][8];
    Scanner s = new Scanner(System.in);
    for (int i = 0; i < 8; i++) data[i] = s.next().toCharArray();
    int ans = ChessboardAndQueens.solve(data, 0);
    System.out.println(ans);
  }
}
