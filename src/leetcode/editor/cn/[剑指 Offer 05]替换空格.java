package leetcode.editor.cn;

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 👍 184 👎 0

class TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            int len = s.length(), index = 0;
            char[] chars = new char[3 * len];
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    chars[index++] = '%';
                    chars[index++] = '2';
                    chars[index++] = '0';
                } else {
                    chars[index++] = c;
                }
            }
            //这句话的作用会自动的去掉char数组中多余的部分
            String str = new String(chars, 0, index);
            return str;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}