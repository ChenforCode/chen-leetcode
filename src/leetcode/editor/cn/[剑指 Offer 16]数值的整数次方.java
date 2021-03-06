package leetcode.editor.cn;

//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ）。不得使用库函数，同时不需要考虑大数问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2⁻² = 1/2² = 1/4 = 0.25 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -2³¹ <= n <= 2³¹-1 
// -10⁴ <= xⁿ <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 数学 👍 225 👎 0

/*
 * 快速幂。对于 5 ^ 9 我们可以看成 5 ^ 1001，也就是5 ^ 8 * 5 ^ 1
 *
 * 而1 2 4 8 16次方我们都可以快速求出例如。5是5^1，5 * 5 = 5 ^ 2, 5 ^ 2 * 5 ^ 2 = 5 ^ 4
 *
 * 所以5 ^ 1001的式子，就是 (5 ^ 1 * 1) * (5 ^ 0 * 2) * (5 ^ 0 * 4) * (5 ^ 1 * 8)
 * 1和0可以直接从9的最后一位得到，正好四次循环遍历得到1和0的过程
 * 又可以得到5 ^ 1 5 ^ 2  5 ^ 4 5 ^ 8
 *
 *
 * 就相当于是，四次计算算出 5的1 2 4 8四个数，然后对应的位数是1就留下，是0就丢掉。
 **/

class ShuZhiDeZhengShuCiFangLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (x == 0) {
                return 0;
            }
            long b = n;
            double res = 1.0;
            //将一个数的负数次方，转成该数倒数的正数次方
            if (n < 0) {
                b = -b;
                x = 1 / x;
            }
            //当b还没有移位完毕
            while (b > 0) {
                //如果b的最后一位是1，就乘上当前的x，如1001，会乘上5^1和5^8，如果是0则不乘
                if ((b & 1) == 1) {
                    res *= x;
                }
                //计算得到5的平方，得到5^2 5^4 5^8
                x *= x;
                //b继续移位
                b >>= 1;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}