package _2021._02._0202;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/2/2 5:13 下午
 * @description 424. 替换后的最长重复字符
 */
public class Solution {
    public static int characterReplacement(String s, int k) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        int left = 0, right = 0, curMax = 0, ans = 0;
        char[] chars = s.toCharArray();
        int[] times = new int[26];
        // [left, right) 内最多替换 k 个字符可以得到只有一种字符的子串
        while (right < len) {
            times[chars[right]-'A']++;
            //curMax是维护当前窗口中最多的一个字符数量，从而确定是替换其他字符
            curMax = Math.max(curMax, times[chars[right]-'A']);
            right++;
            //如果窗口内最多的字符数量+k还填不满窗口，那么说明窗口太大了，该左移了
            if (right - left - curMax > k) {
                times[chars[left] - 'A']--;
                left++;
            }
            //每次循环都记录一次窗口最大值
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }
}
