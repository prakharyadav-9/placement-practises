package com.py.specials;

import java.util.*;

public class Q03_LexSortWithAGivenOrder {
    /**
     * Given a word which will be the order of the words 
     * lexicographical sort the given list of string according to the order
     */

    public static void main(String args[]){
        String word="balujemy";//"re";
        ArrayList<String> list = new ArrayList<>(
            // Arrays.asList("rer","er","rr")
            // Arrays.asList("ere","rer","re")
            Arrays.asList("bel","luba","lej","bal","Leje")
            );
        List<String> res = null;
        // res = printLexicographic(word,list);
        // System.out.println(res);
        // System.out.println(list);
        // Map<Character,Integer> map=new HashMap<>();
        // int strLen = word.length();
        // for(int i=0;i<strLen;i++){
        //     char ch=word.charAt(i);
        //     map.put(ch,i); // handling small letter according to given word
        //     map.put((char)(ch-32),i); // handling capital letters
        // }
        int map[] = new int[26];
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            map[ch-'a']=i+1; // this is always going to be small letter
        } 
        System.out.println("list compartor::");
        System.out.println(Arrays.toString(map));
        list.sort((a,b)->{
                    int len1 = a.length();
                    int len2 = b.length();
                    int lim = Math.min(len1, len2);

                    int k = 0;
                    while (k < lim) {
                        char c1 = a.charAt(k);
                        if(c1<='Z'){
                            c1 = (char)(c1+32);
                        }
                        char c2 = b.charAt(k);
                        if(c2<='Z'){
                            c2 = (char)(c2+32);
                        }
                        if (c1 != c2) {
                            return map[c1-'a']-map[c2-'a'];//map.get(c1) - map.get(c2);
                        }
                    k++;
                    }
                    return len1 - len2;
                });
        System.out.println(list);
    }

    private static List<String> printLexicographic(String word, ArrayList<String> list) {
        String[] arr = new String[list.size()];
        for(int i=0;i<arr.length;i++){
            arr[i] = list.get(i);
        }
        // make map
        Map<Character,Integer> map=new HashMap<>();
        int strLen = word.length();
        for(int i=0;i<strLen;i++){
            char ch=word.charAt(i);
            map.put(ch,i); // handling small letter according to given word
            map.put((char)(ch-32),i); // handling capital letters
        }
        System.out.println(map);
        mergeSort(arr, 0, arr.length-1,map);
        // System.out.println(Arrays.toString(arr));
        return Arrays.asList(arr);
    }

    /* */
    // Merge two subarrays arr[l..m] and arr[m+1..r]
  static void merge(String arr[], int l, int m, int r, Map<Character, Integer> map)
  {
    int i, j, k;
    int n1 = m - l + 1;
    int n2 =  r - m;
 
    /* create temp arrays */
    String L[] = new String[n1], R[] = new String[n2];
 
    /* Copy data to temp arrays L[] and R[] */
    for (i = 0; i < n1; i++)
      L[i] = arr[l + i];
 
    for (j = 0; j < n2; j++)
      R[j] = arr[m + 1+ j];
 
    /* Merge the temp arrays back into arr[l..r]*/
    i = 0; // Initial index of first subarray
    j = 0; // Initial index of second subarray
    k = l; // Initial index of merged subarray
    while (i < n1 && j < n2)
    {
    //   if (L[i].compareTo(R[j])<=0)
        if(comparString(L[i], R[j], map)<=0)
      {
        arr[k] = L[i];
        i++;
      }
      else
      {
        arr[k] = R[j];
        j++;
      }
      k++;
    }
 
    /* Copy the remaining elements of L[], if there
       are any */
    while (i < n1)
    {
      arr[k] = L[i];
      i++;
      k++;
    }
 
    /* Copy the remaining elements of R[], if there
       are any */
    while (j < n2)
    {
      arr[k] = R[j];
      j++;
      k++;
    }
  }
 
  /* l is for left index and r is right index of the
   sub-array of arr to be sorted */
  static void mergeSort(String arr[], int l, int r, Map<Character, Integer> map)
  {
    if (l < r)
    {
      // Same as (l+r)/2, but avoids overflow for
      // large l and h
      int m = l+(r-l)/2;
 
      // Sort first and second halves
      mergeSort(arr, l, m,map);
      mergeSort(arr, m+1, r,map);
 
      merge(arr, l, m, r,map);
    }
  }
  
  private static int comparString(String a,String b, Map<Character, Integer> map){
        int len1 = a.length();
        int len2 = b.length();
        int lim = Math.min(len1, len2);

        int k = 0;
        while (k < lim) {
            char c1 = a.charAt(k);
            char c2 = b.charAt(k);
            if (c1 != c2) {
                return map.get(c1) - map.get(c2);
            }
            k++;
        }
        return len1 - len2;
  }
 
}
