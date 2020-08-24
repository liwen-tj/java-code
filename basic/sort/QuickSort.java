package basic.sort;

import java.util.Stack;

public class QuickSort {

  // 这样写，当x=y时，会有问题!!
//  private static void swap(int[] a, int x, int y) {
//    a[x] = a[x] ^ a[y];
//    a[y] = a[x] ^ a[y];
//    a[x] = a[x] ^ a[y];
//  }

  private static void swap(int[] a, int x, int y) {
    int tmp = a[x];
    a[x] = a[y];
    a[y] = tmp;
  }


  public static int partition(int[] a, int low, int high) {
    int base = a[low];
    int i = low + 1;
    int j = high;
    while (true) {
      while (i < high && a[i] <= base) i++;
      while (j > low && a[j] >= base) j--;
      if (i >= j) break;
      swap(a, i, j);
    }
    swap(a, low, j);

    return j;
  }


  public static void sort(int[] a, int low, int high) {
    if (low >= high) return;
    int id = partition(a, low, high);
    sort(a, low, id);
    sort(a, id+1, high);
  }


  public static void sortNonRecursive(int[] a, int low, int high) {
    int pivot;
    if (low >= high) return;

    Stack<Integer> stack = new Stack<>();
    stack.push(low);
    stack.push(high);

    while (!stack.isEmpty()) {
      int right = stack.pop();
      int left = stack.pop();
      pivot = partition(a, left, right);
      if (pivot > left) {
        stack.push(left);
        stack.push(pivot);
      }
      if (pivot + 1 < right) {
        stack.push(pivot + 1);
        stack.push(right);
      }
    }

  }


  public static void main(String[] args) {
    int[] t = {9,1};
//    int[] t = {1,1,2};
    QuickSort.sortNonRecursive(t, 0, t.length - 1);
    for (int value : t) {
      System.out.print(value);
      System.out.print(", ");
    }
  }
}
