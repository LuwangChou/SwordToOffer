package findInpartiallysortedmatrix;
// 面试题4：二维数组中的查找
// 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
// 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
// 整数，判断数组中是否含有该整数。

/**
 * 思路是按照从左下开始，往上是递减，往右是递增
 */

/**
 * Created by Administrator on 2020/8/29.
 */
public class FindInPartiallySortedMatrix {
    boolean find(int[][] matrix, int rows, int columns, int number){
        boolean found = false;
        if ((matrix != null) && (rows > 0) && (columns > 0)){
            int row = 0;
            int column = columns -1;
            while ((row < rows) && (column >= 0)){
                if (matrix[row][column] == number){
                    found = true;
                    break;
                }
                else if(matrix[row][column] > number){
                    --column;
                }
                else {
                    ++row;
                }
            }
        }
        return found;
    }
    // ====================测试代码====================
    void test(String testName, int[][]matrix ,int rows,int columns, int number, boolean expected){
        System.out.println(testName+"begins");
        boolean result = find(matrix, rows, columns,number);
        if (result == expected){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }

    //  1   2   8   9
//  2   4   9   12
//  4   7   10  13
//  6   8   11  15
// 要查找的数在数组中
    void test1()
    {
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        test("test1", matrix, 4, 4, 7, true);
    }

    //  1   2   8   9
//  2   4   9   12
//  4   7   10  13
//  6   8   11  15
// 要查找的数不在数组中
    void test2()
    {
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        test("test2", matrix, 4, 4, 5, false);
    }

    //  1   2   8   9
//  2   4   9   12
//  4   7   10  13
//  6   8   11  15
// 要查找的数是数组中最小的数字
    void test3()
    {
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        test("test3", matrix, 4, 4, 1, true);
    }

    //  1   2   8   9
//  2   4   9   12
//  4   7   10  13
//  6   8   11  15
// 要查找的数是数组中最大的数字
    void test4()
    {
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        test("test4", matrix, 4, 4, 15, true);
    }

    //  1   2   8   9
//  2   4   9   12
//  4   7   10  13
//  6   8   11  15
// 要查找的数比数组中最小的数字还小
    void test5()
    {
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        test("test5", matrix, 4, 4, 0, false);
    }

    //  1   2   8   9
//  2   4   9   12
//  4   7   10  13
//  6   8   11  15
// 要查找的数比数组中最大的数字还大
    void test6()
    {
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        test("test6", matrix, 4, 4, 16, false);
    }

    // 鲁棒性测试，输入空指针
    void test7()
    {
        test("test7", null, 0, 0, 16, false);
    }

    public void executeTest(){
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
}
