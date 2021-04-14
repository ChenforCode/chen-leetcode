package offer;

//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈
//的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。 
//
// 
//
// 示例 1： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true
//解释：我们可以按以下顺序执行：
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// 示例 2： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//输出：false
//解释：1 不能在 2 之前弹出。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= pushed.length == popped.length <= 1000 
// 0 <= pushed[i], popped[i] < 1000 
// pushed 是 popped 的排列。 
// 
//
// 注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/ 
// 👍 163 👎 0

/**
 *
 * 我们采用一个栈，来模拟入栈和出栈的过程
 *
 * [1,2,3,4,5] 入栈
 * [4,5,3,1,2] 出栈
 *
 * 1、现有一个栈，按照入栈顺序入栈1 2 3 4
 * 2、4入栈之后，发现栈顶和出栈值相等，则出栈变成1 2 3，然后3和下一个出栈元素5不相等，继续入栈
 * 3、5入栈->1235，发现栈顶和出栈序列相等，则5出栈->123。3和下一个出栈元素相等继续出栈，->12。
 * 4、接下来剩余的出栈元素1和当前栈顶2不相等。。所以接下来无法出栈。即模拟栈stack不能为空，说明
 * 出栈顺序不合理。因为1不可能先于2出栈。
 *
 *
 * 所以算法过程，入栈顺序正常入栈，每次入栈之后就，判断栈顶和和出栈元素是否相等，相等则出栈，一直相等
 * 一直出栈（这里主要是保证正确的出栈顺序，能出栈就立即出栈）。最后入栈完了之后，如果栈能弹完就说明
 * 是合理的顺序
 *
 **/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class ZhanDeYaRuDanChuXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZhanDeYaRuDanChuXuLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int len = pushed.length;
            //出栈的索引
            int index = 0;
            //依次入栈
            for (int i = 0; i < len; i++) {
                stack.push(pushed[i]);
                //每次入栈完之后就，按照出栈的顺序循环出栈（如果出栈顺序当前的元素和栈顶相等
                // 就可以出栈）
                while (!stack.empty() && stack.peek() == popped[index]) {
                    stack.pop();
                    index++;
                }
            }
            //栈空则合理
            return stack.empty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}