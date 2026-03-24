package dsa.com.py.Blind75.T_05Strings;

import java.util.HashMap;
import java.util.Map;

public class Q_01_Isomorphic {
    class Solution {
    public boolean isIsomorphic(String s, String t) {
        int sLen = s.length();
        Map<Character, Character> map = new HashMap<>();
        if( sLen != t.length()) return false;
        for(int i = 0; i < sLen; i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(map.containsKey(ch1) == false){
                if(map.containsValue(ch2)) return false;
                map.put(ch1, ch2);
            }else{
                if( map.get(ch1) != ch2){
                    return false;
                }
            }
        }
        return true;
    }
}
}
