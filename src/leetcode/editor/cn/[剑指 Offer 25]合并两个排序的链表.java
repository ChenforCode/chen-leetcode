package leetcode.editor.cn;

//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 分治算法 
// 👍 106 👎 0

class HeBingLiangGePaiXuDeLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode cur = head;
            while (l1 != null && l2 != null) {
                //如果l1小，就加入到总链表中，然后l1后移
                if (l1.val <= l2.val) {
                    ListNode node = new ListNode(l1.val);
                    cur.next = node;
                    l1 = l1.next;
                } else {
                    //如果l2小，就加入到总链表中，然后l2后移
                    ListNode node = new ListNode(l2.val);
                    cur.next = node;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            //跳出循环后，看谁还没有遍历完，就把他直接加入总链表（这个时候另外一个已经全部遍历完了）
            if (l1 == null) {
                cur.next = l2;
            } else {
                cur.next = l1;
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}