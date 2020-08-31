package minnumberinrotatedarray;
// 面试题11：旋转数组的最小数字
// 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
// 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。例如数组
// {3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
/**
 * 思路：对二分法的理解
 * 考虑两个特殊情况
 * 1. 含有重复数字 {1,0,1,1,1}  算法复杂度O(n)
 * 2. 不含有重复数字 {3, 4, 5, 1, 2}  算法复杂度O(n/2)
 */


/**
 * Created by Administrator on 2020/8/29.
 */
public class MinNumberInRotatedArray {
    int min(int[]numbers, int length){
        if (numbers == null || length <= 0){
            return -1;
        }
        int leftIndex = 0;
        int rightIndex = length - 1;
        int middleIndex = 0 ;
        if (numbers[leftIndex] < numbers[rightIndex]){
            return numbers[0];
        }
        while (numbers[leftIndex] >= numbers[rightIndex]){
            // 如果index1和index2指向相邻的两个数，
            // 则index1指向第一个递增子数组的最后一个数字，
            // index2指向第二个子数组的第一个数字，也就是数组中的最小数字
            if (rightIndex - leftIndex == 1){
                middleIndex = rightIndex;
                break;
            }
            // 如果下标为index1、index2和indexMid指向的三个数字相等，
            // 则只能顺序查找
            middleIndex = (leftIndex + rightIndex) / 2;
            if ((numbers[leftIndex] == numbers[middleIndex]) && (numbers[leftIndex] == numbers[rightIndex])){
                return minInOrder(numbers,leftIndex,rightIndex);
            }

            //缩小查找范围
            if (numbers[middleIndex] >= numbers[leftIndex]){
                leftIndex = middleIndex;
            } else if (numbers[middleIndex] <= numbers[rightIndex]){
                rightIndex = middleIndex;
            }
        }//while end
        return numbers[middleIndex];

    }

    /**
     *
     * @param numbers
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    private int minInOrder(int[] numbers, int leftIndex, int rightIndex) {
        int result = numbers[leftIndex];
        for (int i = leftIndex; i <= rightIndex; i++) {
            if (result > numbers[i]){
                result = numbers[i];
            }
        }
        return result;
    }

    void test(String testName, int[] numbers, int length,int expected){
        System.out.println(testName+"begins");

        int result = min(numbers,length);
        if (result == expected){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }

    public void executeTest(){
        // 典型输入，单调升序的数组的一个旋转
        int array1[] = { 3, 4, 5, 1, 2 };
        test("Test1",array1,array1.length,1);

        // 有重复数字，并且重复的数字刚好的最小的数字
        int array2[] = { 3, 4, 5, 1, 1, 2 };
        test("Test2",array2,array2.length,1);

        // 有重复数字，但重复的数字不是第一个数字和最后一个数字
        int array3[] = { 3, 4, 5, 1, 2, 2 };
        test("Test3",array3,array3.length,1);

        // 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
        int array4[] = { 1, 0, 1, 1, 1 };
        test("Test4",array4,array4.length,0);


        // 单调升序数组，旋转0个元素，也就是单调升序数组本身
        int array5[] = { 1, 2, 3, 4, 5 };
        test("Test5",array5,array5.length,1);

        // 数组中只有一个数字
        int array6[] = { 2 };
        test("Test5",array6,array6.length,2);


        // 输入nullptr
        test("Test6",null,0,-1);
    }
}
