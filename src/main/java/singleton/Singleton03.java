package singleton;

/**
 * Created by Administrator on 2020/8/29.
 */
/**
 * 饱汉模式(懒汉模式)--双重加锁检查DCL（Double Check Lock）
 * 优点：懒加载，线程安全。
 * 注：实例必须有 volatile 关键字修饰，其保证初始化完全。
 */
public class Singleton03 {
    private volatile static Singleton03 singleton = null;

    private Singleton03() {

    }

    public static Singleton03 getInstance() {
        if (singleton == null) {
            //同步块，线程安全的创建实例
            synchronized (Singleton03.class) {
                //再次检查实例是否存在，如果不存在才真的创建实例
                if (singleton == null) {
                    singleton = new Singleton03();
                }
            }
        }
        return singleton;
    }
}


