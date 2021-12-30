package leetcode.editor.cn;

//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 
//
// 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物 
//
// 
//
// 提示： 
//
// 
// 0 < grid.length <= 200 
// 0 < grid[0].length <= 200 
// 
// Related Topics 数组 动态规划 矩阵 👍 224 👎 0

/**
 * dfs失败超时，这道题是一个递归
 * class Solution {
 *     private int m, n, max = -1;
 *     private int[][] next = {{0, 1}, {1, 0}};
 *     public int maxValue(int[][] grid) {
 *         m = grid.length;
 *         n = grid[0].length;
 *         dfs(grid, 0, 0, 0);
 *         return max;
 *     }
 *
 *     public void dfs(int[][]grid, int x, int y, int cur) {
 *         //能进来的都是合法的，先把本节点的值加上去
 *         cur += grid[x][y];
 *         if (x == m - 1 && y == n - 1) {
 *             max = Math.max(cur, max);
 *             return;
 *         }
 *         //两个方向
 *         for (int i = 0; i < 2; i++) {
 *             int nx = x + next[i][0];
 *             int ny = y + next[i][1];
 *             if (nx >= m || ny >= n) {
 *                 continue;
 *             }
 *             dfs(grid, nx, ny, cur);
 *         }
 *     }
 * }
 *
 * dp的写法，定义dp[i][j]的含义是走到ij处的一个最大价值，而ij只能由上方或者左方到达，因此
 * dp[i][j] = max(dp上方，dp左方) + ij当前的价值。即dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
 * 当前只依赖于左方和上方，因此按照行遍历即可。
 * 但是有三个特殊情况要处理。
 * i == 0 j == 0是起始位置，不需要计算，直接给出结果
 * i == 0 j != 0代表是第一行，来源只能来自左方，所以dp[i][j] = dp[i][j - 1]
 * i != 0 j == 0代表是第一列，来源只能来自上方，所以dp[i][j] = dp[i - 1][j]
 *
 *
 */

class LiWuDeZuiDaJieZhiLcof {
    public static void main(String[] args) {
        Solution solution = new LiWuDeZuiDaJieZhiLcof().new Solution();
        solution.maxValue(null);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValue(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        //初始条件不走
                        continue;
                    } else if (i == 0) {
                        //如果i==0，也就是挨着上边的墙走，说明来源只能来源自左侧
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    } else if (j == 0) {
                        //如果j==0，也就是挨着左边的墙走，说明来源只能来源自上侧
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    } else {
                        //来源可以是上方和左方，取最大值
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}