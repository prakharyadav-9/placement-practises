package com.py.sheet.string.medium;

public class Q13_StringDecode {
    private int i=0;
    public String decodeString(String s) {
        StringBuilder res =new StringBuilder();
        char ch;
        while(i<s.length()&&']'!=(ch=s.charAt(i))){
            if(Character.isDigit(ch)){
                int k=0;
                while(i<s.length()&&Character.isDigit(ch=s.charAt(i))){
                    k=k*10+(ch-'0');
                    i++;
                } // now we have reached to '['
                i++; // therefore skip '['
                String r=decodeString(s);
                while(k-- >0){
                    res.append(r);
                }
                i++; // spipping ']'
            }else{
                res.append(s.charAt(i++));
            }
        }

        return res.toString();
    }
    public static void main(String...args){
        String s="3[a2[c]]" ; //"3[ab]2[c]";//"2[abc]3[cd]ef";//
        String res = new Q13_StringDecode().decodeString(s);
        System.out.println(res);
    }
}
