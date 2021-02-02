package _2021._01._0129;

import java.util.*;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/1/29 10:03 上午
 * @description 1631.最小体力消耗路径
 */
public class Solution {
    static class Edge {
        int x;
        int y;
        int w;

        public Edge(int x, int y, int w) {
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
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        public int find(int x) {
            if (x == father[x]) {
                return x;
            }
            father[x] = find(father[x]);
            return father[x];
        }

        public boolean merge(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx == fy) {
                return false;
            }
            father[fx] = fy;
            return true;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    private static int[][] next = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static List<Edge> edges = new ArrayList<>();
    private static int[] visited;
    static int row, col;

    public static int minimumEffortPath(int[][] heights) {
        row = heights.length;
        col = heights[0].length;
        visited = new int[row * col];
        Arrays.fill(visited, 0);
        //初始化并查集
        Union union = new Union(row * col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //此处两层循环的所有都是合法的，每个点都应该搜一遍
                for (int k = 0; k < 4; k++) {
                    int nX = i + next[k][0];
                    int nY = j + next[k][1];
                    if (nX < 0 || nX >= row || nY < 0 || nY >= col ||
                            visited[i * col + j] == 1) {
                        continue;
                    }
                    Edge edge = new Edge(i * col + j, nX * col + nY,
                            Math.abs(heights[i][j] - heights[nX][nY]));
                    edges.add(edge);
                }
                visited[i * col + j] = 1;
            }
        }

        //对边按照权重进行排序，从小到大
        Collections.sort(edges, (o1, o2) -> {
            return o1.w - o2.w;
        });

        //按照克鲁斯卡尔算法的思想开始从最小权重边开始加边
        for (Edge edge : edges) {
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
        int[][] heights = {{4, 3, 4, 10, 5, 5, 9, 2},
                {10, 8, 2, 10, 9, 7, 5, 6},
                {5, 8, 10, 10, 10, 7, 4, 2},
                {5, 1, 3, 1, 1, 3, 1, 9},
                {6, 4, 10, 6, 10, 9, 4, 6}};
        System.out.println(minimumEffortPath(heights));
    }
}
