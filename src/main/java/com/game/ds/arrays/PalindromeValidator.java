package com.game.ds.arrays;

public class PalindromeValidator {
    public static void main(String[] args){
//        System.out.println(replaceLast("?foo AB bar AB done?", "?", "--"));
        System.out.println(solution("?a?"));
    }
//    public static String replaceLast(String text, String regex, String replacement) {
//        text = text.replaceAll("\\?","\\?");
//        text = String.valueOf(new StringBuffer(text).reverse());
//        regex = String.valueOf(new StringBuffer(regex).reverse());
//        text = text.replaceFirst(regex, replacement);
//        text = String.valueOf(new StringBuffer(text).reverse());
//        return text;
//    }
    public static String solution(String S) {
        int n = S.length();
        String ret = S.replaceAll("\\?","_");

        for(int i = 0 ;i<n/2;i++){
            char c1 = ret.charAt(i);
            char c2 = ret.charAt(n-i-1);

            if(c1 == c2 ||  c1 == '_' || c2 == '_'){
                if(c1 == c2 ){
                    if( c1 != '_' && c2 != '_') continue;
                    ret = ret.replaceFirst("_","z");
                    ret = replaceLast(ret,"_","z");
                }
                else if(c1 == '_' && c2 == '_'){
                    ret = ret.replaceFirst("_","z");
                    ret = replaceLast(ret,"_","z");

                }
                else if(c1 == '_') {
                    ret = ret.replaceFirst("_",c2+"");
                }
                else ret = replaceLast(ret,"_",c1+"");;
            }else{
                return "NO";
            }
        }
        return ret;
    }
    public  static String replaceLast(String text, String regex, String replacement) {
        text = String.valueOf(new StringBuffer(text).reverse());
        regex = String.valueOf(new StringBuffer(regex).reverse());
        text = text.replaceFirst(regex, replacement);
        text = String.valueOf(new StringBuffer(text).reverse());
        return text;
    }
}
