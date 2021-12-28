package leetcode.editor.cn;

//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 396 👎 0

/**
 *
 * 这道题的思路如下：
 * 对于一个[i,j]的序列，要将他分为三个区间，[left][right][root]，判断left的值是否都小于root，right的值是否都大于root
 * 如果不满足，说明不是序列，如果满足，对left，right分别进行递归的判断，是否满足上边的情况
 *
 * 具体流程：
 * [i,j]序列，num[j]一定是root元素，从i开始遍历，找到第一个大于root的元素，坐标为mid，即num[mid]>root。此时的[i, mid-1]为
 * left区间，[mid, j - 1]是right区间，因为我们在便利的是否left区间肯定是小于root的，因此无需判断了。
 * 记下来只需要判断right区间是不是都大于root。继续从mid向右遍历，找到第一个不大于root的值元素（其实这个元素就应该是root)，记为
 * right，那么如果right == j说明右侧区间是正确的。否则是非法的
 * 因此到这里判断出来了整体上[i,j]元素正确，因此接下来需要对子树进行同样的递归操作（整体上正确，但是子树可能内部是错误的），
 * 如果[i, mid - 1]&&[mid, j - 1]都是正确的，那么就是合法的，否则是非法的。
 *
 **/

class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return check(postorder, 0, postorder.length - 1);
        }

        public boolean check(int[] postorder, int i, int j) {
            if (i >= j) {
                return true;
            }
            //划分[i,j]出左子树和右子树
            int mid = i;
            //找到第一个大于root的值
            while (postorder[mid] < postorder[j]) {
                mid++;
            }
            int right = mid;
            //此时index的位置是第一个大于root的位置，按照此位置划分左右子树 左子树是[i, mid-1], 右子树是[mid, j - 1]
            //因为左子树一定是合法的（都小于root）
            //接下来判断右子树是否合法
            while (postorder[right] > postorder[j]) {
                right++;
            }
            //如果right能走到j，说明当前整体上左右子树是一个合法的，也就是左边小于root，右边大于root，此时就需要递归的判断左右子树分别是不是合法的（因为子树内部有可能是错的，只是当成整体在外层看起来是对的）
            if (right == j && check(postorder, i, mid - 1) && check(postorder, mid, j - 1)) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}