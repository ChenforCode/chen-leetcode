package _20200614;

/**
 * @author <a href="http://www.chenforcode.cn">PKUCoder</a>
 * @date 2020/6/14 10:15 上午
 * @description 1300.转变数组后最接近目标值的数组和
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 * <p>
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * <p>
 * 请注意，答案不一定是 arr 中的数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 * 示例 2：
 * <p>
 * 输入：arr = [2,3,5], target = 10
 * 输出：5
 * 示例 3：
 * <p>
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 * 输出：11361
 * <p>
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i], target <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int findBestValue(int[] arr, int target) {
        int resultSum = 0;
        int result = 0;
        for (int i = 0; i <= 100000; i++) {
            int[] newArr = arr.clone();
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (newArr[j] > i) {
                    newArr[j] = i;
                }
                sum += newArr[j];
            }
            if (Math.abs(sum - target) < Math.abs(resultSum - target)) {
                resultSum = sum;
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(new Solution().findBestValue(new int[]{4, 9, 3}, 10));

        System.out.println(new Solution().findBestValue(new int[]{60864, 25176, 27249, 21296, 20204}, 56803));
    }
}
