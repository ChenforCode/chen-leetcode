package _2021._02._0202._02;

import java.util.HashSet;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/2/2 6:57 下午
 * @description 3. 无重复字符的最长子串。
 * 利用左右指针，左指针每挪一个，都需要持续的移动右指针，右指针的的移动条件是
 * 没有到达边界，并且新入的字符没有在当前窗口中出现。右指针每次移动都有可能会
 * 多次移动，当右指针不能移动的时候，就需要移动一次左指针，然后在整个过程中记录
 * 窗口的最大值。
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        HashSet<Character> set = new HashSet<>();
        int ans = 0, len = s.length();
        while (right < len) {
            if (left != 0) {
                set.remove(chars[left - 1]);
            }
            while (right < len && !set.contains(chars[right])) {
                set.add(chars[right]);
                right++;
            }
            ans = Math.max((right - left), ans);
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
