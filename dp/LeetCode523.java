package dp;

import java.util.HashMap;

public class LeetCode523 {
  private static boolean zeros(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == 0 && nums[i+1] == 0) return true;
    }
    return  false;
  }
  public static boolean checkSubarraySum(int[] nums, int k) {
    if (k == 0) return zeros(nums);
    int s = 0;
    HashMap<Integer, Integer> reminder = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      s = (s + nums[i] % k) % k;
      if (reminder.containsKey(s)) {
        if (reminder.get(s) < i - 1) return true;
      }
      else reminder.put(s, i);
    }
    return false;
  }

  public static void main(String[] args) {
    int[] test1 = {0,0};
    System.out.println(LeetCode523.checkSubarraySum(test1, 0));

    int[] test2 = {23,2,4,6,7};
    System.out.println(LeetCode523.checkSubarraySum(test2, 6));
    System.out.println(LeetCode523.checkSubarraySum(test2, 7));
  }
}
