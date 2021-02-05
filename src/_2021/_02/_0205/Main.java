package _2021._02._0205;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/2/5 10:02 下午
 * @description 1208. 尽可能使字符串相等
 */
public class Main {
    public static int equalSubstring(String s, String t, int maxCost) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int curCost = 0, maxSize = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            curCost += Math.abs(chars[right] - chart[right]);
            if (curCost > maxCost) {
                curCost -= Math.abs(chars[left] - chart[left]);
                left++;
            }
            maxSize = Math.max(maxSize, right - left + 1);
            //这个地方必须是在right加之前才能计算，因为在right移动之前的窗口是整好满足要求的。
            //right++的意思是尝试进行下一次扩张了，但是这次扩张有可能是失败的。
            right++;
        }
        return maxSize;
    }

    public static void main(String[] args) {
        String s = "abcd", t = "bcdf";
        int cost = 3;
        System.out.println(equalSubstring(s, t, cost));
    }
}
