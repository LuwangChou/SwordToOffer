package printlistinreversedorder;
import Utilities.List;
import Utilities.ListNode;
import com.sun.jmx.snmp.SnmpStatusException;

import java.util.Stack;
// 面试题6：从尾到头打印链表
// 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
/**
 * Created by Administrator on 2020/8/29.
 */
public class PrintListInReversedOrder {
    /**
     *
     * @param pHead
     */
    void PrintListReversingly_Iteratetively(ListNode pHead){
        Stack<ListNode> nodes = new Stack<ListNode>();

        ListNode pNode = pHead;
        while(pNode != null){
            nodes.push(pNode);
            System.out.println("\t"+pNode.m_nValue);
            pNode = pNode.m_pNext;
        }

        while(!nodes.isEmpty()){
            pNode = nodes.lastElement();
            System.out.println("\t"+pNode.m_nValue);
            nodes.pop();
        }
    }

    void PrintListReversingly_Recursively(ListNode pHead){
        if(pHead != null){
            if(pHead.m_pNext != null){
                PrintListReversingly_Recursively(pHead.m_pNext);
            }
            System.out.println("\t"+pHead.m_nValue);
        }
    }

    /**
     *
     * @param pNode
     */
    void Test(ListNode pNode){
        List.PrintList(pNode);
        PrintListReversingly_Iteratetively(pNode);
        System.out.println();
        PrintListReversingly_Recursively(pNode);
    }

    // 1->2->3->4->5
    void Test1(){
        System.out.println("Test1 begins.\n");
        ListNode pNode1 = List.CreateListNode(1);
        ListNode pNode2 = List.CreateListNode(5);
        ListNode pNode3 = List.CreateListNode(4);
        ListNode pNode4 = List.CreateListNode(2);
        ListNode pNode5 = List.CreateListNode(3);

        List.ConnectListNodes(pNode1,pNode2);
        List.ConnectListNodes(pNode2,pNode3);
        List.ConnectListNodes(pNode3,pNode4);
        List.ConnectListNodes(pNode4,pNode5);

        Test(pNode1);
        List.DestoryList(pNode1);

    }

    // 只有一个结点的链表: 1
    void Test2(){
        System.out.println("Test2 begins");
        ListNode pNode1 = List.CreateListNode(1);
        Test(pNode1);
        List.DestoryList(pNode1);
    }

    void Test3(){
        System.out.println("Test3 begins");
        Test(null);
    }
    public void executeTest(){
        Test1();
        Test2();
        Test3();
    }

}
