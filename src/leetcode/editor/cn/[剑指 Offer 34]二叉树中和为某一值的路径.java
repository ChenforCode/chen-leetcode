package leetcode.editor.cn;

//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 271 👎 0
/**
 *
 * 就是一个深度搜索的问题，需要记录当前的走的路径，当前的和，然后进到某个节点之后
 * 把当前节点加入路径，重新计算和。然后等这个节点走完之后，需要将这个节点从路径里挪走
 **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<Integer> curRes = new ArrayList<>();
            dfs(root, 0, curRes, target);
            return res;
        }

        public void dfs(TreeNode node, int curSum, List<Integer> curRes, int target) {
            if (node == null) {
                return;
            }
            //加入当前值
            curSum += node.val;
            //在这里就加入的node，代表该函数执行期间，已经加入了这个路径，因此不管这个路径会产生什么样的结果，都应该删除这个节点。
            curRes.add(node.val);
            if (curSum == target && node.left == null && node.right == null) {
                List<Integer> copyRes = new ArrayList<>(curRes.size());
                copyRes.addAll(curRes);
                res.add(copyRes);
                //这里两种解释：
                //1、这里如果不删除，那么走了return，就走不到下边的remove了，意思是本次函数没有执行remove操作。
                //2、这里如果是一个左节点搜索，结束了不删除，那么当前curRes是一个满状态，然后回退，走到上一层的右搜索
                //理论上右搜索是不能有当前的左节点的，是应该以父节点为基础搜索的。但是当前curRes是一个满状态，也就是
                //包含了左节点。因此这里需要将这个节点删掉。恢复成父节点的状态。
                curRes.remove(curRes.size() - 1);
                return;
            }
            //意思是以当前节点加入路径为基础，继续往下扩充左和右。
            dfs(node.left, curSum, curRes, target);
            dfs(node.right, curSum, curRes, target);
            //左和右搜完之后，这个节点就没价值了，把这个节点从路径里移走。
            curRes.remove(curRes.size() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}