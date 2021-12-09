package leetcode.editor.cn;

//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 394 👎 0

/**
 * @Author <a href="http://www.chenforcode.cn">PKUCoder</a>
 * @Date 2021/12/9 11:11 上午
 * @Param
 * @Return
 * @Description 注意数位拆分即可，其余正常做
 **/
class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] next = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        private int[][] nums;
        private int res = 0;

        public int movingCount(int m, int n, int k) {
            nums = new int[m][n];
            nums[0][0] = '/';
            res++;
            dfs(0, 0, m, n, k);
            return res;
        }

        public void dfs(int x, int y, int m, int n, int k) {

            for (int i = 0; i < 4; i++) {
                int nx = x + next[i][0];
                int ny = y + next[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || nums[nx][ny] == '/') {
                    continue;
                }
                int countX = 0;
                int countY = 0;
                if (nx < 10) {
                    countX = nx;
                } else if (nx >= 10) {
                    countX += nx / 10;
                    countX += nx % 10;
                }
                if (ny < 10) {
                    countY = ny;
                } else if (ny >= 10) {
                    countY += ny / 10;
                    countY += ny % 10;
                }
                if (nx > 10 || ny > 10) {
                    System.out.println(countX + " " + countY);
                    System.out.println(nx + " " + ny);
                    System.out.println();
                }
                if (countX + countY <= k) {
                    nums[nx][ny] = '/';
                    // System.out.println(nx + " " + ny);
                    res++;
                    dfs(nx, ny, m, n, k);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}