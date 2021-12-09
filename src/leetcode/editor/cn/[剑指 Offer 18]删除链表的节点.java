package leetcode.editor.cn;

//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。 
//
// 返回删除后的链表的头节点。 
//
// 注意：此题对比原题有改动 
//
// 示例 1: 
//
// 输入: head = [4,5,1,9], val = 5
//输出: [4,1,9]
//解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
// 
//
// 示例 2: 
//
// 输入: head = [4,5,1,9], val = 1
//输出: [4,5,9]
//解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
// 
//
// 
//
// 说明： 
//
// 
// 题目保证链表中节点的值互不相同 
// 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点 
// 
// Related Topics 链表 
// 👍 101 👎 0

class ShanChuLianBiaoDeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new ShanChuLianBiaoDeJieDianLcof().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            //如果删除的是头结点，那么头结点后移即可。
            if (head.val == val) {
                if (head.next == null) {
                    head = null;
                } else {
                    head = head.next;
                }
                return head;
            }
            //如果删除的不是头结点，那么最少有两个节点。
            //cur指向第二个，pre指向第一个
            ListNode curNode = head.next;
            ListNode preNode = head;
            //然后二者一直后移找到cur为当前的
            while (curNode.val != val) {
                preNode = curNode;
                curNode = curNode.next;
            }
            //找到之后为 pre -> cur -> cur.next
            //所以直接pre.next = cur.next即可。不管cur.next是不是空都可以
            preNode.next = curNode.next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}