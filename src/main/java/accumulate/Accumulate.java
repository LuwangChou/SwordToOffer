package accumulate;
// 面试题64：求1+2+…+n
// 题目：求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case
// 等关键字及条件判断语句（A?B:C）。
/**
 * Created by Administrator on 2020/8/29.
 */
public class Accumulate {

    public Accumulate(){

    }

    /**
     *  方法一：使用构造函数的方法
     * @param n
     * @return
     */
    static int getSum(int n){
        Temp.reset();
        Temp[] temp = new Temp[n];
        return Temp.getSum();
    }

    /**
     * 方法二：使用递归类方法
     */

    /**
     * 方法三：使用函数指针方法
     * java无指针
     */

    /**
     * 方法四：利用模板类型求解
     */



}
