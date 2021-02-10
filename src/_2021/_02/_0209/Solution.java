package _2021._02._0209;

import java.util.HashMap;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/2/9 6:03 下午
 * @description 992. K 个不同整数的子数组
 * 关键点在于。。最多K个元素的子数组 - 做多K-1个元素的子数组 = 恰好K个元素的子数组
 * 因为最多K个元素的子数组包括了小于K个元素的子数组和正好K个的子数组
 */
public class Solution {
    public static int subarraysWithKDistinct(int[] A, int K) {
        return dealK(A, K) - dealK(A, K - 1);
    }

    public static int dealK(int[] A, int k) {
        int left = 0, right = 0, len = A.length, dis = 0, ans = 0;
        HashMap<Integer, Integer> counter = new HashMap<>();
        while (right < len) {
            if (!counter.containsKey(A[right])) {
                dis++;
                counter.put(A[right], 0);
            }
            counter.put(A[right], counter.get(A[right]) + 1);
            while (dis > k) {
                counter.put(A[left], counter.get(A[left]) - 1);
                if (counter.get(A[left]) == 0) {
                    dis--;
                    counter.remove(A[left]);
                }
                left++;
            }
            ans += (right - left + 1);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int K = 2;
        System.out.println(dealK(nums, K));
    }
}
