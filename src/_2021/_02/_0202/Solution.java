package _2021._02._0202;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/2/2 5:13 下午
 * @description 424. 替换后的最长重复字符。
 * 利用一个左右指针，每次都尝试对右指针右移一次，然后判断当前窗口内当前最多的字符+k
 * 是否会小于窗口大小（如果小于了，说明窗口太大，k不够用），此时需要缩小窗口，也就是
 * 将左指针右移，然后就又可以继续开始移动右指针。然后需要利用一个频率数组记录当前窗口
 * 内所有字符的频率。在整个过程中记录整个窗口的最大值。
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
