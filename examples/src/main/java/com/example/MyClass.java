package com.example;


import com.example.code.DoubleLink;
import com.example.code.OrderedArray;

public class MyClass {
    public static void main(String[] args) {

        DoubleLink link = new DoubleLink();
        link.add(0, 5);
        link.add(0, 4);
        link.add(0, 3);
        link.add(0, 2);
        link.add(0, 1);
        link.add(1, 9);
//        link.add(1, 99);
//        link.add(7, 99999);
        link.del(1);

        link.display();
    }
}
