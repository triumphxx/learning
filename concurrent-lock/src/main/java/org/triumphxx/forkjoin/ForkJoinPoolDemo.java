package org.triumphxx.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author:triumphxx
 * @Date:2021/4/20
 * @Time:10:34 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: Fork/Join框架实现计算任务，将一个计算结果拆分为俩个分别计算，然后合并
 **/
public class ForkJoinPoolDemo extends RecursiveTask<Integer> {
    private ForkJoinPool forkJoinPool;
    //要计算的数字数组
    private int[] numbers;
    // 那个位置开始计算
    private int from;
    //计算到那个位置
    private int to;

    //构造器
    public ForkJoinPoolDemo(int[] numbers, int from, int to) {
        this.forkJoinPool = new ForkJoinPool();
        this.numbers = numbers;
        this.from = from;
        this.to = to;
    }

    @Override
    protected Integer compute() {
        int middle = (from + to) / 2;
        ForkJoinPoolDemo taskLeft = new ForkJoinPoolDemo(numbers, from, middle);
        ForkJoinPoolDemo taskRight = new ForkJoinPoolDemo(numbers, middle + 1, to);
        taskLeft.fork();
        taskRight.fork();
        return taskLeft.join() + taskRight.join();
    }

    public long sumUp() {
        return forkJoinPool.invoke(new ForkJoinPoolDemo(numbers, from, to));
    }


    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 5, 7, 9, 5, 6};
        int from = 0;
        int to = 7;
        ForkJoinPoolDemo forkJoinPoolDemo = new ForkJoinPoolDemo(numbers, from, to);
        System.out.println(forkJoinPoolDemo.sumUp());
    }
}
