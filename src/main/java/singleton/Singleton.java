package singleton;

/**
 * Created by Administrator on 2020/8/29.
 */
// 面试题2：实现Singleton模式
// 题目：设计一个类，我们只能生成该类的一个实例。
//单例模式的5种实现
public class Singleton {
    public Singleton(){
        System.out.println("Singleton Start");
        singleton01 = Singleton01.getInstance();
        singleton02 = Singleton02.getInstance();
        singleton03 = Singleton03.getInstance();
        singleton04 = Singleton04.getInstance();
        singleton05 = Singleton05.getInstance();
        System.out.println("Singleton End");
    }

    public Singleton01 singleton01;
    public Singleton02 singleton02;
    public Singleton03 singleton03;
    public Singleton04 singleton04;
    public Singleton05 singleton05;

}

/*
备注：

1. 全局共享，独一份；

2. 构造函数不暴露（如果暴露便不能保证一份），自己负责自己的构造；

3. 懒汉式：Lazy load，用到才加载，非线程安全。如何保证线程安全呢：

（1） synchronized getInstance()。

（2）双重检查加锁（volatile）。

4. 饿汉式：一开始就申请好，浪费了点资源，但其线程安全。

5. Holder模式：

（1）改成内部类，由JVM保证线程安全性。
 */