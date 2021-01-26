package _2021._01._0126;

import java.util.HashMap;
import java.util.Set;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/1/26 9:52 上午
 * @description 多米诺骨牌
 * 给出n个二元组，两个组，相同或者相反代表是相同的一组，查一共有多少个相同组。
 * 例如 (1,2)(2,1)(3,4)(4,5)只有前两个是相同的一组，输出为1
 * 解法：对于12，21这种我们统一看成12，并将12看成key，value看成有多少个组是12，然后对value进行
 * 组合计算，求和得到最终的结果。
 */
public class Solution {
    public static int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            int[] row = dominoes[i];
            int key = 0;
            if (row[0] > row[1]) {
                key = row[0] * 10 + row[1];
            } else {
                key = row[1] * 10 + row[0];
            }

            if (!hashMap.containsKey(key)) {
                hashMap.put(key, 1);
            } else {
                hashMap.put(key, hashMap.get(key) + 1);
            }
        }
        Set<Integer> integers = hashMap.keySet();
        int ans = 0;
        for (Integer integer : integers) {
            int val = hashMap.get(integer);
            if (val >= 2) {
                ans += (val * (val - 1) / 2);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [][]res = {{1,2},{2,1},{2,1},{5,6}};
        System.out.println(numEquivDominoPairs(res));
    }
}
