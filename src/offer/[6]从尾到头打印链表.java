package offer;

import java.util.Stack;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/3/3 3:09 下午
 * @description 剑指 Offer 06. 从尾到头打印链表
 */
class ReversePrint {
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

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
