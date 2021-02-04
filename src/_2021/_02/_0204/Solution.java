package _2021._02._0204;

import java.util.Arrays;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/2/4 9:00 上午
 * @description 643. 子数组最大平均数 I
 */
public class Solution {
    public static double findMaxAverage(int[] nums, int k) {
        int len = nums.length, maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        int sum = maxSum;
        for (int i = k; i < len; i++) {
            sum = sum - nums[i - k] + nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return (double) maxSum / k;
    }


    public static void main(String[] args) {
//        int[] nums = {1, 12, -5, -6, 50, 3};
        int[] nums = {0, 4, 0, 3, 2};
        int k = 1;
        System.out.println(findMaxAverage(nums, k));
    }
}
