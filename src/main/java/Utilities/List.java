package Utilities;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import Utilities.ListNode;
/**
 * Created by Administrator on 2020/8/29.
 */


public class List {
    public static ListNode CreateListNode(int value){
        ListNode pNode = new ListNode();
        pNode.m_nValue = value;
        pNode.m_pNext = null;
        return pNode;
    }

    public static void ConnectListNodes(ListNode pCurrent, ListNode pNext){
        if (pCurrent == null){
            System.out.println("Error to connect two nodes");
            return;
        }
        pCurrent.m_pNext = pNext;
    }

    public static void PrintListNode(ListNode pNode){
        if(pNode == null){
            System.out.println("The node is null");
        }
        else{
            System.out.println("The key in node is "+ pNode.m_nValue);
        }
    }
    public static void PrintList(ListNode pHead){
        System.out.println("PrintList starts");

        ListNode pNode = pHead;
        while(pNode != null){
            System.out.println(pNode.m_nValue);
            pNode = pNode.m_pNext;
        }
        System.out.println("PrintList ends");
    }

    public static void DestoryList(ListNode pHead){
        ListNode pNode = pHead;
        ListNode tempNode =  pHead;

        while(pNode != null){
            tempNode = tempNode.m_pNext;
            pNode = null;
            pNode = tempNode;
        }
    }

    public static void AddToTail(ListNode pHead, int value){
        ListNode pNew = new ListNode();
        pNew.m_nValue = value;
        pNew.m_pNext = null;

        if(pHead != null){
            pHead = pNew;
        }
        else {
            ListNode pNode = pHead;
            while (pNode.m_pNext != null){
                pNode = pNode.m_pNext;
            }
            pNode.m_pNext = pNew;
        }
    }

    public static void RemoveNode(ListNode pHead, int value){

        if(pHead == null){
            return;
        }

        ListNode  pToBeDeleted = null;
        if(pHead.m_nValue == value){
            pToBeDeleted = pHead;
        }else{
            ListNode pNode = pHead;
            while ((pNode.m_pNext != null) && (pNode.m_pNext.m_nValue != value)){
                pNode = pNode.m_pNext;
            }

            if ((pNode.m_pNext != null) && (pNode.m_pNext.m_nValue == value)){
                pToBeDeleted = pNode.m_pNext;
                pNode.m_pNext = pNode.m_pNext.m_pNext;
            }
        }

        if (pToBeDeleted != null){
            pToBeDeleted = null;
        }
    }



}




































