package offer;

//请完成一个函数，输入一个二叉树，该函数输出它的镜像。 
//
// 例如输入： 
//
// 4 
// / \ 
// 2 7 
// / \ / \ 
//1 3 6 9 
//镜像输出： 
//
// 4 
// / \ 
// 7 2 
// / \ / \ 
//9 6 3 1 
//
// 
//
// 示例 1： 
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/ 
// Related Topics 树 
// 👍 125 👎 0

/**
 *
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 我们选择直接交换4的左右子树。。然后对左右子树进行同样的操作即可，类似于前序遍历
 **/

class ErChaShuDeJingXiangLcof {
    public static void main(String[] args) {

        Solution solution = new ErChaShuDeJingXiangLcof().new Solution();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        solution.mirrorTree(treeNode);

    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        swap(root);
        return root;
    }
    public void swap(TreeNode root) {
        if (root == null) {
            return;
        }
        //交换当前树的左子树和右子树。
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        //递归去交换左子树中的左右子树。
        swap(root.left);
        //递归去交换右子树中的左右子树。
        swap(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}