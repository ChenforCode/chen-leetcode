package leetcode.editor.cn;

//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。 
//
// 
//
// 示例 1： 
//
// 输入: n = 3
//输出: 6
// 
//
// 示例 2： 
//
// 输入: n = 9
//输出: 45
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10000 
// 
// Related Topics 位运算 递归 脑筋急转弯 👍 417 👎 0

/**
 *
 * 这道题的思路是使用递归来做。常规的递归应该是如下
 *         int res = 0
 *         public int sumNums(int n) {
 *             if (n == 1) {
 *                 return 1;
 *             }
 *             res += sumNums(n - 1);
 *             return res;
 *         }
 * 但是这道题不让使用if语句，那么我们用&&的短路效应来写这道题，
 * 把终止递归的条件改成-->boolean x = ((n > 1) && sumNums(n - 1) > 0);
 * 这个条件简化成为就是 n > 1 && sumNums(n - 1)。意思是如果n > 1就会进入到下层循环
 * 如果n == 1了，左边的条件为false，后边的条件都不会走了。写成上边样子的原因是
 * 1、boolean x的意思是，刚才的表达式不能独立存在，必须使用一个var进行保存
 * 2、sumNums(n - 1)返回的是一个整数，不能参与boolean的判断。
 *
 * 所以如下代码的的运行逻辑就是。sumNums(3) -> sumNums(2) -> sumNums(1)
 * 递归停止执行res += 1,return res;返回到sumNums(2)内
 * 执行res += 2，return res，返回到sumNums(3)内
 * 执行res += 3，return res，结束。算完了res + 1 + 2 + 3得到结果
 *
 */

class Qiu12nLcof {
    public static void main(String[] args) {
        Solution solution = new Qiu12nLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = 0;

        public int sumNums(int n) {
            boolean x = ((n > 1) && sumNums(n - 1) > 0);
            res += n;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}