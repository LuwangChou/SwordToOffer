package accumulate;

/**
 * Created by Administrator on 2020/9/3.
 */
public class Temp {
    public Temp(){

    }
    private static int n;
    private static int sum;
    public static void reset(){
        n = 0 ;
        sum = 0;
    }
    public static int getSum(){
        return sum;
    }
}
