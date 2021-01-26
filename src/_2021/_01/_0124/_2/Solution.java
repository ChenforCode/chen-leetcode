package _2021._01._0124._2;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/1/24 11:09 上午
 * @description 第二题
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode h = head;
        boolean jinwei = false;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (jinwei) {
                sum++;
            }
            h.next = new ListNode(sum % 10);
            h = h.next;
            jinwei = (sum >= 10);
        }
        if (jinwei) {
            h.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
