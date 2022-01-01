package leetcode.editor.cn;

//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// Related Topics 数组 前缀和 👍 178 👎 0

/**
 * 这道题用简单的循环来做的的话就是每次都将这个数之外的其他数字全部乘一遍，但是这样肯定会超时
 * 因此用dp的方式，或者类似于一个前缀积的方式将1*2 1*2*3类似的结果保存起来
 * 对于一个 1 2 3 4 5 6 7
 * 以b[3]即以4来分割，他的计算方式是算出1*2*3和5*6*7
 * 以b[2]即以3来分割，就是就散1*2和4*5*6*7
 * 因此我们可以用两个数组分别存储前半部分的积和后半部分的积
 * 设定dp1来存储前半部分的结果。因为b[0] = 2 * 3 * 4...因此我们让dp1[0] = 1做一个占位符
 * dp[1] = dp[0] * 1(a[0])。此时dp[1]可以看作是从1算到dp[0]的乘积
 * 因此dp[i] = dp[i - 1] * a[i - 1]
 *
 * 设定dp2来存储后半部分的结果，因为b[-1] = 6 * 5 * 4...因此我们让dp2[-1] = 1做一个占位符
 * dp[-2] = dp[-1] * a[-1]。此时dp[-2]看作是dp[-1] * 1。dp[-3]就是1-dp[-2]
 *
 * 然后计算完毕，再来一次循环计算b，即b[i] = dp1[i] * dp2[i]
 *
 * 对于12345算出来的
 *       占位 1 12 123 1234
 * dp1 = [1, 1, 2, 6, 24]
 *       5432  543 54  5  占位
 * dp2 = [120, 60, 20, 5, 1]
 */

class GouJianChengJiShuZuLcof {
    public static void main(String[] args) {
        Solution solution = new GouJianChengJiShuZuLcof().new Solution();
        solution.constructArr(new int[]{1, 2, 3, 4, 5});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArr(int[] a) {
            if (a == null || a.length == 0) {
                return a;
            }
            int[] temp1 = new int[a.length];
            int[] temp2 = new int[a.length];
            int[] b = new int[a.length];
            temp1[0] = 1;
            for (int i = 1; i < a.length; i++) {
                temp1[i] = temp1[i - 1] * a[i - 1];
            }
            temp2[a.length - 1] = 1;
            for (int i = a.length - 2; i >= 0; i--) {
                temp2[i] = temp2[i + 1] * a[i + 1];
            }
            for (int i = 0; i < a.length; i++) {
                b[i] = temp1[i] * temp2[i];
            }
            return b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}