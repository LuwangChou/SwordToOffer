package singleton;

/**
 * Created by Administrator on 2020/8/29.
 */
/**
 *  饱汉模式（懒汉模式） UnThreadSafe
 *  优点：懒加载启动快，资源占用小，使用时才实例化，无锁。
 *  缺点：非线程安全。
 */
public class Singleton01{
    private static Singleton01 singleton = null;
    private Singleton01(){

    }

    public static Singleton01 getInstance(){
        if (singleton==null){
            singleton = new Singleton01();
        }
        return singleton;
    }

}