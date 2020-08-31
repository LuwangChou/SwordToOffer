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
     * @return
     */
    ListNode PrintListReversingly_Iteratetively(ListNode pHead){
        Stack<ListNode> nodes = new Stack<ListNode>();

        ListNode pNode = pHead;
        while(pNode != null){
            nodes.push(pNode);
            System.out.println("\t"+pNode.m_nValue);
            pNode = pNode.m_pNext;
        }
        ListNode preNode = null;
        ListNode pResult = null;
        ListNode temp = null;
        while(!nodes.isEmpty()){
            pNode = nodes.lastElement();
            nodes.pop();
            System.out.println("\t"+pNode.m_nValue);
            temp = new ListNode();
            temp.m_nValue = pNode.m_nValue;
            if (preNode != null){
                preNode.m_pNext = temp;
            }else {
                pResult = temp;
            }
            preNode = temp;
        }
        return pResult;
    }

    ListNode PrintListReversingly_Iteratetively2(ListNode pHead) {
        ListNode head = pHead;
        if(head==null) {
            return null;
        }
        //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
        ListNode pre = null;
        ListNode next = null;
        //当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
        //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
        //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
        //所以需要用到pre和next两个节点
        //1->2->3->4->5
        //1<-2<-3 4->5
        while(head!=null){
            //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
            //如此就可以做到反转链表的效果
            //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
            next = head.m_pNext;
            //保存完next，就可以让head从指向next变成指向pre了，代码如下
            head.m_pNext = pre;
            //head指向pre后，就继续依次反转下一个节点
            //让pre，head，next依次向后移动一个节点，继续下一次的指针反转
            pre = head;
            head = next;
        }
        //如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
        //直接输出pre就是我们想要得到的反转后的链表
        return pre;
    }
    ListNode PrintListReversingly_Recursively(ListNode pHead){
        if(pHead == null || pHead.m_pNext == null) {
            return pHead;
        }
        ListNode preNode = null;
        preNode = PrintListReversingly_Recursively(pHead.m_pNext);
        pHead.m_pNext.m_pNext = pHead;
        pHead.m_pNext = null;
        return preNode;
    }

    /**
     *
     * @param pNode
     */
    void Test(ListNode pNode){
        List.PrintList(pNode);
        ListNode result = null;
        result = PrintListReversingly_Iteratetively(pNode);
        List.PrintList(result);

        System.out.println();
        result = PrintListReversingly_Iteratetively2(pNode);
        List.PrintList(result);
        System.out.println();
        ListNode recurResult = PrintListReversingly_Recursively(pNode);
        List.PrintList(recurResult);
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
