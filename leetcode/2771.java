/*
 * https://leetcode.com/problems/longest-non-decreasing-subarray-from-two-arrays/
 */



/*
 * Simple Bottom-Up DP - derived from LC Hints!!
 */
class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length, res = 1;
        int[][] dp = new int[n][2];
        /*
         * dp[i][0] -> Largest length of non-decreasing subarray when the current (i'th) element 
         *             is taken from nums1.
         * dp[i][1] -> Largest length of non-decreasing subarray when the current (i'th) element 
         *             is taken from nums2.
         */
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (nums1[i] >= nums1[i - 1])
                dp[i][0] = Math.max(dp[i][0], 1 + dp[i - 1][0]);
            if (nums1[i] >= nums2[i - 1])
                dp[i][0] = Math.max(dp[i][0], 1 + dp[i - 1][1]);
            if (nums1[i] < nums1[i - 1] && nums1[i] < nums2[i - 1])
                dp[i][0] = 1;
            if (nums2[i] >= nums2[i - 1])
                dp[i][1] = Math.max(dp[i][1], 1 + dp[i - 1][1]);
            if (nums2[i] >= nums1[i - 1])
                dp[i][1] = Math.max(dp[i][1], 1 + dp[i - 1][0]);
            if (nums2[i] < nums2[i - 1] && nums2[i] < nums1[i - 1])
                dp[i][1] = 1;
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        return res;
    }
}
