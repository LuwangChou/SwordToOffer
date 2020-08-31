package fibonacci;

/**
 *  复杂度为O(logn)
 *  斐波那契数列计算公式（十分冷僻）
 * [ f(n)  f(n-1)  ]  = [ 1 1 ] ^(n-1))
 * [ f(n-1) f(n-2) ]    [ 1 0 ]
 *
 *
 * a^ (n) = { a^ (n/2) * a^ (n/2)               n为奇数
 *          { a^ ((n-1)/2) * a^ ((n-1)/2)*a       n为偶数
 */

/**
 * Created by Administrator on 2020/8/31.
 */
public class Matrix {
    public long getM00() {
        return m00;
    }

    public void setM00(long m00) {
        this.m00 = m00;
    }

    public long getM01() {
        return m01;
    }

    public void setM01(long m01) {
        this.m01 = m01;
    }

    public long getM10() {
        return m10;
    }

    public void setM10(long m10) {
        this.m10 = m10;
    }

    public long getM11() {
        return m11;
    }

    public void setM11(long m11) {
        this.m11 = m11;
    }

    private long m00;
    private long m01;
    private long m10;
    private long m11;
    Matrix(long m00,long m01, long m10,long m11){
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
    }


}
