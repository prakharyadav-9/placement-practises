package com.py.practise.postps.leetcode.potd.M01;

import java.util.*;

public class POTD24_01_23 {

    // Optimal My Approach
    public int maxLength(List<String> arr) {
        return maxLength(arr, 0, new HashSet<>());
    }

    int maxLength(List<String> arr, int idx, Set<Character> set) {
        if (idx >= arr.size()) {
            return set.size(); // till the point now whatever you have in DS return size
        }
        // not picking
        int notPicked = maxLength(arr, 1 + idx, set);
        boolean isPicked = true; // marking if the current ele is picked
        // try picking
        String ele = arr.get(idx);
        int sz = ele.length(), i;
        for (i = 0; i < sz; i++) {
            char ch = ele.charAt(i);
            if (set.contains(ch)) {
                while (--i >= 0) {
                    char chRm = ele.charAt(i);
                    set.remove(chRm); // removing all current ele char if added already
                }
                isPicked = false; // this element wont be picking
                break; // break the for loop
            } else {
                set.add(ch);
            }
        }
        if (false == isPicked) {
            return notPicked; // element wasn't picked so directly return the notPicked maxLength
        }
        int picked = maxLength(arr, 1 + idx, set); // curr element is picked
        // removing the current element
        for (i = 0; i < sz; i++) {
            set.remove(ele.charAt(i)); // only if curr element was picked
        }
        return Math.max(notPicked, picked); // maximizing of both the possibilities
    }

    public static void main(String args[]) {
        List<String> arr = Arrays.asList(
                // "un", "iq", "ue"
                // "cha", "r", "act", "ers"
                // "abcdefghijklmnopqrstuvwxyz"
                "aa");
        int maxLength = new POTD24_01_23()
                .maxLength(arr);
        System.out.println(maxLength);
    }
    /*
     * //Non Optimal calling overlapping sub-problems
     * public int maxLength(List<String> arr) {
     * return maxLength(arr, 0, new HashSet<>());
     * }
     * 
     * int maxLength(List<String> arr, int idx, Set<Character> set) {
     * if (idx >= arr.size()) {
     * return set.size(); // till the point now whatever you have in DS return size
     * }
     * // not picking
     * int notPicked = maxLength(arr, 1 + idx, set);
     * boolean isPicked = true; // marking if the current ele is picked
     * // try picking
     * String ele = arr.get(idx);
     * int sz = ele.length(), i;
     * for (i = 0; i < sz; i++) {
     * char ch = ele.charAt(i);
     * if (set.contains(ch)) {
     * while (--i >= 0) {
     * char chR = ele.charAt(i);
     * set.remove(chR); // removing all current ele char if added already
     * }
     * isPicked = false; // this element wont be picking
     * break; // break the for loop
     * } else {
     * set.add(ch);
     * }
     * }
     * int picked = maxLength(arr, 1 + idx, set);
     * // removing the current element
     * for (i = 0; isPicked && i < sz; i++) {
     * set.remove(ele.charAt(i)); // only if curr element was picked
     * }
     * return Math.max(notPicked, picked);
     * }
     */
}
