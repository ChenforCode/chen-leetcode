package offer;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/3/1 10:55 下午
 * @description 剑指 Offer 05. 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 */
class replaceSpace {
    public static String replaceSpace(String s) {
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

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
