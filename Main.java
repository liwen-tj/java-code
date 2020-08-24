import java.util.HashMap;
public class Main {
  public static void solve(int[] arr, int n) {
    HashMap<Integer,Integer> target = new HashMap<>();
    boolean ok = false;
    for (int i = 0; i < arr.length; ++i) {
      if (target.containsKey(arr[i])) {
        System.out.println(target.get(arr[i]));
        System.out.println(i);
        ok = true;
        break;
      }
      else {
        target.put(n - arr[i], i);
      }
    }

    if (!ok) System.out.println("-1");
    System.out.println("\n");
  }

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5};
    Main.solve(arr, 6);

    int[] arr2 = {1,2,3,4,5};
    Main.solve(arr2, 10);

    int[] arr3 = {1,2,3,4,5,5};
    Main.solve(arr3, 10);
  }
}
