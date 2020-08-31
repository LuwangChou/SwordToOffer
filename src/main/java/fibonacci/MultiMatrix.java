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
public class MultiMatrix {
    MultiMatrix(){

    }
    public static Matrix MatrixMultiply(Matrix matrix1, Matrix matrix2){
        Matrix result = null;
        result = new Matrix(matrix1.getM00()* matrix2.getM00()+matrix1.getM01()*matrix2.getM10(),
                matrix1.getM00()* matrix2.getM01()+matrix1.getM01()*matrix2.getM11(),
                matrix1.getM10()* matrix2.getM00()+matrix1.getM11()*matrix2.getM10(),
                matrix1.getM10()* matrix2.getM01()+matrix1.getM11()*matrix2.getM11());
        return result;
    }
    public static Matrix MatrixPower(int n){
        if(n <=0 ){
            return null;
        }

        Matrix matrix = null;
        if (n==1){
            matrix = new Matrix(1,1,1,0);
        }
        else if(n % 2 == 0){//偶数
            matrix = MatrixPower(n/2);
            matrix = MatrixMultiply(matrix,matrix);
        }
        else if(n % 2 == 1){//奇数
            matrix = MatrixPower((n-1)/2);
            matrix = MatrixMultiply(matrix,matrix);
            matrix = MatrixMultiply(matrix,new Matrix(1,1,1,0));
        }
        return matrix;
    }
}
