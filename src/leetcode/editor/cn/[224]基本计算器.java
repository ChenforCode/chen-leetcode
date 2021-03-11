package leetcode.editor.cn;

//实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 利用一个栈，栈顶的符号就是当前作用域（括号）的符号，例如当前1，符号就是默认的正号。
// 对于（4+5+2）他们这个整体前面的作用域符号为基础的1，再遇上一个正号，还是正号，入栈，
// 当遇到了）时候，4+5+2的作用域就结束了，栈顶的正号（就是4+5+2的符号）需要弹出。
//
//然后-3，这个负号的作用域就他自己，也不需要入栈出栈，直接为栈顶符号取反 + -3算出就可以了
//
//归根到底，就是对于单个数字，他的符号为前边的符号和栈顶符号计算所得。计算出来的符号无需入栈
//对于括号，括号内部的所有数字的符号，都是前边的符号和栈顶符号计算所得，但是需要入栈
//因为该符号的作用域是整个括号，整个括号内部数字的符号还会受到他的影响。直到遇到），将栈顶符号出栈
//举个例子 1 - (1 - (3 + 4))。
//初始化栈(1)，1 * 1(符号)，然后遇上-，当前的符号变成-1，遇到左括号，-1入栈，即在(1 - (3 + 4))
//运算结束之前都是-1，或者说里边的符号计算都要以-1为基础。然后遇到一个1，计算1 * -1(符号)。又遇到
//一个-，符号再次取反-1，变成1，遇到左括号(3 + 4)，1入栈，，说明（3 + 4）的计算都要以1为基础，然后
//计算3 + 4
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 393 👎 0

import java.util.Stack;

class BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new BasicCalculator().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            int sign = 1;
            Stack<Integer> stack = new Stack<>();
            stack.push(sign);
            int len = s.length();
            int i = 0, ans = 0;
            while (i < len) {
                if (s.charAt(i) == ' ') {
                    i++;
                    continue;
                } else if (s.charAt(i) == '+') {
                    sign = stack.peek();
                    i++;
                } else if (s.charAt(i) == '-') {
                    sign = -stack.peek();
                    i++;
                } else if (s.charAt(i) == '(') {
                    stack.push(sign);
                    i++;
                } else if (s.charAt(i) == ')') {
                    stack.pop();
                    i++;
                } else {
                    int num = 0;
                    while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        num = num * 10 + (s.charAt(i) - '0');
                        i++;
                    }
                    ans += (sign * num);
                }
            }
            return ans;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)