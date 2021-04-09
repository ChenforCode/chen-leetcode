package offer;

//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表 
// 👍 211 👎 0

class FanZhuanLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();
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
        public ListNode reverseList(ListNode head) {
            //当前节点
            ListNode cur = head;
            //前面的节点，最后要返回
            ListNode pre = null;
            while (cur != null) {
                //先把后边的节点保存起来
                ListNode next = cur.next;
                //然后cur的指向反向，指向pre
                cur.next = pre;
                //以上两步就完成了两个节点的反转，这个时候需要后移pre和cur，pre指向cur的位置
                pre = cur;
                //cur需要指向原来cur的下一个位置，也就是next，已经提前保存了
                cur = next;
            }
            //这一步cur为null，走到结尾，pre就是null的前一个，也就是原链表的最后一个节点，现在是头节点了。
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}