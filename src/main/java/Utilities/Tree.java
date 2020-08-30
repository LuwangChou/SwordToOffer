package Utilities;

import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

/**
 * Created by Administrator on 2020/8/29.
 */

public class Tree {

    static TreeNode CreateTreeNode(int value){
        TreeNode pNode = new TreeNode();
        pNode.m_nValue = value;
        return pNode;
    }
    static void PrintTreeNode(TreeNode pNode){
        if (pNode != null){
            System.out.println("value of this node is : "+pNode.m_nValue);
            System.out.println("its children is as the following :");
            Iterator<TreeNode> iterator = pNode.m_vChildren.iterator();
            while (iterator.hasNext()){
                System.out.println("child node value"+iterator.next().m_nValue);
            }
        }else {
            System.out.println("this node is null");
        }
    }


    public static void PrintTree(TreeNode pRoot){
        PrintTreeNode(pRoot);
        if (pRoot != null){
            Iterator<TreeNode> iterator = pRoot.m_vChildren.iterator();
            while (iterator.hasNext()){
                PrintTreeNode(iterator.next());
            }
            pRoot = null;
        }
    }


}
