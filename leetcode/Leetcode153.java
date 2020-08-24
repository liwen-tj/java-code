package leetcode;

// https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
public class Leetcode153 {
  public static int findMin(int[] nums) {
    int n = nums.length;
    if (n == 0) return -1;

    int right = nums[n-1];
    int low = 0;
    int high = n - 1;
    while(low < high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] >= right) low = mid + 1;
      else if (mid > 0 && nums[mid-1] < nums[mid]) high = mid - 1;
      else return nums[mid];
    }
    return nums[high];
  }

  public static void main(String[] args) {
    int[] arr = {3,4,5,1};
    int x = Leetcode153.findMin(arr);
    System.out.println(x);
  }
}
