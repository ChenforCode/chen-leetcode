package _2021._02._0202._02;

import javax.swing.*;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/2/2 6:57 下午
 * @description 3. 无重复字符的最长子串
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
