package com.xxx.travel.utils;

import java.util.Arrays;

public class ArrayOrder{

    public static void main(String[] args) {
        int[] arr={2,6,1,33,3,6,9,8};
        int[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));

    }
    public static int[] sort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j <arr.length-1-i ; j++) {

                if (arr[j] < arr[j + 1]) {
                    int temp=arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
