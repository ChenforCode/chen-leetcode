package offer;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/3/11 1:38 下午
 * @description 剑指 Offer 13. 机器人的运动范围
 *
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * 注意数位拆分即可，其余正常做
 */
class MovingCount {
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

        for (int i = 0; i < 4; i++ ){
            int nx = x + next[i][0];
            int ny = y + next[i][1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || nums[nx][ny] == '/') {
                continue;
            }
            int countX = 0;
            int countY = 0;
            if (nx < 10) {
                countX = nx;
            } else if(nx >= 10) {
                countX += nx / 10;
                countX += nx % 10;
            }
            if (ny < 10) {
                countY = ny;
            } else if(ny >= 10) {
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
