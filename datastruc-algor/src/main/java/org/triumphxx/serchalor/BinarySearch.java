package org.triumphxx.serchalor;

/**
 * @author:triumphxx
 * @Date:2021/3/11
 * @Time:1:57 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 二分查找  递归和非递归的方式
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 8, 9};
        int target = 7;
        System.out.println("---------》");
        int i = binarySearchNoRecur(arr, target);
        System.out.println(i);
        System.out.println("---------》");
        int k = binarySearchRecur(arr, 0, arr.length - 1, 7);
        System.out.println(k);
    }


    /**
     * @param arr    待查找的数组
     * @param target 查找的目标值
     * @return 查到返回下标 否则 返回 -1
     */
    public static int binarySearchNoRecur(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * @param arr    目标数据
     * @param left   左索引
     * @param right  右索引
     * @param target 目标值
     * @return 查到返回 下标  反之返回 -1
     */
    public static int binarySearchRecur(int[] arr, int left, int right, int target) {
        //说明都递归完成，没有找到目标值
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        //若目标值小于中间值 则做左递归
        if (arr[mid] > target) {
            return binarySearchRecur(arr, left, mid - 1, target);
            //若目标值大于中间值 则右递归
        } else if (arr[mid] < target) {
            return binarySearchRecur(arr, mid + 1, right, target);
        } else {
            return mid;
        }
    }
}
