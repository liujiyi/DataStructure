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

    /**
     * 希尔排序
     * 时间复杂度O(n^2）
     * <p>
     * 希尔排序的原理:根据需求，如果你想要结果从小到大排列，它会首先将数组进行分组，然后将较小值移到前面，较大值
     * 移到后面，最后将整个数组进行插入排序，这样比起一开始就用插入排序减少了数据交换和移动的次数，
     * 可以说希尔排序是加强 版的插入排序 拿数组5, 2,8, 9, 1, 3，4来说，数组长度为7，当increment为3时，数组分为两个序列
     * 5，2，8和9，1，3，4，第一次排序，9和5比较，1和2比较，3和8比较，4和比其下标值小increment的数组值相比较
     * 此例子是按照从小到大排列，所以小的会排在前面，第一次排序后数组为5, 1, 3, 4, 2, 8，9
     * 第一次后increment的值变为3/2=1,此时对数组进行插入排序， 实现数组从大到小排
     */
    public static int[] shellSort(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return null;
        }
        int j = 0;
        int temp = 0;
        // 每次将步长缩短为原来的一半
        for (int increment = numbers.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < numbers.length; i++) {
                temp = numbers[i];
                for (j = i; j >= increment; j -= increment) {
                    System.out.println("increment=" + increment);
                    System.out.println("j=" + j);
                    // 从小到大排
                    if (temp < numbers[j - increment]) {
                        numbers[j] = numbers[j - increment];
                    } else {
                        break;
                    }
                }
                numbers[j] = temp;
            }
        }
        return numbers;
    }
}
