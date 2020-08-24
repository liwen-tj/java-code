package basic.sort;

public class InsertSort {

  public static void sort(int[] a) {
    for (int i = 1; i < a.length; i++) {
      for (int j = i; j > 0; j--) {
        if (a[j] < a[j-1]) {
          a[j] = a[j] ^ a[j-1];
          a[j-1] = a[j] ^ a[j-1];
          a[j] = a[j] ^ a[j-1];
        } else break;
      }
    }
  }

  public static void main(String[] args) {
    int[] a = {9,1,3,2,4,5,6,1,2,10};
    InsertSort.sort(a);
    for (int value : a) {
      System.out.println(value);
    }
  }

}
