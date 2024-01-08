package com.py.revision;

import java.util.*;
import java.text.*;
import java.time.*;

/**
 * Hello world!
 *
 */
public class App {

    static class Inner{
        void printtHello(){
            System.out.println("Hello");
        }
    }
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        int i=0;
        for(String ar:args){
            System.out.println(ar+" "+i);
            i++;
        }
        System.out.println("starting the revision:");
        // LocalDate started=null;
        // try{
        //     started = LocalDate.of(2023, 9, 14);

        // }catch(IllegalArgumentException e){

        // }
        // catch(NullPointerException e){

        // }catch (Exception e){
            
        // }
        // LocalDate now = LocalDate.now();
        // System.out.printf("day :: %d",Duration.between(started.atStartOfDay(),now.atStartOfDay()).toDays());
        /*
         * class system properties
         */
        // String classpath = System.getProperty("java.class.path");
        //     if(true)
        //         System.out.println("truePrinted");
        // // Display the classpath
        // System.out.println("Classpath: " + classpath);
        // // System.out.println(System.getProperties());
        // String[] classpathEntries = classpath.split(System.getProperty("path.separator"));

        // // Display each classpath entry
        // System.out.println("Classpath Entries:");
        // for (String entry : classpathEntries) {
        //     System.out.println(entry);
        // }

        /*
         * annonymous class
         * 
         */
        Inner obj = new App.Inner();
        obj.printtHello();
        System.out.println(obj.getClass());
        Inner obj2 = new App.Inner(){
            public void foo(){
                System.out.println("Foo is called");
            }
        };
        Experiments e = new Experiments();
        int a = e.xxx;
        obj2.printtHello();
        // System.out.println(obj2.foo());
        // ((Inner) obj2 ).foo();

        Superclass subclass = new Superclass() {
            @Override
            public void display() {
                System.out.println("This is the anonymous subclass.");
            }

            void additionalMethod() {
                System.out.println("This is an additional method in the anonymous subclass.");
            }
        };
        subclass.display(); 
        // subclass
    }
    static interface Superclass {
        void display();
    }
}
