package leetcode.editor.cn;

//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 字符串
// 👍 283 👎 0
// 遇见加号和减号，记录当前符号，然后对下一个数字进行入栈（+号入原数，-号入相反数）。
// 遇见乘法和除法，记录当前符号，对栈顶数字和当前数字进行相应运算，然后重新入栈。
// 全部遍历之后，栈中剩余的数字就是带符号的，已经运算完了乘除，只需要对剩余数字全部求和即可。

import java.util.Stack;

class BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            //3 - 20 * 5
            int len = s.length();
            int i = 0;
            Stack<Integer> nums = new Stack<>();
            int sign = 1;
            while (i < len) {
                if (s.charAt(i) == ' ') {
                    i++;
                    continue;
                } else if (s.charAt(i) == '+') {
                    i++;
                    sign = 1;
                } else if (s.charAt(i) == '-') {
                    i++;
                    sign = -1;
                } else if (s.charAt(i) == '*') {
                    i++;
                    sign = 2;
                } else if (s.charAt(i) == '/') {
                    i++;
                    sign = 3;
                } else {
                    int num = 0;
                    while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        num = (num * 10 + s.charAt(i) - '0');
                        i++;
                    }
                    if (sign == 1 || sign == -1) {
                        nums.push(num * sign);
                    } else if (sign == 2) {
                        nums.push(nums.pop() * num);
                    } else if (sign == 3) {
                        nums.push(nums.pop() / num);
                    }
                }
            }
            int ans = 0;
            while (!nums.empty()) {
                ans += nums.pop();
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}