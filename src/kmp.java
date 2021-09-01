/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/4/20 6:25 下午
 * @description kmp
 */
public class kmp {

    public static void main(String[] args) {
        String str = "", ptr = "";
        int index = kmpMatch(str, ptr);
    }

    private static int kmpMatch(String str, String ptr) {
        int n = str.length(), m = ptr.length();
        char[] s = str.toCharArray();
        char[] p = ptr.toCharArray();
        //获取模式串的next数组
        int[] next = new int[m];
        int j = -1;
        next[0] = j;
        for (int i = 1; i < m; i++) {
            while (j >= 0 && p[i] != p[j + 1]) {
                j = next[j];
            }
            if (p[i] == p[j + 1]) {
                j++;
            }
            next[i] = j;
        }

        //开始匹配
        j = -1;
        for(int i = 0; i < n; i++) {
            while (j >= 0 && s[i] != s[j + 1]) {
                j = next[j];
            }
            if (s[i] == s[j + 1]) {
                j++;
            }
            if (j == (m - 1)) {
                return i - m + 1;
            }
        }
        return -1;
    }

}
