package com.py.util;

import java.util.*;

public abstract class Util {
    public static void print2D(int grid[][]){
        for(int row[]:grid){
            System.out.printf("%s \n",Arrays.toString(row));
        }
    }

    public static <T> void print2D(T grid[][]){
        for(T row[]:grid){
            System.out.printf("%s \n",Arrays.toString(row));
        }
    }

    public static void print2D(char[][] grid) {
        for(char row[]:grid){
            System.out.printf("%s \n",Arrays.toString(row));
        }
    }
    public static<T> ArrayList<T> arrayToList(T[] arr){
        ArrayList<T> arrList = new ArrayList<>();
        for(T e:arr){
            arrList.add(e);
        }
        return arrList;
    }
    /**
     * Prints the arr from starting idx to ending idx (inclusive)
     * @param <T>
     * @param arr
     * @param start
     * @param end
     */
    public static <T> void printArray(T arr[],int start,int end){
        System.out.print("[ ");
        for(int i=start;i<=end;i++){
            System.out.printf("%d ",arr[i]);
        }
        System.out.println("]");
    }
    /**
     * Prints integer arr from starting idx to ending idx (inclusive)
     * @param <T>
     * @param arr
     * @param start
     * @param end
     */
    public static  void printArray(int arr[],int start,int end){
        System.out.print("[ ");
        for(int i=start;i<=end;i++){
            System.out.printf("%d ",arr[i]);
        }
        System.out.println("]");
    }
}
