package org.triumphxx.sort;


import java.util.Arrays;

/**
 * @author:triumphxx
 * @Date:2020/12/24
 * @Time:上午9:19
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 冒泡 排序  时间复杂度O(n^2)
 **/
public class MaoPaoSort {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 6, 9, 0, 3, 5, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr) {
        if (arr == null) {
            return;
        }
        boolean flag = false;
        int temp = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                    count++;
                }
            }
            // 在一趟排序中，一次交换都没有发生过
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
