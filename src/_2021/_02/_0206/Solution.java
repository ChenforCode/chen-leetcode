package _2021._02._0206;

import java.util.Arrays;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/2/6 9:21 上午
 * @description 1423. 可获得的最大点数
 */
public class Solution {
    public static int maxScore(int[] cardPoints, int k) {
        int curMin = 0, cur = 0, len = cardPoints.length;
        int sum = Arrays.stream(cardPoints).sum();
        int num = len - k;
        for (int i = 0; i < num; i++) {
            cur += cardPoints[i];
        }
        curMin = cur;
        for (int i = num; i < len; i++) {
            cur = (cur + cardPoints[i] - cardPoints[i - num]);
            if (cur < curMin) {
                curMin = cur;
            }
        }
        return sum - curMin;
    }

    public static void main(String[] args) {
        //[1,79,80,1,1,1,200,1]
        //3
        int[] cardPoints = {1, 79, 80, 1, 1, 1, 200, 1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }
}
