package offer;

//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学 
// 👍 149 👎 0

/**
 *
 * 这道题可以用最小堆，每次加进去最小丑数的2 3 5倍数，然后最小堆会进行排序，下次会继续取
 * 最小的丑数，也就是第二小的，取第n次的时候就是第n小的丑数，也就是第n个丑数。
 * 就是1入2 3 5，然后2是最小的，下次进2的4 6 10，继续排序3最小，进3的6 9 15，这样
 * 一直入n次，就能拿到第n小的值。因为1不仅仅是2 3 5中的最小，还是全局的最小，因为接下来
 * 进入的值都是倍数，只会更大。
 *
 * 第二个方法三指针，我们看到以2 3 5为奇数，1 1 1代表三个指针，代表下一次可以乘上2 3 5的数字坐标，
 *
 * 其实就是这样，首先第一个数都可以乘上2 3 5，但是乘上2的结果是最小的，因此把dp[2] = 2，接下来
 * 第一个数就不能再乘上2了，因为这个结果已经进入dp了，再算也没意义
 *
 * 下次比较应该是第二个数乘上2，以及第一个数乘上3，5进行比较。其实这里可认为是是第二个数乘上 2 3 5
 * 以及第一个数乘上3 5进行比较，但是第二个数的3 5一定大于2，所以暂时没必要比。
 *
 * 所以就是dp[2] * 2以及dp[1] * 3，以及dp[1] * 5。所以就是dp[pi] * pi..
 * 所以就是我们维持了三个数字，dp[p2] * p2   dp[3] * p3   dp[p5] * p5，最小值一定会从这三个里出
 * 出了之后，后移即可。
 *
 * 即dp[1] * 2  dp[1] * 3  dp[1] * 5，最小的一定在这三个里。第一个最小，相当于dp[1] * 2最小，那么
 * dp[1]以后就不能乘2了，下次比较就是dp[2] * 2  dp[1] * 3  dp[1] * 5。
 *
 * 为什么不比较dp[2] * 2  dp[2] * 3  dp[2] * 5？？？因为dp[1] * 3一定小于dp[2] * 3
 * dp[1] * 5 < dp[2] * 5。前者还没轮上最小呢，一定轮不上后者，因此就是上述三个比较。
 *
 * 所以以上两种方式的区别就是，最小堆是先放入，然后再排序。dp的话是直接排序好，再放入
 *
 **/

class ChouShuLcof {
    public static void main(String[] args) {
        Solution solution = new ChouShuLcof().new Solution();
        String a = "aaa";
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        int p2 = 1, p3 = 1, p5 = 1;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            long p2res = 2 * dp[p2];
            long p3res = 3 * dp[p3];
            long p5res = 5 * dp[p5];
            long min = Math.min(Math.min(p2res, p3res), p5res);
            dp[i] = min;
            if (min == p2res) {
                p2++;
            }
            if (min == p3res) {
                p3++;
            }
            if (min == p5res) {
                p5++;
            }
        }
        return (int)dp[n];
    }

    //最小堆的算法
//    public int nthUglyNumber(int n) {
//        long res = 1;
//        int[] factors = {2, 3, 5};
//        PriorityQueue<Long> q = new PriorityQueue<>();
//        Set<Long> set = new HashSet<>();
//        q.offer(res);
//        for (int i = 0 ; i < n; i++) {
//            res = q.poll();
//            for (int j = 0; j < 3; j++) {
//                long next = res * factors[j];
//                if (!set.contains(next)) {
//                    set.add(next);
//                    q.offer(next);
//                }
//            }
//        }
//        return (int)res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}