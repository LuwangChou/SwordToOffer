package duplicationinarray;


// 面试题3（二）：不修改数组找出重复的数字
// 题目：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至
// 少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的
// 数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的
// 输出是重复的数字2或者3。

/**
 * Created by Administrator on 2020/8/29.
 */
public class DuplicationInArrayNoEdit {

    /**
     *
     * @param numbers
     * @param length
     * @return
     */
    int getDuplication(int[] numbers, int length){
        if (numbers == null || length <= 0){
            return -1;
        }
        int start = 1;
        int end = length -1;
        while(end >= start){
            int middle = ((end - start) >> 1 ) + start;
            int count = countRange(numbers, length, start, middle);
            if(end == start){
                if(count > 1) {
                    return start;
                }
                else{
                    break;
                }
            }

            if (count > (middle - start + 1)){
                end = middle;
            }
            else {
                start = middle + 1;
            }
        }
        return -1;
    }

    int countRange(int[] numbers, int length, int start, int end) {
        if (numbers == null){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if(numbers[i] >= start && numbers[i] <= end){
                ++count;
            }
        }
        return count;
    }
    // ====================测试代码====================
    void test(String testName, int[] numbers, int length, int[] duplications, int dupLength){
        int result = getDuplication(numbers,length);
        for (int i = 0; i < dupLength; i++) {
            if(result == duplications[i]){
                System.out.println(testName+"\npassed");
                return;
            }
        }
        System.out.println(testName+"\nfailed");
    }
    // 多个重复的数字
    void test1(){
        int [] numbers = {2, 3, 5, 4, 3, 2, 6, 7 };
        int [] duplications = {2, 3};
        test("test1",numbers,numbers.length,duplications,duplications.length);

    }
    // 一个重复的数字
    void test2(){
        int [] numbers = {3, 2, 1, 4, 4, 5, 6, 7};
        int [] duplications = {4 };
        test("test2",numbers,numbers.length,duplications,duplications.length);
    }
    // 重复的数字是数组中最小的数字
    void test3(){
        int [] numbers = {1, 2, 3, 4, 5, 6, 7, 1, 8};
        int [] duplications = { 1 };
        test("test3",numbers,numbers.length,duplications,duplications.length);
    }

    // 重复的数字是数组中最大的数字
    void test4(){
        int [] numbers = { 1, 7, 3, 4, 5, 6, 8, 2, 8 };
        int [] duplications = { 8 };
        test("test4",numbers,numbers.length,duplications,duplications.length);
    }
    // 数组中只有两个数字
    void test5(){
        int [] numbers = {1, 1};
        int [] duplications = { 1 };
        test("test5",numbers,numbers.length,duplications,duplications.length);
    }
    // 重复的数字位于数组当中
    void test6(){
        int [] numbers = {3, 2, 1, 3, 4, 5, 6, 7 };
        int [] duplications = { 3 };
        test("test6",numbers,numbers.length,duplications,duplications.length);
    }
    // 多个重复的数字
    void test7(){
        int [] numbers = { 1, 2, 2, 6, 4, 5, 6 };
        int [] duplications = { 2,6 };
        test("test7",numbers,numbers.length,duplications,duplications.length);
    }
    // 一个数字重复三次
    void test8(){
        int [] numbers = { 1, 2, 2, 6, 4, 5, 2};
        int [] duplications = { 2 };
        test("test8",numbers,numbers.length,duplications,duplications.length);
    }
    // 没有重复的数字
    void test9(){
        int [] numbers = { 1, 2, 6, 4, 5, 3 };
        int [] duplications = { -1 };
        test("test9",numbers,numbers.length,duplications,duplications.length);
    }
    // 无效的输入
    void test10(){
        int [] numbers = null;
        int [] duplications = { -1 };
        test("test10",numbers,0,duplications,duplications.length);
    }


    public void executeTest(){
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
    }
}
