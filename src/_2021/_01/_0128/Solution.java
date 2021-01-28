package _2021._01._0128;

import java.util.Arrays;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/1/28 9:22 上午
 * @description 724.寻找数组的中心索引
 */
public class Solution {
    public static int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum * 2 + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {-1,-1,-1,-1,-1,-1};
        int []nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }
}
