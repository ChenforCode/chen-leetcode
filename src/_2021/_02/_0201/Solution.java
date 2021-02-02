package _2021._02._0201;

import java.util.Arrays;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/2/1 11:27 上午
 * @description 888.公平的糖果棒交换
 */
public class Solution {
    public static int[] fairCandySwap(int[] A, int[] B) {
        int[] ans = new int[2];
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        Arrays.sort(A);
        Arrays.sort(B);
        int diff = (sumA - sumB) / 2;
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] - B[j] < diff) {
                i++;
            } else if (A[i] - B[j] > diff) {
                j++;
            } else {
                ans[0] = A[i];
                ans[1] = B[j];
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {2};
        int[] B = {1 ,3};
        int[] ints = fairCandySwap(A, B);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}