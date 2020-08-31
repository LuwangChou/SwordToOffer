package queuewithtwostacks;

import java.util.Iterator;
import java.util.Stack;
// 面试题9：用两个栈实现队列
// 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail
// 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。

//考虑2种情况：
// 1.A与B为空时，此时队列为空，出队操作不能执行;
// 2. A为空但是B不为空，此时入队操作，应该把栈B中的元素移回A，再执行A入栈
/**
 * Created by Administrator on 2020/8/30.
 */
public class Queue <T> {
    private Stack<T> stack1;
    private Stack<T> stack2;
    Queue(){
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }
    void appendTail(T node){
        if (stack2.isEmpty()){
            stack1.push(node);
        }else{
            T tempNode = null;
            while(!stack2.isEmpty()){
                tempNode = stack2.pop();
                stack1.push(tempNode);
            }
            stack1.push(node);
        }

    }
    T deleteHead(){
        T toBeDeleted = null;
        if (stack1.isEmpty()&&stack2.isEmpty()){
            return null;
        }
        else {
            T tempNode = null;
            while(!stack1.isEmpty()){
                tempNode = stack1.pop();
                if (tempNode != null){
                    stack2.push(tempNode);
                }
            }
        }
        toBeDeleted = stack2.pop();
        return toBeDeleted;
    }
}
