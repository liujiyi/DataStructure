package com.example.code;


/**
 * <p>描述：有序的数组</p>
 * 作者： liujiyi<br>
 * 日期： 2018/3/26<br>
 */
public class OrderedArray {
    private int[] a;
    private int size; //数组的大小
    private int nElem;//数组有多少项

    public OrderedArray(int max) {
        this.a = new int[max];
        this.size = max;
        this.nElem = 0;
    }

    /**
     * 插入某个值
     *
     * @return
     */
    public boolean add(int addInt) {
        if (nElem == size) {
            System.out.println("full");
            return false;
        }
        int j;
        for (j = 0; j < nElem; j++) {
            if (a[j] > addInt) {
                break;
            }
        }

//        for (int i = j; i < nElem; i++) {
//            a[i+1] = a[i];
//        }
        for (int i = nElem; i > j; i--) {
            a[i] = a[i - 1];
        }

        a[j] = addInt;
        nElem++;
        display();
        return true;
    }

    /**
     * 删除某个值
     *
     * @return
     */
    public boolean delete(int deleteInt) {
        int x = find(deleteInt);
        if (x == -1) {
            System.out.println("");
            System.out.println("not find");
            return false;
        }

        if (nElem == size) {
            for (int j = x; j < nElem - 1; j++) {
                a[j] = a[j + 1];
            }
        } else {
            for (int j = x; j < nElem; j++) {
                a[j] = a[j + 1];
            }
        }
        nElem--;
        display();
        return true;
    }

    /**
     * 二分查找
     * 查找某个值
     *
     * @return
     */
    public int find(int seachInt) {
        int pre = 0;
        int last = nElem - 1;
        int cur;
        while (true) {
            cur = (pre+last)/2;
            if (a[cur] == seachInt) {
                return cur;
            }else if (pre > last) {
                return -1;
            }else {
                if (a[cur] < seachInt) {
                    pre = cur + 1;
                }else {
                    last = cur - 1;
                }
            }
        }
    }

    /**
     * 打印数组
     */
    public void display() {
        System.out.println(" ");
        for (int x = 0; x < nElem; x++) {
            System.out.print(a[x] + " ");
        }
    }
}
