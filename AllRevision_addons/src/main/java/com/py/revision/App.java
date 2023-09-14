package com.py.revision;

import java.util.*;
import java.text.*;
import java.time.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        System.out.println("starting the revision:");
        LocalDate started=null;
        try{
            started = LocalDate.of(2023, 9, 14);

        }catch(IllegalArgumentException e){

        }
        catch(NullPointerException e){

        }catch (Exception e){
            
        }
        LocalDate now = LocalDate.now();
        System.out.printf("day :: %d",Duration.between(started.atStartOfDay(),now.atStartOfDay()).toDays());
    }
}
