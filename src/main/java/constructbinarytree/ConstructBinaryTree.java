package constructbinarytree;
// 面试题7：重建二叉树
// 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输
// 入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,
// 2, 4, 7, 3, 5, 6, 8}和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}，则重建出
// 图2.6所示的二叉树并输出它的头结点。
import java.util.Arrays;

import Utilities.Array;
import Utilities.BinaryTree;
import Utilities.BinaryTreeNode;

/**
 * Created by Administrator on 2020/8/29.
 */
public class ConstructBinaryTree {

    BinaryTreeNode Construct(int[] preorder,int[] inorder, int length){
        if (preorder == null || inorder == null || length <= 0){
            return null;
        }
        return ConstructCore(preorder,inorder,length);
    }


    //思路是按照前序找出根节点，然后通过根节点分成左半边和右半边

    /**
     *
     * @param partPreorder
     * @param partInorder
     * @param length
     * @return
     */
    BinaryTreeNode ConstructCore(int[] partPreorder, int[] partInorder,int length){
        if (partPreorder == null || partInorder == null || length <= 0){
            return null;
        }
        //前序遍历序列的第一个数字是根节点的值
        int rootValue = partPreorder[0];
        BinaryTreeNode root = new BinaryTreeNode();
        root.m_nValue = rootValue;
        root.m_pLeft = null;
        root.m_pRight = null;

        if (length==1){
            return root;
        }

        int []leftChildPreorder;
        int []rightChildPreorder;
        int []leftChildInorder;
        int []rightChildInorder;
        // 在中序遍历中找到根结点的值
        int rootIndex = -1;
        for (int i = 0; i < length; i++) {
            int temp = partInorder[i];
            if(temp == rootValue){
                rootIndex = i;
                break;
            }
        }
        if(rootIndex > -1 ){
            int rest = length - rootIndex -1;
            int leftIndex = 0;
            int rightIndex = 0;
            leftChildPreorder = new int[rootIndex] ;
            rightChildPreorder = new int[rest];
            leftChildInorder = new int[rootIndex];
            rightChildInorder = new int[rest];
            for (int j = 1; j < length; j++) {
                if(j < rootIndex+1){
                    leftChildPreorder[leftIndex++] = partPreorder[j];
                }
                else if(j >= rootIndex+1){
                    rightChildPreorder[rightIndex++] = partPreorder[j];
                }
            }
            leftIndex = 0;
            rightIndex = 0;
            for (int k = 0; k < length; k++) {
                if(k < rootIndex){
                    leftChildInorder[leftIndex++] = partInorder[k];
                }
                else if(k > rootIndex){
                    rightChildInorder[rightIndex++] = partInorder[k];
                }
            }
            
        }
        else{
            System.out.println("Invalid Input.");
            return null;
        }
        int leftChildLength = leftChildPreorder.length;
        int rightChildLength = rightChildPreorder.length;
        //构建左子树
        root.m_pLeft = ConstructCore(leftChildPreorder, leftChildInorder,leftChildLength);
        //构建右子树
        root.m_pRight = ConstructCore(rightChildPreorder, rightChildInorder,rightChildLength);

        return root;
    }

    void Test(String testName, int[] preorder, int[] inorder,int length){
        System.out.println(testName+"begins.");
        System.out.println("The preorder sequence is:");
        for (int i = 0; i < length; i++) {
            System.out.println("\t"+preorder[i]);
        }
        System.out.println("The inorder sequence is:");
        for (int i = 0; i < length; i++) {
            System.out.println("\t"+inorder[i]);
        }

        try{
            BinaryTreeNode root = Construct(preorder, inorder,length);
            BinaryTree.PrintTree(root);
            BinaryTree.DestroyTree(root);

        }catch (Exception e){
            System.out.println("Invalid Input");
        }
    }

    // 普通二叉树
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
    void Test1(){
        int length = 8;
        int []preorder ={1, 2, 4, 7, 3, 5, 6, 8 };
        int []inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        Test("Test1",preorder,inorder,length);
    }
    // 所有结点都没有右子结点
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    void Test2(){
        int length = 5;
        int[] preorder = { 1,2,3,4,5};
        int[] inorder = {5,4,3,2,1};
        Test("Test2",preorder,inorder,length);
    }

    // 所有结点都没有左子结点
//            1
//             \
//              2
//               \
//                3
//                 \
//                  4
//                   \
//                    5
    void Test3(){
        int length = 5;
        int[] preorder = { 1, 2, 3, 4, 5};
        int[] inorder = { 1, 2, 3 ,4 , 5};
        Test("Test3",preorder,inorder,length);
    }
    // 树中只有一个结点
    void Test4(){
        int length = 1;
        int[] preorder = {1};
        int[] inorder = {1};
        Test("Test4",preorder,inorder, length);
    }
    // 完全二叉树
//              1
//           /     \
//          2       3
//         / \     / \
//        4   5   6   7
    void Test5(){
        int length = 7;
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3 ,7};
        Test("Test5",preorder,inorder,length);
    }
    // 输入空指针
    void Test6(){
        Test("Test6",null,null,0);
    }
    // 输入的两个序列不匹配
    void Test7(){
        int length = 7;
        int[] preorder = { 1, 2, 4, 5, 3, 6, 7};
        int[] inorder = { 4, 2, 8, 1, 6, 3, 7};
        Test("Test7: for umatched input",preorder,inorder,length);
    }

    public void executeTest(){
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();
        Test7();
    }

}


