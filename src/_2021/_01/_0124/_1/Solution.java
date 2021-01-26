package _2021._01._0124._1;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/1/24 10:02 上午
 * @description 最长递增子序列，
 * 方法具体可以类比寻找最大值，只不过最大值变成了每个序列的递增长度，设置一个curMax
 * 和一个max，如果序列一直在递增，就curMax++，直到递减重置curMax，然后根据curMax
 * 和max的大小对max进行更新。
 */
public class Solution {
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        int curMax = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curMax++;
            } else {
                curMax = 1;
            }
            max = Math.max(curMax, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2};
        System.out.println(findLengthOfLCIS(nums));
    }
}
