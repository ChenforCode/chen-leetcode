package leetcode.editor.cn;

//有 n 个网络节点，标记为 1 到 n。 
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， w
//i 是一个信号从源节点传递到目标节点的时间。 
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// 所有 (ui, vi) 对都 互不相同（即，不含重复边） 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列） 
// 👍 420 👎 0

import java.util.Arrays;

class NetworkDelayTime {
    public static void main(String[] args) {
        Solution solution = new NetworkDelayTime().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            int INF = Integer.MAX_VALUE / 2;
            int m = times.length;
            k = k - 1;
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(matrix[i], INF);
            }
            //构造邻接矩阵
            for (int i = 0; i < m; i++) {
                int x = times[i][0] - 1;
                int y = times[i][1] - 1;
                int len = times[i][2];
                matrix[x][y] = len;
            }
            //构造距离数组和访问数组
            int[] dist = new int[n];
            boolean[] visit = new boolean[n];
            Arrays.fill(dist, INF);
            Arrays.fill(visit, false);
            //初始化距离
            for (int i = 0; i < n; i++) {
                dist[i] = matrix[k][i];
            }
            //将节点本身加入确定的数组
            dist[k] = 0;
            visit[k] = true;

            //松弛操作 有多少个节点就要松弛多少次，计算节点本身不用松弛
            for (int i = 0; i < n - 1; i++) {
                int min = INF;
                int index = 0;
                //寻找剩余节点中（没有被visit的）距离最短的
                for (int j = 0; j < n; j++) {
                    if (!visit[j] && dist[j] < min) {
                        min = dist[j];
                        index = j;
                    }
                }
                //找到最近的节点需要加入确认集合
                visit[index] = true;
                //以index为中间节点，对所有的点进行松弛。正式开始松弛操作
                for (int x = 0; x < n; x++) {
                    if (matrix[index][x] != INF) {
                        //如果到x可达，那么需要用index作为中间节点进行松弛
                        dist[x] = Math.min(dist[x], dist[index] + matrix[index][x]);
                    }
                }
            }
            int max = -1;
            for (int i = 0; i < n; i++) {
                if (dist[i] > max) {
                    max = dist[i];
                }
            }
            return max == INF ? -1 : max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}