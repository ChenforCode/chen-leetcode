package _2021._02._0207.test;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/2/7 10:38 上午
 * @description main
 */
public class Solution {
    public static boolean check(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                count++;
            }
        }
        System.out.println(count);
        if (count <= 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
