package offer;

//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 
// 👍 100 👎 0
/**
 *
 * 1、这道题目需要按层打印，也就是每一层要单独存储，因此如何判断是否在同一层了，所以我们就想到了用深搜
 * 的depth来代替层数，深度一样的，肯定就是在同一层。
 * 2、我们的深搜采用前序遍历的方式，在拿到该跟节点之后，遍历左子树，然后遍历右子树。这样会保证每一层
 * 搜出来的数字，一定是左侧在前右侧在后。即 第二层是1 2 3，那么1在最左边一定会首先搜到。其次是2 3
 *
 * 然后我觉得这道题用bfs来做也可以，记录每一个节点的步数，下一层的步数是当前层+1，类似于迷宫广搜
 * 求最短步数。
 *
 **/

import java.util.ArrayList;
import java.util.List;

class CongShangDaoXiaDaYinErChaShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
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
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            dfs(root, 1);
            return res;
        }

        void dfs(TreeNode curNode, int depth) {
            if (curNode == null) {
                return;
            }
            //第一次进入是depth = 1，但是里边还没有任何的列表，需要新建一个列表。这个时候1=1
            //一直到进入到第二层，1 < 2，需要建第二个列表，所以我们知道depth和size最多差一个
            //递归到第n层，如果只有n - 1个列表是不够的，这个时候就需要新加一个列表来存储了
            if (res.size() < depth) {
                res.add(new ArrayList<>());
            }
            //列表够了之后，我们用depth当坐标来获取当前层要存储的列表。
            List<Integer> curRes = res.get(depth - 1);
            curRes.add(curNode.val);
            dfs(curNode.left, depth + 1);
            dfs(curNode.right, depth + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}