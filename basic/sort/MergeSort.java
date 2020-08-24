package basic.sort;

import static java.lang.Math.min;

public class MergeSort {

  public static void merge(int[] a, int low, int mid, int high) {
    if (low >= high) return;

    // 需要开临时空间O(N)（不开临时空间O(1)会需要较多的数据移动）
    int[] tmp = new int[high - low + 1];
    int i = low;
    int j = mid + 1;
    int k = 0;
    while (true) {
      while (i <= mid && a[i] <= a[j]) tmp[k++] = a[i++];
      if (i > mid) break;

      while (j <= high && a[j] <= a[i]) tmp[k++] = a[j++];
      if (j > high) break;
    }

    while (i <= mid) tmp[k++] = a[i++];
    while (j <= high) tmp[k++] = a[j++];

    // 数组拷贝
    System.arraycopy(tmp, 0, a, low, high + 1 - low);

  }

  public static void sortRecursive(int[] a, int low, int high) {
    int mid = (low + high) / 2;
    if (low < high) {
      sortRecursive(a, low, mid);
      sortRecursive(a, mid+1, high);
      merge(a, low, mid, high);
    }
  }

  public static void sortNonRecursive(int[] a, int low, int high) {
    int len = high - low + 1;
    int k = 1;
    while(k < len) {
      for (int s = low; s <= high - k; s += 2*k) {
        merge(a, s, s+k-1, min(s+2*k-1, high));
      }
      k *= 2;
    }
  }

  public static void main(String[] args) {
//    int[] a = {9,1,3,2,4,5,6,1,2,10};
//    MergeSort.sortRecursive(a, 0, a.length - 1);
//    for (int value : a) {
//      System.out.println(value);
//    }

    int[] b = {11,10,8,7,6};
    MergeSort.sortNonRecursive(b, 0, b.length - 1);
    for (int value : b) {
      System.out.println(value);
    }
  }

}
