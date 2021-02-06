package yy;

import java.util.Arrays;

/**
 * @author Ariel
 * @date 2021/2/6 11:28
 * @description 1423. 可获得的最大点数
 */
class Solution {
    public static int maxScore(int[] cardPoints, int k) {
        int windowLen = cardPoints.length - k;
        int left = 0;
        int right = windowLen;
        int sum = Arrays.stream(cardPoints).sum();
        int windowSum = 0;
        for (int i = 0; i < windowLen; i++) {
            windowSum += cardPoints[i];
        }
        int minSum = windowSum;
        while (right < cardPoints.length) {
            windowSum = windowSum - cardPoints[left];
            windowSum += cardPoints[right];
            right++;
            left++;
            minSum = Math.min(minSum, windowSum);
        }
        return sum - minSum;
    }

    public static void main(String[] args) {
        int[] cardPoints = {9,7,7,9,7,7,9};
        int k = 7;
        System.out.println(maxScore(cardPoints, k));
    }
}
