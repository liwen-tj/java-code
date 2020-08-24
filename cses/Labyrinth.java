import java.util.*;

public class Labyrinth {

    public static class Point {
        public int x;
        public int y;
        public String path;

        public Point(int ai, int aj, String s) {
            this.x = ai;
            this.y = aj;
            this.path = s;
        }
    }

    public static String solve(List<Point> travel, char[][] arr) {
        while (travel.size() > 0) {
            List<Point> tmp = new ArrayList<>();
            for (Point point : travel) {
                int ii = point.x;
                int jj = point.y;
                if (arr[ii][jj] == 'B') return point.path;
                else {
                    arr[ii][jj] = '#';
                    if (ii > 0 && arr[ii-1][jj] != '#') tmp.add(new Point(ii-1, jj, point.path + "U"));
                    if (ii < arr.length - 1 && arr[ii+1][jj] != '#')  tmp.add(new Point(ii+1, jj, point.path + "D"));
                    if (jj > 0 && arr[ii][jj-1] != '#') tmp.add(new Point(ii, jj-1, point.path + "L"));
                    if (jj < arr[0].length - 1 && arr[ii][jj+1] != '#')  tmp.add(new Point(ii, jj+1, point.path + "R"));
                }
            }
            travel = tmp;
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) arr[i] = s.next().toCharArray();

        int ai = 0, aj = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'A') {
                   ai = i; aj = j;
                   break;
                }
            }
        }

        List<Point> travel = new ArrayList<>();
        travel.add(new Point(ai, aj, ""));

        String ans = Labyrinth.solve(travel, arr);
        if (ans.length() == 0) System.out.println("NO");
        else {
            System.out.println("YES");
            System.out.println(ans.length());
            System.out.println(ans);
        }

    }
}
