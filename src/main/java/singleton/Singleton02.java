package singleton;

/**
 * Created by Administrator on 2020/8/29.
 */
/**
 * 饱汉模式（懒汉模式）-ThreadSafe
 *  优点：同上，但加锁了。
 *  缺点：synchronized 为独占排他锁，并发性能差。即使在创建成功以后，获取实例仍然是串行化操作。
 */
public class Singleton02{
    private static Singleton02 singleton = null;
    private Singleton02(){

    }

    public static synchronized Singleton02 getInstance(){
        if(singleton == null){
            singleton = new Singleton02();
        }

        return singleton;
    }
}