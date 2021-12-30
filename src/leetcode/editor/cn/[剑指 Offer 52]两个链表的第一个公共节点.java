package leetcode.editor.cn;

//输入两个链表，找出它们的第一个公共节点。 
//
// 如下面的两个链表： 
//
// 
//
// 在节点 c1 开始相交。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, 
//skipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
// 
//
// 
//
// 注意： 
//
// 
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-
//lists/ 
// 
// Related Topics 哈希表 链表 双指针 👍 407 👎 0

/**
 *
 * 暂时用两种方案吧，第一种方案比较巧，不容易想，但看完也能明白。
 * 方案2：nodea和nodeb同时从heada和headb出发，各自一步一步的走，
 * 如果谁走到了链表末尾，就将该节点重置到对方的head，继续走，直到二者相等。
 * 即：nodea如果到了链表末尾，nodea=headb继续走。nodeb到了链表末尾，nodeb=heada继续走
 *
 * 这样为什么会相遇呢？设链表a的自己不重合的长度为a，b的不重合长度为b，二者重合的长度为c
 * nodea走a+c步会走到自己的末尾，然后换到链表b上去，走一个b长度就会到达重合位置，即走了a+c+b
 *
 * 同理nodab走b+c步会到自己的末尾，然后换到链表a上去，走一个a的长度就会到达重合位置，即走了b+c+a
 * 二者走的步数一样，也就会同时到达这个地方。
 *
 * 但是为什么用node == null来判断末尾而不是node.next==null。这里主要是为了判断二者不相交的情况
 * 我们可以把两个不想交的链表，看做最相交一个null，这样，两个node在各自走完两个链表之后，会在对方链表
 * 的最末尾的null停下，都是null，也就是相等了，直接跳出循环。。否则二者会一直在两个链表之间循环。
 *
 * 这样是不是会影响相交的链表呢？不会，因为如果链表相交，两个节点会在同时到达最后对方的的null之前相交。这个最后的null
 * 不是走完自己的null，而是走完自己的null之后又走完了另一个链表。
 *
 * 也即是说，相交的过程一定发生在走完自己，然后走对方的时候。然后真正的相交一定先于null相交，因为null
 * 相交一定在最末尾，也就是把对方也走完了。
 *
 * 方案2：因为相交的长度是一样的，这样可以分别遍历一下两个链表，看那个链表长，例如a b链表，
 * a比b长了x，那么让b先走x，然后二者一起走，然后走到一个相等的停下即可
 */

class LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA, b = headB;
            while (a != b) {
                if (a == null) {
                    a = headB;
                } else {
                    a = a.next;
                }
                if (b == null) {
                    b = headA;
                } else {
                    b = b.next;
                }
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}