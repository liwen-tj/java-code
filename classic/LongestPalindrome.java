package classic;


public class LongestPalindrome {

  public static String manacher(String s) {
    char divider = '#';
    if (s == null || s.length() < 2) return s;
    s = addDivider(s, divider);
    char[] arr = s.toCharArray();

    int[] p = new int[s.length()];
    p[0] = 0;
    int center = 0;
    int radius = 0;
    int resCenter = 0;
    int resRadius = 0;

    for (int i = 0; i < s.length(); i++) {
      int j = 2 * center - i;
      if (center + radius <= i || j - p[j] <= center - radius) {
        int r = expand(arr, i, center + radius + 1 - i);
        p[i] = r;
        if (i + r > center + radius) {
          center = i;
          radius = r;
        }
        if (r > resRadius) {
          resCenter = i;
          resRadius = r;
        }
      }
      else p[i] = j - Math.max(j - p[j], center - radius);
    }

    return removeDivider(arr, resCenter, resRadius, divider);
  }


  private static String addDivider(String s, char divider) {
    char[] arr = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    sb.append(divider);
    for (char c : arr) {
      sb.append(c);
      sb.append(divider);
    }
    return sb.toString();
  }


  private static int expand(char[] arr, int id, int radius) {
    while(id - radius >=0 && id + radius < arr.length) {
      if (arr[id - radius] == arr[id + radius]) radius += 1;
      else break;
    }
    return radius - 1;
  }


  private static String removeDivider(char[] arr, int center, int radius, char divider) {
    if (center - radius < 0 || center + radius >= arr.length) return null;
    StringBuilder sb = new StringBuilder();
    for (int i = center - radius; i <= center + radius; i++) {
      if (arr[i] != divider) sb.append(arr[i]);
    }
    return sb.toString();
  }


  public static void main(String[] args) {
    System.out.println(LongestPalindrome.manacher("hellollehe"));
    System.out.println(LongestPalindrome.manacher("ccc"));
    System.out.println(LongestPalindrome.manacher("bananas"));
  }
}
