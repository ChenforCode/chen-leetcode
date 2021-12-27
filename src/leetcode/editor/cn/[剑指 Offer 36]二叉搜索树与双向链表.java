package leetcode.editor.cn;

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。 
//
// 
//
// 为了让您更好地理解问题，以下面的二叉搜索树为例： 
//
// 
//
// 
//
// 
//
// 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是
//第一个节点。 
//
// 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。 
//
// 
//
// 
//
// 
//
// 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。 
//
// 
//
// 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
//to-sorted-doubly-linked-list/ 
//
// 注意：此题对比原题有改动。 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 链表 二叉树 双向链表 👍 365 👎 0

/**
 *
 *
 * 这道题的的题意是，将一个二叉搜索树变成一个递增的循环队列，也即对二叉搜索树进行一个中序遍历
 * 然后在遍历的过程中，将cur表示当前节点，pre等于上个节点。将cur和pre构建出来一个双端关系
 *
 * 如果pre为空，说明当前的cur是一个head节点，那么需要单独处理
 * pre.right = cur
 * cur.left = pre
 *
 * 但是有个特殊情况要处理，就是当pre为空的时候说明当前的cur是链表的head节点
 * 此时pre就不需要指向head了，就让head的left指向一个空即可，因此代码如下
 *
 *             if (pre != null) {  //pre不为空，让pre的right指向cur
 *                 pre.right = cur;
 *             } else {
 *                 head = cur;      //确定head节点
 *             }
 *             cur.left = pre;  //不管pre是个什么，都让cur的left指向pre
 *
 * 当遍历结束之后，pre指向链表的最后一个节点，此时将pre和head进行互相指向即可
 *即pre.right = head
 * head.left = pre
 **/

class ErChaSouSuoShuYuShuangXiangLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuYuShuangXiangLianBiaoLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    class Solution {
        private Node pre, head;

        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            dfs(root);
            pre.right = head;
            head.left = pre;
            return head;
        }

        public void dfs(Node cur) {
            if (cur == null) {
                return;
            }
            dfs(cur.left);
            if (pre != null) {
                pre.right = cur;
            } else {
                head = cur;
            }
            cur.left = pre;
            pre = cur;
            dfs(cur.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}