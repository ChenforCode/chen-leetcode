package leetcode.editor.cn;

//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。 
//
// 例如： 
//
// 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-
//tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 157 👎 0

/**
 *
 * 就是简单地深搜，每进一层递归就增加一次深度，然后到达null节点的时候更新一下深度最大值即可
 **/

class ErChaShuDeShenDuLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeShenDuLcof().new Solution();
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
        int max = -1;

        public int maxDepth(TreeNode root) {
            dfs(root, 0);
            return max;
        }

        public void dfs(TreeNode node, int depth) {
            if (node == null) {
                max = Math.max(max, depth);
                return;
            }
            depth = depth + 1;
            dfs(node.left, depth);
            dfs(node.right, depth);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}