package com.example.code;


/**
 * <p>描述：普通的数组</p>
 * 作者： liujiyi<br>
 * 日期： 2018/3/26<br>
 */
public class GeneralArray {
    private int[] a;
    private int size; //数组的大小
    private int nElem;//数组有多少项

    public GeneralArray(int max) {
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
        a[nElem] = addInt;
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
        int x;
        for (x = 0; x < nElem; x++) {
            if (a[x] == deleteInt) {
                break;
            }
        }
        if (x == nElem) {
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
     * 查找某个值
     *
     * @return
     */
    public boolean find(int seachInt) {
        int x;
        for (x = 0; x < nElem; x++) {
            if (a[x] == seachInt) {
                break;
            }
        }
        if (x < nElem) {
            return true;
        } else {
            return false;
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
