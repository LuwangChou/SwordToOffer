package Utilities;

/**
 * Created by Administrator on 2020/8/29.
 */
public class StringUtil {
    static String Reverse(String str){
        char[] chStr = str.toCharArray();
        String reverseStr = "";
        for (int i = chStr.length-1; i >= 0 ; i--){
            reverseStr = reverseStr + chStr[i];
        }
        return  reverseStr;
    }
    static String StringBuilderReverse(String str){
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * 思路是字符串均分为两半，头尾交换即可，如果长度为奇数中间无需变换位置
     * @param str
     * @return
     */
    static String StringBuilderSourceCodeReverse(String str){
        int count = str.length();
        char[] value = str.toCharArray();
        int n = count - 1;
        for (int j = (n-1) >> 1; j >= 0; j--) {
            int k = n - j;
            char cj = value[j];
            char ck = value[k];
            value[j] = ck;
            value[k] = cj;
        }
        String reverseStr = value.toString();
        return reverseStr;
    }
}
