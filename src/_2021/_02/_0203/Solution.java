package _2021._02._0203;

import java.util.Arrays;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/2/3 11:35 上午
 * @description 480. 滑动窗口中位数
 * 加入6 8 5 4 7 3 六个数字，首先初始化一个滑窗为6 8 5，
 * 接着就是移动滑窗i < len - k = 3次也就是0 1 2移除。
 * 分别是6移除加入4变成8 5 4。8移除加入7变成5 4 7，然后5移除加入3，变成4 7 3（这里为了方便理解滑窗没有排序
 * 真实情况6移除并不一定就在滑窗的0号位，需要我们自己找到他的位置）
 */
public class Solution {
    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int[] window = new int[k];
        for (int i = 0; i < k; i++) {
            window[i] = nums[i];
        }
        Arrays.sort(window);
        res[0] = getMid(window);
        //开始滑动窗口，从0号位开始删除，删除len - k个，也就出现了len - k个结果，再加上本来就有的
        //初始化滑窗，最终结果是len - k + 1个，满足要求
        for (int i = 0; i < nums.length - k; i++) {
            //找到当前需要删除的数在滑窗内的位置
            int indexToDel = search(window, nums[i]);
            //用滑窗的下一个数字来替代要删除的数字，模拟滑窗移动
            window[indexToDel] = nums[i + k];
            //对当前窗口重新排序
            Arrays.sort(window);
            res[i + 1] = getMid(window);
        }
        return res;
    }

    public static double getMid(int[] window) {
        int len = window.length;
        if (len % 2 == 0) {
            return ((double) window[len / 2 - 1] + (double) window[len / 2]) / 2.0;
        } else {
            return window[len / 2];
        }
    }

    public static int search(int[] window, int value) {
        for (int i = 0; i < window.length; i++) {
            if (window[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2147483647, 2147483647};
        int k = 2;
        double[] res = medianSlidingWindow(nums, k);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i] + " ");
        }
    }
}

