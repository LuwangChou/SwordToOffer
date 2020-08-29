package singleton;

/**
 * Created by Administrator on 2020/8/29.
 */
// 面试题2：实现Singleton模式
// 题目：设计一个类，我们只能生成该类的一个实例。
//单例模式的5种实现
public class Singleton {

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