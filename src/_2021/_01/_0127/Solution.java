package _2021._01._0127;

import java.util.Arrays;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/1/27 11:26 上午
 * @description 最多删除的边
 * 因为没有权重，所以按照顺序遍历，依次加边，然后判断联通，如果两点已经联通，那么下次连接
 * 这两点的边就是多余的，不再加边，记录可删除数字+1。先加公共边，然后加alice，加bob。
 * 二者分别有一个并查集来判断任意两点是否联通。最后各自的并查集数目为1代表合并完成，可连通。
 * 并查集可以看成是几个联通点的集合，他们几个之间类似树的关系，有一个祖先节点。
 */
public class Solution {
    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        init(edges);
        Union alice = new Union(n);
        Union bob = new Union(n);
        int ans = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (!alice.isConnected(edge[1], edge[2])) {
                    alice.merge(edge[1], edge[2]);
                    bob.merge(edge[1], edge[2]);
                } else {
                    ans++;
                }
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (!alice.isConnected(edge[1], edge[2])) {
                    alice.merge(edge[1], edge[2]);
                } else {
                    ans++;
                }
            }
            if (edge[0] == 2) {
                if (!bob.isConnected(edge[1], edge[2])) {
                    bob.merge(edge[1], edge[2]);
                } else {
                    ans++;
                }
            }
        }
        return (alice.count == 1 && bob.count == 1) ? ans : -1;
    }

    public static void init(int[][] edges) {
        for (int[] edge : edges) {
            edge[1]--;
            edge[2]--;
        }
    }

    public static void main(String[] args) {
//        int[][] edges = {{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}};
//        System.out.println(maxNumEdgesToRemove(4, edges));
//        int n = 2;
//        int[][] edges = {{1, 1, 2}, {2, 1, 2}, {3, 1, 2}};

        int n = 13;
        int[][] edges = {{1,1,2},{2,1,3},{3,2,4},{3,2,5},{1,2,6},{3,6,7},{3,7,8},{3,6,9},{3,4,10},{2,3,11},{1,5,12},{3,3,13},{2,1,10},{2,6,11},{3,5,13},{1,9,12},{1,6,8},{3,6,13},{2,1,4},{1,1,13},{2,9,10},{2,1,6},{2,10,13},{2,2,9},{3,4,12},{2,4,7},{1,1,10},{1,3,7},{1,7,11},{3,3,12},{2,4,8},{3,8,9},{1,9,13},{2,4,10},{1,6,9},{3,10,13},{1,7,10},{1,1,11},{2,4,9},{3,5,11},{3,2,6},{2,1,5},{2,5,11},{2,1,7},{2,3,8},{2,8,9},{3,4,13},{3,3,8},{3,3,11},{2,9,11},{3,1,8},{2,1,8},{3,8,13},{2,10,11},{3,1,5},{1,10,11},{1,7,12},{2,3,5},{3,1,13},{2,4,11},{2,3,9},{2,6,9},{2,1,13},{3,1,12},{2,7,8},{2,5,6},{3,1,9},{1,5,10},{3,2,13},{2,3,6},{2,2,10},{3,4,11},{1,4,13},{3,5,10},{1,4,10},{1,1,8},{3,3,4},{2,4,6},{2,7,11},{2,7,10},{2,3,12},{3,7,11},{3,9,10},{2,11,13},{1,1,12},{2,10,12},{1,7,13},{1,4,11},{2,4,5},{1,3,10},{2,12,13},{3,3,10},{1,6,12},{3,6,10},{1,3,4},{2,7,9},{1,3,11},{2,2,8},{1,2,8},{1,11,13},{1,2,13},{2,2,6},{1,4,6},{1,6,11},{3,1,2},{1,1,3},{2,11,12},{3,2,11},{1,9,10},{2,6,12},{3,1,7},{1,4,9},{1,10,12},{2,6,13},{2,2,12},{2,1,11},{2,5,9},{1,3,8},{1,7,8},{1,2,12},{1,5,11},{2,7,12},{3,1,11},{3,9,12},{3,2,9},{3,10,11}};
        System.out.println(maxNumEdgesToRemove(n, edges));


    }
}

class Union {
    int[] parent;
    int[] size;
    int count;
    int n;

    public Union(int n) {
        this.n = n;
        this.count = n;
        parent = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public int findRoot(int x) {
        //判断是否找到了最后的祖先。即判断x本身是否为祖先
        if (x == parent[x]) {
            return x;
        }
        //如果x不是祖先，那就接着判断x的父亲是不是祖先，并且更新x的父亲为找到的祖先结果
        parent[x] = findRoot(parent[x]);
        return parent[x];
    }

    public boolean merge(int x, int y) {
        //注意这里并查集的合并不能简单的将两个点合并，而是将两个点所在的集合合并
        //因此操作的是root(x)和root(y)
        if (findRoot(x) == findRoot(y)) {
            return false;
        }
        parent[findRoot(x)] = findRoot(y);
        parent[x] = y;
        this.count--;
        return true;
    }

    public boolean isConnected(int x, int y) {
        return findRoot(x) == findRoot(y);
    }
}
