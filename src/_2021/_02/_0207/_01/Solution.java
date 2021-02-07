package _2021._02._0207._01;


/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/2/7 11:21 上午
 * @description 665. 非递减数列
 */
public class Solution {
    public static boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length == 1) {
            return true;
        }
        int ans = 0;
        for (int i = 1; i < nums.length && ans < 2; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            ans++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return ans <= 1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 1};
        System.out.println(checkPossibility(nums));
    }
}
