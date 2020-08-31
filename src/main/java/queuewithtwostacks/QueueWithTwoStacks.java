package queuewithtwostacks;
// 面试题9：用两个栈实现队列
// 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail
// 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。

//A与B为空时，此时队列为空，出队操作不能执行;
//A为空但是B不为空，此时入队操作，应该把栈B中的元素移回A，再执行A入栈
/**
 * Created by Administrator on 2020/8/29.
 */
public class QueueWithTwoStacks {
    void Test(String testName, String actual, String expected){
        System.out.println(testName+"begins");
        if (actual == null && expected == null){
            System.out.println("Passed");
        }
        else if (actual != null && expected != null){
             if (actual.compareTo(expected) == 0) {
                 System.out.println("Passed");
             }else{
                 System.out.println("Failed");
             }
        }else{
            System.out.println("Failed");
        }
    }
    void Test1_6(){
        Queue<String> queue = new Queue<String>();
        //特殊情况1. A与B为空时，此时队列为空，出队操作不能执行;
        String result = queue.deleteHead();
        Test("Test4",result,null);

        queue.appendTail("aaa");
        queue.appendTail("bbb");
        queue.appendTail("ccc");

        result = queue.deleteHead();
        Test("Test1",result,"aaa");
        result = queue.deleteHead();
        Test("Test2",result,"bbb");

        //特殊情况2. A为空但是B不为空，此时入队操作，应该把栈B中的元素移回A，再执行A入栈
        queue.appendTail("ddd");
        queue.appendTail("eee");

        result = queue.deleteHead();
        Test("Test3",result,"ccc");
        result = queue.deleteHead();
        Test("Test5",result,"ddd");
        result = queue.deleteHead();
        Test("Test6",result,"eee");








    }
    public void executeTest(){
        Test1_6();
    }
}
