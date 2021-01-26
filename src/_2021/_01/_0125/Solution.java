package _2021._01._0125;

/**
 * @author Ariel
 * @date 2021/1/25 10:37
 * @description 959. 由斜杠划分区域。
 * 将1*1的格子扩大成为3*3的迷宫，2*2扩大成为6*6，然后把两种斜线写入迷宫计1，然后计算最终有多少个
 * 区域即可
 */
public class Solution {
    private static int[][] next = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public static int regionsBySlashes(String[] grid) {
        int count = 100;//记录有多少个区域，深搜一次说明就有一个
        int [][] g = new int[grid.length * 3][grid[0].length() * 3];
        //初始化
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++){
                g[i][j] = 0;
            }
        }
        //填迷宫
        for (int i = 0; i < grid.length; i++) {
            char[] chars = grid[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '/') {
                    g[i * 3 + 2][j * 3] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3][j * 3 + 2] = 1;
                }
                if(chars[j] == '\\'){
                    g[i * 3][j * 3] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3 +2][j * 3 + 2] = 1;
                }
            }
        }
        //开始深搜
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if(g[i][j] == 0){
                    g[i][j]= count;
                    dfs(g, i, j, count);
                    count++;
                }
            }
        }
        return count - 100;
    }
    static void dfs(int[][]g, int i, int j, int count){
        for (int m = 0; m < 4; m++) {
            int nextX = next[m][0] + i;
            int nextY = next[m][1] + j;
            if (nextX >= 0 && nextX < g.length && nextY >= 0 && nextY < g[0].length && g[nextX][nextY] == 0) {
                g[nextX][nextY] = count;
                dfs(g, nextX, nextY, count);
            }
        }
    }

    public static void main(String[] args) {
        String[] grid = new String[2];
        grid[0] = "//";
        grid[1] = "/ ";
        System.out.println(regionsBySlashes(grid));
    }
}