import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static int maxSum(int[] nums1, int[] nums2) {
        long s1 = 0;
        long s2 = 0;
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                s1 = Math.max(s1, s2) + nums1[i];
                s2 = s1; ++i; ++j;
            } else if (nums1[i] > nums2[j]) {
                s2 += nums2[j++];
            } else {
                s1 += nums1[i++];
            }
        }
        while (i < nums1.length) s1 += nums1[i++];
        while (j < nums2.length) s2 += nums2[j++];

        int ans = (int) (Math.max(s1, s2) % 1000000001);
        return ans;
    }

    public static void main(String[] args) {
        int x = Solution.maxSum(new int[]{1,4,5,8,9,11,19}, new int[]{2,3,4,11,12});
        System.out.println(x);
    }
}
