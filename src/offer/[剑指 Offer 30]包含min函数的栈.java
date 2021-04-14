package offer;

//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。 
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
// Related Topics 栈 设计 
// 👍 121 👎 0

/**
 *
 * 除了一个正常的栈A来存储元素外
 * 另外一个栈B用来维护A的最小值。
 *  入栈，A入栈，如果B空，或者入栈的元素<= B.top()。B也入栈该元素
 *  出栈，A出栈，如果A出栈的元素和B.top()相等，B也出栈
 *
 * 例子：A入 9 10 7 3 5
 *      B入 9 7 3
 *
 *      A出 5 3
 *      B出 3
 *
 *      A出 7
 *      B出 7
 *
 **/

import java.util.Stack;

class BaoHanMinhanShuDeZhanLcof {
    public static void main(String[] args) {

//        Solution solution = new BaoHanMinhanShuDeZhanLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        Stack<Integer> a;
        Stack<Integer> b;
        /**
         * initialize your data structure here.
         */
        public MinStack() {
            a = new Stack<>();
            b = new Stack<>();
        }

        public void push(int x) {
            a.push(x);
            //这里为什么不是小于呢，是保证，进入一个2 2，b也进入一个2 2，这样当弹出一个2的时候
            //剩下的一个2仍然是最小值。。
            //如果a进22，b用小于那就只能进一个2，弹出一个2之后，最小值还应该是2，但是b的top已经
            //没有2了
            if (b.empty() || x <= b.peek()){
                b.push(x);
            }
        }

        public void pop() {
            int res = a.pop();
            if (b.peek() == res) {
                b.pop();
            }
        }

        public int top() {
            return a.peek();
        }

        public int min() {
            return b.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}