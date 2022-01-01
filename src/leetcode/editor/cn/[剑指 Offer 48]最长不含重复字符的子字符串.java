package leetcode.editor.cn;

//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 338 👎 0

/**
 *
 * 这道题官方用的是dp，但是自己第一个想到的是滑动窗口，即用(left, right)维护一个窗口，
 * 然后用hashset来辅助判断当前窗口内元素的重复状况，如果right不在set内，说明可以将right
 * 加入set，然后right后移。如果right在set内，就将left左移，并在map中移除left对应的元素
 * right每走一步都更新当前的res，如果right走到头了，搜索结束。返回res即可
 */

import java.util.*;

class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || "".equals(s)) {
                return 0;
            }
            char[] ss = s.toCharArray();
            int left = 0, right = 0;
            Set<Character> set = new HashSet<>();
            int res = -1;
            while (right < ss.length) {
                //如果右指针不在set，就能将该值加入窗口，更新结果，更新set
                if (!set.contains(ss[right])) {
                    set.add(ss[right]);
                    right++;
                    res = Math.max(res, right - left);
                } else {
                    //如果右指针在的话，就有用左指针缩小窗口，更新set
                    set.remove(ss[left]);
                    left++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}