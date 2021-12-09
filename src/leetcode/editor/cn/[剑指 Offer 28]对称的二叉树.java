package leetcode.editor.cn;

//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
// 1 
// / \ 
// 2 2 
// / \ / \ 
//3 4 4 3 
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
// 1 
// / \ 
// 2 2 
// \ \ 
// 3 3 
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/ 
// Related Topics 树 
// 👍 159 👎 0

/**
 *
 * 首先我们认为两个点对称的条件是，二者全为空，那就是对称。有一个为空，就不是对称。
 * 二者的值是相等的，是对称。
 * 除此之外，相比的两个点必须是对称的，比如说如下结构。如果已经确定2 5是对称的。那么
 * 下一步要确定2的3和5的3是对称的，并且2的4和5的4是对称的。所以要递归判定
 * duichen(left.left, right.right) && duichen(left.right, right.left)
 * 入口就是从root的left和right开始
 *     1
 *    / \
 *   2   5
 *  / \ / \
 * 3  4 4  3
 **/


class DuiChengDeErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new DuiChengDeErChaShuLcof().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            //树是空，对称
            if (root == null) {
                return true;
            }
            //从树的第一次，左子树和右子树开始遍历
            return search(root.left, root.right);
        }

        public boolean search(TreeNode left, TreeNode right) {
            //如果两个点都是null，符合
            if (left == null && right == null) {
                return true;
            }
            //其中一个为空或者值不相等，就不符合
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            //走到这里当前已经是符合的了，但是整体符不符合还要接着看下边的搜索过程
            //因为必须是这两个点符合，并且他们的子点也符合才能返回true，所以这里不能
            //直接判断二点符合就返回true，所以最终的结果交给了下边
            //递归判定
            return search(left.left, right.right) && search(left.right, right.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}