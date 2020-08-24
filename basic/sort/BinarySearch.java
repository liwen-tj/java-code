package basic.sort;

public class BinarySearch {

  public static int binarySearch(double[] a, int fromIndex, int toIndex, double key) {
    // 特殊情况判断
    if (fromIndex > toIndex) return -1;
    else if (fromIndex == toIndex) return a[fromIndex] == key ? fromIndex : -1;

    // int mid = (fromIndex + toIndex) / 2; // 这样写有可能会溢出
    int mid = fromIndex + (toIndex - fromIndex) / 2;

    // 左边
    int index = binarySearch(a, fromIndex, mid, key);
    if (index >= 0) return index;

    // 右边
    return binarySearch(a,mid+1, toIndex, key);
  }


  public static int binarySearch2(double[] a, int fromIndex, int toIndex, double key) {
    // 特殊情况判断
    if (fromIndex > toIndex) return -1;
    else if (fromIndex == toIndex) return a[fromIndex] == key ? fromIndex : -1;

    // 非递归二分搜索
    while (fromIndex <= toIndex) {
      int mid = (fromIndex + toIndex) / 2;
      if (a[mid] > key) toIndex = mid - 1;
      else if (a[mid] < key) fromIndex = mid + 1;
      else return mid;
    }
    return -1;
  }


  public static void main(String[] args) {
    // 初始化一个数组
    double[] arr = {1.9, 2.9, 3.4, 3.5};
    System.out.println(BinarySearch.binarySearch2(arr, 0, arr.length - 1, 1.8));
    System.out.println(BinarySearch.binarySearch2(arr, 0, arr.length - 1, 1.9));
    System.out.println(BinarySearch.binarySearch2(arr, 0, arr.length - 1, 2.9));
    System.out.println(BinarySearch.binarySearch2(arr, 0, arr.length - 1, 3.4));
    System.out.println(BinarySearch.binarySearch2(arr, 0, arr.length - 1, 3.5));

  }

}
