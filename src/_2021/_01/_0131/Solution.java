package _2021._01._0131;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/2/3 8:21 下午
 * @description 839. 相似字符串组
 */
public class Solution {
    static class Union {
        int[] father;
        int n;
        int count;

        Union(int n) {
            this.n = n;
            this.count = n;
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
            this.count--;
            return true;
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static int numSimilarGroups(String[] strs) {
        int strNum = strs.length;
        int strLen = strs[0].length();
        Union union = new Union(strs.length);

        for (int i = 0; i < strNum; i++) {
            for (int j = i + 1; j < strNum; j++) {
                if (check(strs[i], strs[j], strLen)) {
                    if (!union.isConnected(i, j)) {
                        union.merge(i, j);
                    }
                }
            }
        }
        return union.count;
    }

    public static boolean check(String a, String b, int len) {
        int notSameNum = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                notSameNum++;
            }
            if (notSameNum > 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String []strs = {"tars","rats","arts","star"};
        String[] strs = {"omv", "ovm"};
        System.out.println(numSimilarGroups(strs));

    }
}
