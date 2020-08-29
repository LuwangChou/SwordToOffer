package Utilities;

import com.sun.deploy.security.DeployKeyStore;
import sun.security.krb5.internal.crypto.Des;

/**
 * Created by Administrator on 2020/8/29.
 */
class BinaryTreeNode{
    int m_nValue;
    BinaryTreeNode m_pLeft;
    BinaryTreeNode m_pRight;
}

public class BinaryTree {
    static BinaryTreeNode CreateBinaryTreeNode(int value){
        BinaryTreeNode pNode = new BinaryTreeNode();
        pNode.m_nValue = value;
        pNode.m_pLeft = null;
        pNode.m_pRight = null;
        return pNode;
    }

    static void ConnectTreeNodes(BinaryTreeNode pParent, BinaryTreeNode pLeft, BinaryTreeNode pRight){
        if(pParent != null){
            pParent.m_pLeft = pLeft;
            pParent.m_pRight = pRight;
        }
    }

    static void PrintTreeNode(BinaryTreeNode pNode){
        if( pNode != null){
            System.out.println("value of this node is:"+pNode.m_nValue);
            if (pNode.m_pLeft != null) {
                System.out.println("value of its left child is :" + pNode.m_pLeft.m_nValue);
            } else{
                System.out.println("left child is null");
            }

            if (pNode.m_pRight != null){
                System.out.println("value of its right child is :" + pNode.m_pRight.m_nValue);
            } else{
                System.out.println("right child is null");
            }
        }else {
            System.out.println("this node is null.");
        }
    }

    static void PrintTree(BinaryTreeNode pRoot){
        PrintTreeNode(pRoot);
        if(pRoot != null){
            if(pRoot.m_pLeft != null) {
                PrintTree(pRoot.m_pLeft);
            }
            if(pRoot.m_pRight != null) {
                PrintTree(pRoot.m_pRight);
            }
        }
    }


    static void DestroyTree(BinaryTreeNode pRoot){
        if(pRoot != null){
            BinaryTreeNode pLeft = pRoot.m_pLeft;
            BinaryTreeNode pRight = pRoot.m_pRight;

            pRoot = null;

            DestroyTree(pLeft);
            DestroyTree(pRight);
        }
    }

}
