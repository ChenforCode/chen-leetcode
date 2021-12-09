package leetcode.editor.cn;

//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 
// 👍 252 👎 0


/**
 *
 * 这道题的几个点，
 * 1、如果B是A的子树，那么B的根节点一定是A中的某个节点。
 * 2、因此我们需要首先遍历A中节点，如果找到了
 * 一个节点值和B的root节点相等，那么将从A的这个节点开始，正式判定B是否为A的子树，此时的A记为A1。
 * 3、判定过程就是，首先判断A1的根是否和B相等，然后判断A1左和B左，A2左和B左。递归判断。直到B空都
 * 没有返回false，那么B就是A的子结构。
 **/

class ShuDeZiJieGouLcof {
    public static void main(String[] args) {
        Solution solution = new ShuDeZiJieGouLcof().new Solution();
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
        //这个函数的作用是对A树进行先序遍历，找到一个节点值与B的root相等
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            //如果A空B空肯定都不对，返回false
            if (A == null || B == null) {
                return false;
            }
            //这里是找到了当前的A和B的根节点相等，然后需要进一步对比B到底是不是A的子结构，具体的对比方法
            //就是上述说的，A左比B左，A右比A右。如果当前值相等，并且下一步比较也正确，才能返回true
            if (A.val == B.val && help(A, B)) {
                return true;
            }
            //否则就只能对A树进行先序遍历，继续寻找其他的与Broot相等的节点。。
            //这里取或的意思是，只要有一个为true就是true。。全是false才是false。
            //只要A的左右树中有任意一个节点满足上述要求，就符合题意返回true。A的左树还会继续分出来左右树，递归遍历
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        //已知A的root和B的root已经相等，就是上边函数能够进来的条件！，然后需要继续比对她俩下方的节点是否正确
        public boolean help(TreeNode A, TreeNode B) {
            //如果B被比到空了，说明B在比对过程中没有出错，没有被返回false，说明B确实是子结构（有false的话会提前返回）
            if (B == null) {
                return true;
            }
            //如果比对的过程中A没了，就说明A包含不了B，所以B不可能是A的结构。
            if (A == null) {
                return false;
            }
            //AB节点不同也是false
            if (A.val != B.val) {
                return false;
            }
            //对比各自的左树和右树。
            return help(A.left, B.left) && help(A.right, B.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}