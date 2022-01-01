package leetcode.editor.cn;

//写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。 
//
// 
//
// 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。 
//
// 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连
//续的数字字符组合起来，形成整数。 
//
// 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。 
//
// 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。 
//
// 在任何情况下，若函数不能进行有效的转换时，请返回 0。 
//
// 说明： 
//
// 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2³¹, 231 − 1]。如果数值超过这个范围，请返回 INT_MAX (231
// − 1) 或 INT_MIN (−2³¹) 。 
//
// 示例 1: 
//
// 输入: "42"
//输出: 42
// 
//
// 示例 2: 
//
// 输入: "   -42"
//输出: -42
//解释: 第一个非空白字符为 '-', 它是一个负号。
//     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
// 
//
// 示例 3: 
//
// 输入: "4193 with words"
//输出: 4193
//解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
// 
//
// 示例 4: 
//
// 输入: "words and 987"
//输出: 0
//解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
//     因此无法执行有效的转换。 
//
// 示例 5: 
//
// 输入: "-91283472332"
//输出: -2147483648
//解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 
//     因此返回 INT_MIN (−2³¹) 。
// 
//
// 
//
// 注意：本题与主站 8 题相同：https://leetcode-cn.com/problems/string-to-integer-atoi/ 
// Related Topics 字符串 👍 126 👎 0

/**
 *
 * 这句话也没啥讲的，就是要做很多方面的处理。注意一个比较取巧的地方就是判断溢出
 * int cur
 * res = cur * 10 + xx，在经过这句话之后，如果res溢出了。。。那么
 * res / 10 != cur。
 * 反之，如果res / 10 == cur那么说明没有溢出！！！
 *
 * 具体的处理细节可以看下边。
 */

class BaZiFuChuanZhuanHuanChengZhengShuLcof {
    public static void main(String[] args) {
        Solution solution = new BaZiFuChuanZhuanHuanChengZhengShuLcof().new Solution();
        System.out.println(solution.strToInt(" "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strToInt(String str) {
            //处理空格字符
            char[] chars = str.trim().toCharArray();
            //验证" "这种形式
            if (chars.length == 0) {
                return 0;
            }
            //默认第一个是符号位，因此数字起始位从1开始
            int start = 1;
            //默认是正数
            int sign = 1;
            //如果是负数，符号位变成-1，起始位是1
            if (chars[0] == '-') {
                sign = -1;
                start = 1;
            } else if (chars[0] != '+') {
                //假如第一位不是+，说明没有符号，那么起始位就从0开始，并且是正数
                sign = 1;
                start = 0;
            }
            //否则就是+的情况，此时sign和start都是1，正常处理
            int res = 0;
            for (int i = start; i < chars.length; i++) {
                //如果遇见非数字，退出，返回当前的res即可。
                if (chars[i] < '0' || chars[i] > '9') {
                    break;
                }
                //当前处理的字符变成数字
                int cur = chars[i] - '0';
                //res是前几位的结果，123。res是1，1 * 10 + 2变成12
                int temp = res * 10 + cur;
                //判断res是否越界就是看题解的判断方式。
                if (temp / 10 != res) {
                    //越界了
                    //越界根据正反返回Integer的上限和下限
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                res = temp;
            }
            return res * sign;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}