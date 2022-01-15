package leetcode.editor.cn;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 2892 👎 0
/**
 *
 * 就是一个栈的应用题，遇见左括号入栈，遇见右括号则判断栈顶和右括号是否匹配，匹配则出栈，不匹配则false
 * 最后栈空为true，否则false
 */

import java.util.Stack;

class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                    stack.push(chars[i]);
                } else {
                    if (stack.empty()) {
                        return false;
                    }
                    if ((stack.peek() == '(' && chars[i] == ')') || (stack.peek() == '[' && chars[i] == ']') || (stack.peek() == '{' && chars[i] == '}')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
            return stack.empty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}