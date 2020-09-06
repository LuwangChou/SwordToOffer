package cuttingrope;


// 面试题14：剪绳子
// 题目：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
// 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
// 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
// 时得到最大的乘积18。

/**
 * Created by Administrator on 2020/8/29.
 */
public class CuttingRope {

    public CuttingRope(){

    }

    /**
     *  动态规划算法
     * @param length
     * @return
     */
    public int maxProductAfterCuttingUsingDP(int length){
        if (length < 2){
            return 0;
        }
        if (length == 2){
            return 1;
        }
        if (length == 3){
            return 2;
        }

        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i/2; j++) {
                int product = products[j] * products[i-j];
                if (max < product){
                    max = product;
                }
                products[i] = max;
            }
        }

        max = products[length];
        return max;
    }


    /**
     *  贪婪算法
     * @param length
     * @return
     */
    public int maxProductAfterCuttingUsingGreedy(int length){
        if (length < 2){
            return 0;
        }
        if (length == 2){
            return 1;
        }
        if (length == 3){
            return 2;
        }

        //尽可能多地减去长度为3的绳子段
        int timesOf3 = length / 3;

        // 当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段。
        // 此时更好的方法是把绳子剪成长度为2的两段，因为2*2 > 3*1。
        if (length - timesOf3 * 3 == 1){
            timesOf3 = timesOf3 - 1;
        }

        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) (Math.pow(3,timesOf3)) * (int)(Math.pow(2,timesOf2)) ;
    }

    void test(String testName, int length, int expected){
        System.out.println(testName + " begins.");
        int result1 = maxProductAfterCuttingUsingDP(length);
        if (expected == result1){
            System.out.println("DP:Passed");
        }else{
            System.out.println("DP:Failed");
        }
        int result2 = maxProductAfterCuttingUsingGreedy(length);
        if (expected == result2){
            System.out.println("Greedy:Passed");
        }else{
            System.out.println("Greedy:Failed");
        }
    }

    public void executeTest(){
        test("Test1",1,0);
        test("Test2",2,1);
        test("Test3",3,2);
        test("Test4",4,4);
        test("Test5",5,6);
        test("Test6",6,9);
        test("Test7",7,12);
        test("Test8",8,18);
        test("Test9",9,27);
        test("Test10",10,36);
        test("Test11",50,86093442);

    }

}
