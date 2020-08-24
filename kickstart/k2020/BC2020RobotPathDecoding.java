package kickstart.k2020;

import java.util.Scanner;
import java.util.Stack;

public class BC2020RobotPathDecoding {

  public static long NN = 1000000000L;

  public static class Move {
    public long east;
    public long south;
    public Move() {
      east = 0;
      south = 0;
    }
  }

  public static long solve(int T, Scanner s) {
    char[] arr = s.next().toCharArray();
    Stack<Character> chars = new Stack<>();
    Stack<Move> exp = new Stack<>();
    exp.push(new Move());
    for(char a : arr) {
      if (a >= '2' && a <= '9') {
        chars.push(a);
        exp.push(new Move());
      }
      else if (a == '(') {/** we assume the input is legal*/}
      else if (a == ')') {
        int t = Character.getNumericValue(chars.pop());
        Move m = exp.pop();
        Move out = exp.peek();
        out.east = (out.east + m.east * t) % NN;
        out.south = (out.south + m.south * t) % NN;
      } else {
        switch (a) {
          case 'W':
            exp.peek().east = (exp.peek().east + NN - 1) % NN;
            break;
          case 'E':
            exp.peek().east = (exp.peek().east + 1) % NN;
            break;
          case 'N':
            exp.peek().south = (exp.peek().south + NN - 1) % NN;
            break;
          case 'S':
            exp.peek().south = (exp.peek().south + 1) % NN;;
            break;
          default:
        }
      }
    }

    Move ans = exp.pop();
    long east = (ans.east + 1) % (NN + 1);
    long south = (ans.south + 1) % (NN + 1);
    System.out.println(String.format("Case #%d: %d %d", T, east, south));
    return 0;
  }


  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int i = 1; i <= T; i++) {
      BC2020RobotPathDecoding.solve(i, s);
    }
  }
}
