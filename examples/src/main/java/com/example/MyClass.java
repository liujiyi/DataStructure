package com.example;


import com.example.code.OrderedArray;

public class MyClass {
    public static void main(String[] args) {

        OrderedArray array = new OrderedArray(10);
        //        GeneralArray array = new GeneralArray(5);
        array.add(1);
        array.add(5);
        array.add(3);
        array.add(4);
        array.add(0);
        array.add(10);
        array.add(80);

        System.out.println(array.find(2));
        System.out.println(array.find(5));
        System.out.println(array.find(3));

        array.delete(5);
        array.delete(7);
        array.delete(80);
    }
}
