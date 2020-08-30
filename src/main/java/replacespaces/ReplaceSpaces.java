package replacespaces;
// 面试题5：替换空格
// 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
// 则输出“We%20are%20happy.”。

import Utilities.Array;

/**
 * Created by Administrator on 2020/8/29.
 */
public class ReplaceSpaces {
    /**
     * 思路从后面往前 替换即可
     * 1. 计算空格数量
     * 2. 从后面往前替换
     */

    /*length 为字符数组str的总容量，大于或等于字符串str的实际长度*/
    char[] ReplaceBlank(char[] str,int maxLength) {
        if (str == null && maxLength <= 0) {
            return null;
        }
        //originalLength 为字符串str的实际长度

        int originalLength = 0;
        int numberOfBlank = 0;
        int length = str.length;
        originalLength = length;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                ++numberOfBlank;
            }
        }

        //newLength 为把空格替换成'%20' 之后的长度
        int newLength = originalLength + numberOfBlank * 2;
        if (newLength > maxLength) {
            return null;
        }
        char[] newStr = new char[newLength];
        int indexOfOriginal = originalLength - 1;
        int indexOfNew = newLength - 1;
        while (indexOfOriginal >= 0 && indexOfNew >= 0) {

            if (str[indexOfOriginal] == ' ') {
                newStr[indexOfNew--] = '0';
                newStr[indexOfNew--] = '2';
                newStr[indexOfNew--] = '%';
            } else {
                newStr[indexOfNew--] = str[indexOfOriginal];
            }
            --indexOfOriginal;
        }
        return newStr;
    }

    int CompareString(String string, String anotherString){
        int len1 = string.length();
        int len2 = anotherString.length();
        int lim = Math.min(len1, len2);
        char v1[] = string.toCharArray();
        char v2[] = anotherString.toCharArray();

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }
    int CompareString(char[] string, char[] anotherString){
        int length = string.length;
        int lengthAnother = anotherString.length;
        if (length != lengthAnother){
            return -1;
        }
        for (int k = 0; k < length; k++) {
            char c1 = string[k];
            char c2 = anotherString[k];
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        return 0;
    }
    // ====================测试代码====================
    void Test(String testName, char[] str, int length, char []expected)
    {
        if(testName != null) {
            System.out.println("%s begins: " + testName);
        }

        char[] result = ReplaceBlank(str, length);

        if(expected == null && result == null) {
            System.out.println("passed.\n");
        }
        else if(expected == null && result != null) {
            System.out.println("failed.\n");
        }
        else if(CompareString(result,expected) == 0) {
            System.out.println("passed.\n");
        }
        else {
            System.out.println("failed.\n");
        }
    }

    // 空格在句子中间
    void Test1()
    {
        int length = 100;

        char []str = "hello world".toCharArray();
        Test("Test1", str, length, "hello%20world".toCharArray());
    }

    // 空格在句子开头
    void Test2()
    {
        int length = 100;

        char []str = " helloworld".toCharArray();
        Test("Test2", str, length, "%20helloworld".toCharArray());
    }

    // 空格在句子末尾
    void Test3()
    {
        int length = 100;
        char []str = "helloworld ".toCharArray();
        Test("Test3", str, length, "helloworld%20".toCharArray());
    }

    // 连续有两个空格
    void Test4()
    {
        int length = 100;

        char []str = "hello  world".toCharArray();
        Test("Test4", str, length, "hello%20%20world".toCharArray());
    }

    // 传入null
    void Test5()
    {
        Test("Test5", null, 0, null);
    }

    // 传入内容为空的字符串
    void Test6()
    {
        int length = 100;

        char []str = "".toCharArray();
        Test("Test6", str, length, "".toCharArray());
    }

    //传入内容为一个空格的字符串
    void Test7()
    {
        int length = 100;

        char []str = " ".toCharArray();
        Test("Test7", str, length, "%20".toCharArray());
    }

// 传入的字符串没有空格
    void Test8()
    {
        int length = 100;

        char []str = "helloworld".toCharArray();
        Test("Test8", str, length, "helloworld".toCharArray());
    }

// 传入的字符串全是空格
    void Test9()
    {
        int length = 100;

        char []str = "   ".toCharArray();
        Test("Test9", str, length, "%20%20%20".toCharArray());
    }

    public void executeTest()
    {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();
        Test7();
        Test8();
        Test9();
    }

}
