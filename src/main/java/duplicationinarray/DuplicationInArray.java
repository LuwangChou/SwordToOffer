package duplicationinarray;


// 面试题3（一）：找出数组中重复的数字
// 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
// 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
// 那么对应的输出是重复的数字2或者3。

import number.IntegerIdenticalToIndex;

import java.util.List;
import java.util.Vector;

/**
 * Created by Administrator on 2020/8/29.
 */
public class DuplicationInArray {

    /**
     *
     * @param numbers  一个整数数组
     * @param length 数组的长度
     * @param expect 数组中的重复的数字
     * @return 是否有重复数字
     */
    boolean duplicate(int[] numbers, int length, int[] expect){
        if (numbers == null || length <= 0){
            return false;
        }
        if (expect == null){
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1){
                return false;
            }
        }
        int lengthExpect = expect.length;
        int indexExpect = 0;
        boolean isDuplicate = false;
        //本质上是用hash 的思想，主要数组前提条件是数字范围为[0,n-1]
        //每个数字hash (% n) 得到每个数字位置，位置上有值则频率重复
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i){
                if (numbers[i] == numbers[numbers[i]]){
                    if(indexExpect >=0 && indexExpect < lengthExpect){
                        expect[indexExpect] = numbers[i];
                        ++indexExpect;
                        isDuplicate = true;
                        break;
                    }

                }
                //交换numbers[i] 和numbers[numbers[i]]
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
                if (indexExpect == lengthExpect){
                    break;
                }
            }
        }
        return isDuplicate;
    }


    boolean contains(int[] array, int length, int number){
        if (array == null || length <=0){
            return false;
        }
        for (int i = 0; i < length; i++) {
            if(array[i] == number){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param testName
     * @param numbers
     * @param lengthNumbers
     * @param expected
     * @param lengthExpected
     * @param validArgument
     */
    void test(String testName,int []numbers, int lengthNumbers, int [] expected, int lengthExpected ,boolean validArgument){
        System.out.println(testName+"begins");

        int[] duplication = new int[lengthExpected];
        boolean validInput = duplicate(numbers,lengthNumbers,duplication);

        if (validArgument == validInput){
            if(validArgument){
                boolean allMatch = true;
                for (int i = 0; i < lengthExpected; i++) {
                    if( !contains(expected,lengthExpected,duplication[i]) ){
                        allMatch = false;
                    }
                }
                if(allMatch){
                    System.out.println("Passed");
                }else{
                    System.out.println("Failed");
                }
            }else{
                System.out.println("Passed");
            }
        }else{
            System.out.println("Failed");
        }
    }


    // 重复的数字是数组中最小的数字
    void test1()
    {
        int numbers[] = { 2, 1, 3, 1, 4 };
        int duplications[] = { 1 };
        test("Test1", numbers, numbers.length, duplications, duplications.length , true);
    }

    // 重复的数字是数组中最大的数字
    void test2()
    {
        int numbers[] = { 2, 4, 3, 1, 4 };
        int duplications[] = { 4 };
        test("Test2", numbers, numbers.length, duplications, duplications.length, true);
    }

    // 数组中存在多个重复的数字
    void test3()
    {
        int numbers[] = { 2, 4, 2, 1, 4 };
        int duplications[] = { 2, 4 };
        test("Test3", numbers, numbers.length, duplications, duplications.length, true);
    }

    // 没有重复的数字
    void test4()
    {
        int numbers[] = { 2, 1, 3, 0, 4 };
        int duplications[] = { -1 }; // not in use in the test function
        test("Test4", numbers ,numbers.length, duplications, duplications.length, false);
    }

    // 没有重复的数字
    void test5()
    {
        int numbers[] = { 2, 1, 3, 5, 4 };
        int duplications[] = { -1 }; // not in use in the test function
        test("Test5", numbers, numbers.length, duplications, duplications.length, false);
    }

    // 无效的输入
    void test6()
    {
        int[] numbers = null;
        int duplications[] = { -1 }; // not in use in the test function
        test("Test6", numbers, 0, duplications, duplications.length, false);
    }

    public void executeTest(){
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

}


