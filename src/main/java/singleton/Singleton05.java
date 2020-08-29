package singleton;

/**
 * Created by Administrator on 2020/8/29.
 */
/**
    * Holder模式
    * 优点：将懒加载和线程安全完美结合的一种方式（无锁）。（推荐）
    */
public class Singleton05{
    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     * 没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
     */
    private static class SingletonHolder{
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static Singleton05 singleton = new Singleton05();
    }
    /**
     * 私有化构造方法
     */
    private Singleton05(){

    }

    public static Singleton05 getInstance(){
        return SingletonHolder.singleton;
    }

}
