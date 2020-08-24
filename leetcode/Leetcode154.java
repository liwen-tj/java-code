package leetcode;

// https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
public class Leetcode154 {
  public static int findMin(int[] nums) {
    int n = nums.length - 1;
    if (n < 0) return -1;
    if (n == 0 || nums[0] < nums[n]) return nums[0];
    int low = 0;
    int high = n;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] < nums[high]) high = mid;
      else if (nums[mid] > nums[high]) low = mid + 1;
      else high--;
    }
    return nums[low];
  }

  public static void main(String[] args) {
    int[] arr = {3,4,5};
    int x = Leetcode153.findMin(arr);
    System.out.println(x);
  }
}
