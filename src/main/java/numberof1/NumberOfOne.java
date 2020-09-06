package numberof1;
// 面试题15：二进制中1的个数
// 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
// 把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。

//问题1： 除法运算和整数右移移位是等价的，右移算法比移位算法效率低
//正数补码是其本身，负数的补码是负数的源码取反加一得到的补码

//问题2：为什么不用右移而用左移？
// Ans: 因为右移涉及到负数的话，会在最高位一直置为1, 使用左移& 1就可以了

import static java.lang.Integer.toBinaryString;
import static java.lang.Integer.toUnsignedLong;

/**
 * Created by Administrator on 2020/8/29.
 */
public class NumberOfOne {

    public NumberOfOne(){

    }



    /**
     * 使用移位算法
     * 算法复杂度为O(n)
     * @param number
     * @return
     */
    public int countNumberOfOneUsingShift(int number){



        //int 使用4字节内存 32bit
        int flag = 1;
        int count = 0;
        for (int index = 0; index < 32; index++) {
            int isOne = 0;
            isOne = (number & flag);
            //System.out.println("isOne:"+ isOne);
            if (isOne != 0){
                ++count;
            }
            flag = flag << 1;
        }
        System.out.println("for count: "+count);



        //number右移，输入负数时会陷入死循环,不建议
//        count = 0;
//        while (number != 0){
//            int isOne = (number & 1);
//            if (isOne==1){
//                ++count;
//            }
//            number = isOne >> 1;
//        }

        //flag左移
        while (flag != 0){
            int isOne = (number & flag);
            if (isOne==1){
                ++count;
            }
            flag = flag << 1;
        }

        System.out.println("while count: "+count);
        return count;
    }

    /**
     * 小技巧，并不通用，通过二进制计算时，number 与 number-1 的规律去做，
     * 与邻近数(number-1) 会产生借1效果
     * 举例说明：以8位整数计算为例
     *  11 = 0001 0011
     *  10 = 0001 0010
     * &
     *  10 = 0001 0010 (第一次&)
     *
     *  10 = 0001 0010
     *   9 = 0001 0001
     * &
     *   8 = 0001 0000 (第二次&)
     * @param number
     * @return
     */
    int countNumberOfOneUsingTrick(int number){
        int count = 0;
        while(number != 0){
            ++count;
            number = (number & (number-1));
        }
        return count;
    }

    void test(String testName,int number,int expected){
        System.out.println(testName+" begins");
        System.out.println("number="+number);
        int count = countNumberOfOneUsingShift(number);
        if (count == expected){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        count = countNumberOfOneUsingTrick(number);
        if (count == expected){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }
    public void executeTest(){
         //输入0，期待的输出是0
        test("Test1",0, 0);

        // 输入1，期待的输出是1
        test("Test2",1, 1);

        // 输入10，期待的输出是2
        test("Test3",10, 2);

        // 输入0x7FFFFFFF，期待的输出是31
        test("Test4",0x7FFFFFFF, 31);

        // 输入0xFFFFFFFF（负数），期待的输出是32
        test("Test5",0xFFFFFFFF, 32);

        // 输入0x80000000（负数），期待的输出是1
        test("Test6",0x80000000, 1);

        //test("Test1111",0x00000111,3);
    }
}
