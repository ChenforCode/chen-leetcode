package offer;

//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
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
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 82 👎 0

/**
 *
 * 这道题采用BFS的方式，从root入队列，然后队头出队列，用队头的左右子树入队列，直到队列空。每次队
 * 头的元素就是打印的顺序。即队列的顺序
 *
 **/

import java.util.*;
import java.util.stream.Collectors;

class CongShangDaoXiaDaYinErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
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
        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[0];
            }
            Queue<TreeNode> queue = new LinkedList<>();
            List<Integer> nums = new ArrayList();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                nums.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            int[] res = new int[nums.size()];
            for (int i = 0; i < nums.size(); i++) {
                res[i] = nums.get(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}