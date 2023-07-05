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
}
