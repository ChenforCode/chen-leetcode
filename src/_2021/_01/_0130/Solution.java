package _2021._01._0130;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/2/3 3:28 下午
 * @description 778. 水位上升的泳池中游泳。
 * 这道题的思路和29号的十分相似，这个题是求，从0-0到n-1~n-1两个点连通路径上的水位最大值，
 * 因为只有过了这最大水位的时间，才能漫过这个位置，才能连通两个点。因此整体思路同样是先构造
 * 边，边的权值取两点的最大值，因为只有这样才能连通。然后按照克鲁斯卡尔的顺序，按最小权重
 * 加边，用并查集判两点连通，等到连通的时候，该边的权重就是最后的结果。
 */
public class Solution {
    static class edge {
        int x;
        int y;
        int w;

        public edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    static class Union {
        int[] father;
        int n;

        Union(int n) {
            father = new int[n];
            for (int i = 0; i < father.length; i++) {
                father[i] = i;
            }
        }

        int find(int x) {
            if (x == father[x]) {
                return x;
            }
            father[x] = find(father[x]);
            return father[x];
        }

        boolean merge(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx == fy) {
                return false;
            }
            father[fx] = fy;
            return true;
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    private static int row, col;
    private static int[] visited;
    private static int[][] next = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static List<edge> edges = new ArrayList<>();

    public static int swimInWater(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        visited = new int[row * col];
        Arrays.fill(visited, 0);
        Union union = new Union(row * col);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + next[k][0];
                    int ny = j + next[k][1];
                    if (nx < 0 || nx >= row || ny < 0 || ny >= col ||
                            visited[nx * col + ny] == 1) {
                        continue;
                    }
                    edge edge = new edge(i * col + j, nx * col + ny,
                            Math.max(grid[i][j], grid[nx][ny]));
                    edges.add(edge);
                    visited[i * col + j] = 1;
                }
            }
        }

        edges.sort((edge1, edge2) -> {
            return edge1.w - edge2.w;
        });

        //从最小权重的边开始加，加一条边代表，把边的两个点合并
        for (edge edge : edges) {
            int x = edge.x;
            int y = edge.y;
            int w = edge.w;
            if (!union.isConnected(x, y)) {
                union.merge(x, y);
            }
            if (union.isConnected(0, row * col - 1)) {
                return w;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        int[][] grids = {{0, 2}, {1, 3}};
//        int[][] grids = {{0, 1, 2, 3, 4},
//                {24, 23, 22, 21, 5},
//                {12, 13, 14, 15, 16},
//                {11, 17, 18, 19, 20},
//                {10, 9, 8, 7, 6}};
        int[][] grids = {{3, 2}, {0, 1}};
        System.out.println(swimInWater(grids));
    }
}
