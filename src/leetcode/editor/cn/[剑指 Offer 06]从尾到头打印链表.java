package leetcode.editor.cn;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 211 👎 0

import java.util.Stack;

class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int[] reversePrint(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            int count = 0;
            while (head != null) {
                count++;
                stack.push(head.val);
                head = head.next;
            }
            int[] res = new int[count];
            while (!stack.empty()) {
                for (int i = 0; i < res.length; i++) {
                    res[i] = stack.pop();
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}