package basic.sort;

public class BubbleSort {

  public static void sort(int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
      for (int j = 0; j < a.length - i - 1; j++) {
        if (a[j] > a[j+1]) {
          a[j] = a[j] ^ a[j+1];
          a[j+1] = a[j] ^ a[j+1];
          a[j] = a[j] ^ a[j+1];
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] a = {9,1,3,2,4,5,6,1,2,10};
    BubbleSort.sort(a);
    for (int value : a) {
      System.out.println(value);
    }
  }
}
