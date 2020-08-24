package dp;

// 连续子数组的最大和
class Solution {
  public static int maxSubArray(int[] nums) {
    int[] dp = new int[nums.length];
    int res = nums[0];
    dp[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (dp[i-1] > 0) dp[i] = nums[i] + dp[i-1];
      else dp[i] = nums[i];
      res = Math.max(res, dp[i]);
    }
    return res;
  }
}

public class LeetCode42 {
  public static void main(String[] args) {
    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    int res = Solution.maxSubArray(nums);
    System.out.println(res);
  }
}
