package com.example.sorting;


/**
 * <p>描述：排序算法</p>
 * 作者： liujiyi<br>
 * 日期： 2018/4/3<br>
 */
public class Sort {

    /**
     * <p>
     * * 冒泡排序
     * 时间复杂度为O（n^2）
     * <p>
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。
     * 在这一点，最后的元素应该会是最大的数。 针对所有的元素重复以上的步骤，
     * 除了最后一个。持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * <p>
     *
     * @param numbers
     */
    public static int[] bubbleSort(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return null;
        }
        int temp = 0;
        //加入标记状态 flag 若在一次冒泡中，没有交换 则说明可以停止 减少运行时
        boolean flag = true;
        for (int x = 0; x < numbers.length - 1 && flag; x++) {
            flag = false;
            for (int j = 0; j < numbers.length - 1 - x; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    flag = true;
                }
            }
        }
        return numbers;
    }

    /**
     * <p>
     * * 选择排序
     * 时间复杂度为O（n^2）
     * 性能上优于冒泡排序 交换次数少
     * <p>
     * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
     * 然后在剩下的数当中再找最小的与第二个位置的数交换，
     * 如此循环到倒数第二个数和最后一个数比较为止。
     * <p>
     *
     * @param numbers
     */
    public static int[] selectSort(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return null;
        }
        int pos = 0;
        int temp = 0;
        for (int x = 0; x < numbers.length - 1; x++) {
            pos = x;
            for (int j = numbers.length - 1; j > x; j--) {
                if (numbers[j] < numbers[pos]) {
                    pos = j;
                }
            }
            temp = numbers[x];
            numbers[x] = numbers[pos];
            numbers[pos] = temp;
        }
        return numbers;
    }
}
