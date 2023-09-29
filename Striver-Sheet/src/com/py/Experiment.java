package com.py;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Stream;

public class Experiment{
    static int tprint(Field e){
        System.out.println("sexy");
        return 0;
    }
    private  class Parent{
        int i;
        @Override
        public int hashCode(){
            return Objects.hash(i);
        }
    }
    private  class Child1 extends Parent{
        int j;
        int i;
        @Override
        public int hashCode(){
            return Objects.hash(i,j);
        }
    }

    public static void 
    main(String ...args){
        // Experiment e = new Experiment();
        // System.out.println(e.getClass());
        // Parent p =e.new Parent();
        // System.out.println(p.hashCode() + " for class => "+ p.getClass());
        // Child1 c1 = e.new Child1();

        // System.out.println(c1.hashCode() + " "+ c1.getClass());
        // Parent p1 = (Parent) c1;
        // System.out.println(p1.hashCode() + " "+ p1.getClass());
        // Object obj = new Object();
        // System.out.println("using method reference=>");
        // Stream.of(c1.getClass().getDeclaredFields()).forEach(Experiment::tprint);
        // System.out.println(Objects.hash(p,c1));

        // String a = "abc";
        // String b = "bbd";
        // System.out.println(b.compareTo(a));
        // System.out.println((char)('a'-32));

        ArrayList<Integer> l = new ArrayList<>();
        l.add(0);
        l.add(2);
        l.add(4);
        System.out.println(l);
        // l.add(10,42);
        System.out.println(l);
        l.add(0,-1);
        System.out.println(l);

    }

}