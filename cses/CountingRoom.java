import java.util.Scanner;

public class CountingRoom {
    public static void travel(char[][] arr, int i, int j) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == '#') return;
        arr[i][j] = '#';
        travel(arr, i-1, j);
        travel(arr, i+1, j);
        travel(arr, i, j-1);
        travel(arr, i, j+1);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; ++i) arr[i] = s.next().toCharArray();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == '.') {
                    ans++;
                    travel(arr, i, j);
                }
            }
        }
        System.out.println(ans);
    }
}
