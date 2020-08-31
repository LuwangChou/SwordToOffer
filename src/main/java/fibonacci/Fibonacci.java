package fibonacci;
// 面试题10：斐波那契数列
// 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。

/**
 * Created by Administrator on 2020/8/29.
 */
public class Fibonacci {
    /**
     *  递归方法 复杂度O(n)
     * @param n
     * @return
     */
    long getFinbonacciByRecursiveMethod(int n){
        if (n <= 0){
            return 0;
        }

        if (n == 1){
            return 1;
        }
        return getFinbonacciByRecursiveMethod(n - 1)+ getFinbonacciByRecursiveMethod(n - 2);
    }

    /**
     *  循环方法,复杂度O(n)
     * @param n
     * @return
     */
    long getFinbonacciByLoopMethod(int n){
        if (n == 0){
            return 0;
        }
        else if (n == 1){
            return 1;
        }

        long fibNMinusOne = 1;
        long fibNMinusTwo = 0;
        long fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN;
    }

    /**
     *  矩阵相乘方法
     * @param n
     * @return
     */
    long getFinbonacciByMatrixMethod(int n){
        if (n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        Matrix result = MultiMatrix.MatrixPower(n -1);
        return result.getM00();
    }

    void  test(String testName, int n,long expected){
        if (getFinbonacciByRecursiveMethod(n) == expected){
            System.out.println("Recursive Passed");
        }
        else{
            System.out.println("Recursive Failed");
        }
        if (getFinbonacciByLoopMethod(n) == expected){
            System.out.println("Loop Passed");
        }else{
            System.out.println("Loop Failed");
        }

        if (getFinbonacciByMatrixMethod(n) == expected){
            System.out.println("Matrix Passed");
        }else{
            System.out.println("Matrix Failed");
        }
    }
    public void executeTest(){
        test("Test1",0,0);
        test("Test2",1,1);
        test("Test3",2,1);
        test("Test4",3,2);
        test("Test5",4,3);
        test("Test6",5,5);
        test("Test7",6,8);
        test("Test8",7,13);
        test("Test9",8,21);
        test("Test10",9,34);
        test("Test11",10,55);
        test("Test11",40,102334155);
    }
}
