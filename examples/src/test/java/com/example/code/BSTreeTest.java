package com.example.code;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <p>描述：二叉查找树的java实现 Test</p>
 * 作者： liujiyi<br>
 * 日期： 2018/3/28<br>
 */
public class BSTreeTest {
    private BSTree mTree;

    @Before
    public void setUp() throws Exception {
        mTree = new BSTree();

        mTree.insert(109);
        mTree.insert(785);
        mTree.insert(99);
        mTree.insert(888);
        mTree.insert(999);
        mTree.insert(89);
        mTree.insert(666);
    }

    @Test
    public void insert() throws Exception {
        mTree.insert(5);
        mTree.insert(99);
    }

    @Test
    public void print() throws Exception {
        mTree.print();
    }

    @Test
    public void search() throws Exception {
        mTree.remove(89);
        mTree.print();
    }
}