package _2021._02._0221;

import java.util.TreeMap;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/2/21 9:29 上午
 * @description 1438. 绝对差不超过限制的最长连续子数组
 * 这道题的关键就是滑窗滑动，然后保持滑窗内部元素的最大值最小值相差不能超过limit，但是顺序遍历
 * 求最值会超时。所以采用了内部有序的数据结构treemap，key存储num，value存储个数就好了。最左端
 * 就是map中的最小值，最右端就是最大值。这道题里也可以直接用c++的muliset，sortlist之类的，直接
 * 进去就会自动排序
 */
public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0, right = 0, ans = 0;
        int len = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (right < len) {
            //加入right
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                //取消left
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left  + 1);
            right++;
        }
        return ans;
    }
}
