package com.example.sorting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <p>描述：排序测试</p>
 * 作者： liujiyi<br>
 * 日期： 2018/4/3<br>
 */
public class sortTest {
    private int[] numbers;

    @Before
    public void setUp() throws Exception {
        numbers = new int[]{15, 65, 88, 98, 22, 10};
    }

    @Test
    public void bubbleSort() throws Exception {
        int[] sort = Sort.bubbleSort(numbers);
        for (int x = 0; x < sort.length; x++) {
            System.out.print(sort[x] + "-");
        }
    }

    @Test
    public void selectSort() throws Exception {
        int[] sort = Sort.selectSort(numbers);
        for (int x = 0; x < sort.length; x++) {
            System.out.print(sort[x] + "-");
        }
    }

}