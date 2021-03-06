package leetcode.editor.cn;

//序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。 
//
//      _9_
//    /   \
//   3     2
//  / \   / \
// 4   1  #  6
/// \ / \   / \
//# # # #   # #
// 
//
// 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。 
//
// 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。 
//
// 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。 
//
// 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。 
//
// 示例 1: 
//
// 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
//输出: true 
//
// 示例 2: 
//
// 输入: "1,#"
//输出: false
// 
//
// 示例 3: 
//
// 输入: "9,#,#,1"
//输出: false 
// Related Topics 栈 
// 👍 200 👎 0
/**
 * 在这里，我们认为，一个根节点可以提供两个位置，#消耗一个位置，一个非根的数字节点消耗
 * 一个位置，提供两个位置，直接认为提供一个位置。
 * 前序遍历的顺序为根，左，右，所以我们认为，在整个遍历的过程中，剩余的位置不能为0，否则
 * 会出现根挂上去了，但是左右树没地方挂，那么一定是非法的。
 *
 * 还有一种思路是，采用递归的思想，判断一个树是否合法，先判断左树合法，然后右树合法，最后根合法
 *
 * 然后这个思路可以用栈完成，加入序列中出现一个 [x##]的情况，那么这个点一定是一个合法的叶节点
 * 我们把这个合法的叶节点缩写成为#，然后继续判断，如下
 *
 * 4 3 # # 5 # #
 *
 * 入栈 4 3 # #，遇到了3##则弹出，再入栈一个#代替，变成4 #继续入栈
 * 4 # 5 # #，遇到了5##则弹出，再入栈一个#代替，变成4 # #，然后弹出，入栈一个#
 *
 * 最终如果栈内只有一个#，则是合法的。这个过程就是先遍历的根（4），但是根的左右树是否合法不知道
 * 需要先把根入栈，然后对根的左树判断，左树入栈，3##合法，然后判断根的右树，右树入栈，4##合法
 * 最后左右树都合法之后，再回来判断根4##。
 *
 *
 **/

class VerifyPreorderSerializationOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new VerifyPreorderSerializationOfABinaryTree().new Solution(); 
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSerialization(String preorder) {
        //由于每个根节点都消耗一个位置，提供两个位置，所以看成提供一个位置。
        //但是由于root节点可以提供两个位置，所以需要预先给他初始化为1，然后走到下边
        //判断他是根节点，再+1，就是root的2，其余根节点均走数字即可。
        int slot = 1;
        int len = preorder.length();
        int i = 0;
        char[] chars = preorder.toCharArray();
        //对序列进行遍历
        while (i < len) {
            //如果在遍历完成之前，位置就被用完了，说明不能挂新的节点，肯定是非法的
            if (slot == 0) {
                return false;
            }
            if (chars[i] == ',') {
                i++;
            } else if (chars[i] == '#') {
                //#单纯消耗一个位置
                slot--;
                i++;
            } else {
                //读取出当前的数字
                while (i < len && chars[i] >= '0' && chars[i] <= '9') {
                    i++;
                }
                //数字提供一个位置（第一次进来和初始值为1，在这+1，代表根节点是提供2个位置）
                //除此之外剩余的子根节点都只加一个
                slot++;
            }
        }
        //到最后如果所有位置均被用完，则是合法的
        return slot == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}