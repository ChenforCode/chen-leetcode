package _2021._02._0202.yy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/2/3 10:26 上午
 * @description abc
 */
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        Set<Character> charSet = new HashSet<>();
        int maxLength = 0;
        for (; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, charSet.size());
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "qrsvbspk";
        System.out.println(lengthOfLongestSubstring(s));
    }
}