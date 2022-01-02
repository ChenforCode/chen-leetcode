package leetcode.editor.cn;

//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
//
// 注意：本题与主站 235 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-
//a-binary-search-tree/ 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 192 👎 0

/**
 * 这道题目直接看代码，注释比较详细
 */

class ErChaSouSuoShuDeZuiJinGongGongZuXianLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeZuiJinGongGongZuXianLcof().new Solution();
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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //如果pq同时小于root，说明pq都在root的左子树里，说明root.left有可能是pq的最近祖先，root已经没可能了，因为root.left比root更近于pq，因此交给root的左子树来判断
            if (p.val < root.val && q.val < root.val) {
                //这里不能直接写递归，而是要返回递归的结果
                //因为你在下层递归里边会找到结果并返回，这个结果就是最终的答案，如果你在这里不对返回结果做任何操作，那么就会继续往下走。走到这一个代码的return root，然后一层层的回去，回到最上层，所以每次返回的都是最初的那个root。因此得到了答案就无须走后边的路。直接返回即可。
                return lowestCommonAncestor(root.left, p, q);
            }
            //这里同理，如果都在右子树中，就交给右子树进行判断。
            if (p.val > root.val && q.val > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            //走到这里说明。pq已经被一层一层的左右剥离开，然后在这个root处被岔开，因此这个root就是他的最近祖先。返回即可
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}