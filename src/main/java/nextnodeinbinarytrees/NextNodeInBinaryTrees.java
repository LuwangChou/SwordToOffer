package nextnodeinbinarytrees;
// 面试题8：二叉树的下一个结点
// 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
// 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。

import Utilities.BinaryTree;
import constructbinarytree.ConstructBinaryTree;
import sun.security.krb5.internal.crypto.Des;

/**
 * Created by Administrator on 2020/8/29.
 */
public class NextNodeInBinaryTrees {

    BinaryTreeNode GetNext(BinaryTreeNode pNode){
        if (pNode == null){
            return null;
        }
        BinaryTreeNode pNext = null;
        if (pNode.m_pRight != null){
            BinaryTreeNode pRight = pNode.m_pRight;
            while(pRight.m_pLeft != null){
                pRight = pRight.m_pLeft;
            }
            pNext = pRight;
        }
        else if(pNode.m_pParent != null){
            BinaryTreeNode pCurrent = pNode;
            BinaryTreeNode pParent = pNode.m_pParent;
            while(pParent != null && pCurrent == pParent.m_pRight){
                pCurrent = pParent;
                pParent = pParent.m_pParent;
            }

            pNext = pParent;
        }
        return pNext;
    }


    // ==================== 辅助代码用来构建二叉树 ====================
    BinaryTreeNode CreateBinaryTreeNode(int value){
        BinaryTreeNode pNode = new BinaryTreeNode(value);
        pNode.m_nValue = value;
        pNode.m_pLeft = null;
        pNode.m_pRight = null;
        pNode.m_pParent = null;
        return pNode;
    }

    /**
     *
     * @param pParent
     * @param pLeft
     * @param pRight
     */
    void ConnectTreeNodes(BinaryTreeNode pParent, BinaryTreeNode pLeft, BinaryTreeNode pRight){
        if (pParent != null){
            pParent.m_pLeft = pLeft;
            pParent.m_pRight = pRight;
            if (pLeft != null){
                pLeft.m_pParent = pParent;
            }
            if (pRight != null){
                pRight.m_pParent = pParent;
            }
        }
    }

    /**
     *
     * @param pNode
     */
    void PrintTreeNode(BinaryTreeNode pNode){
        if (pNode != null){
            System.out.println("value of this node is :"+pNode.m_nValue);
            if (pNode.m_pLeft != null) {
                System.out.println("value of  its left child node is :" + pNode.m_pLeft.m_nValue);
            }else{
                System.out.println("value of  its left child is null.");
            }
            if (pNode.m_pRight != null){
                System.out.println("value of its right child node is :"+pNode.m_pRight.m_nValue);
            }
            else{
                System.out.println("value of its right child node is null.");
            }
        }else{
            System.out.println("this node is null.");
        }
    }


    void DestroyTree(BinaryTreeNode pRoot){
        if (pRoot != null){
            BinaryTreeNode pLeft = pRoot.m_pLeft;
            BinaryTreeNode pRight = pRoot.m_pRight;

            pRoot = null;
            DestroyTree(pLeft);
            DestroyTree(pRight);
        }
    }
    //测试代码
    void Test(String testName, BinaryTreeNode pNode, BinaryTreeNode expected){
        System.out.println(testName+"begins");
        BinaryTreeNode pNext = GetNext(pNode);
        if (pNext == null && expected == null){
            System.out.println("Passed");
        }
        else if (pNext == null && expected != null){
            System.out.println("Failed");
        }
        else if (pNext.m_nValue == expected.m_nValue){
            System.out.println("Passed");
        }
        else {
            System.out.println("Failed");
        }
    }
//            8
//        6      10
//       5 7    9  11
    void Test1_7(){
        BinaryTreeNode pNode5 = CreateBinaryTreeNode(5);
        BinaryTreeNode pNode6 = CreateBinaryTreeNode(6);
        BinaryTreeNode pNode7 = CreateBinaryTreeNode(7);
        BinaryTreeNode pNode8 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNode9 = CreateBinaryTreeNode(9);
        BinaryTreeNode pNode10 = CreateBinaryTreeNode(10);
        BinaryTreeNode pNode11 = CreateBinaryTreeNode(11);

        ConnectTreeNodes(pNode8,pNode6,pNode10);
        ConnectTreeNodes(pNode6,pNode5,pNode7);
        ConnectTreeNodes(pNode10,pNode9,pNode11);
        Test("Test1",pNode5,pNode6);
        Test("Test2",pNode6,pNode7);
        Test("Test3",pNode7,pNode8);
        Test("Test4",pNode8,pNode9);
        Test("Test5",pNode9,pNode10);
        Test("Test6",pNode10,pNode11);
        Test("Test7",pNode11,null);
        DestroyTree(pNode8);
    }
//            5
//          4
//        3
//      2
    void Test8_11(){
        BinaryTreeNode pNode2 = CreateBinaryTreeNode(2);
        BinaryTreeNode pNode3 = CreateBinaryTreeNode(3);
        BinaryTreeNode pNode4 = CreateBinaryTreeNode(4);
        BinaryTreeNode pNode5 = CreateBinaryTreeNode(5);

        ConnectTreeNodes(pNode5,pNode4,null);
        ConnectTreeNodes(pNode4,pNode3,null);
        ConnectTreeNodes(pNode3,pNode2,null);
        Test("Test8",pNode2,pNode3);
        Test("Test9",pNode3,pNode4);
        Test("Test10",pNode4,pNode5);
        Test("Test11",pNode5,null);
        DestroyTree(pNode5);

    }

    public void executeTest(){
        Test1_7();
        Test8_11();
    }
}
