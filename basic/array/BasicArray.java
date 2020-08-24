package basic.array;

import java.util.Arrays;

public class BasicArray {
  public static void main(String[] args) {
    // 声明一个数组，可以使用非固定大小
    int size = 4;
    double[] arr1 = new double[size];

    // 获取数组长度
    int x = arr1.length;

    // 初始化一个数组
    double[] arr2 = {2.9, 3.4, 1.9, 3.5};

    // 遍历数组
    for (double a : arr2) {
//      System.out.println(a);
    }

    // 多维数组
    String str[][] = new String[3][4];

    /**
     * java.util.Arrays 类能方便地操作数组，它提供的所有方法都是静态的
     */
    // 数组二分搜索
    int id = Arrays.binarySearch(arr2, 1.9);
    System.out.println(id);

    // 判断数组相等
    boolean eq = Arrays.equals(arr1, arr2);
    System.out.println(eq);

    // 数组排序
    Arrays.sort(arr2); // arr2将会变成有序的
    for (double a : arr2) {
      System.out.println(a);
    }

  }
}
