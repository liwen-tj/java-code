package dynamic_programmming;

import java.util.Scanner;

public class LIS {

    private static int upperBound(int[] help, int h, int target) {
        if (h == 0) return 0;
        if (target > help[h-1]) return h;
        int low = 0;
        int hig = h - 1;
        while (low <= hig) {
            int mid = (low + hig) / 2;
            if (help[mid] == target) return mid;
            else if (help[mid] < target) low = mid + 1;
            else hig = mid - 1;
        }
        return low;
    }

    public static int solve(int[] arr) {
        int[] help = new int[arr.length];
        int h = 0;
        for (int value : arr) {
            int id = LIS.upperBound(help, h, value);
            help[id] = value;
            if (id >= h) h++;
        }
        return h;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) arr[i] = s.nextInt();

        int ans = LIS.solve(arr);
        System.out.println(ans);
    }
}
