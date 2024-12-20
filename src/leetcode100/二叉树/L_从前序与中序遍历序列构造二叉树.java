package leetcode100.二叉树;


import java.util.Arrays;
import java.util.List;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 输出: [3,9,20,null,null,15,7]
 */
public class L_从前序与中序遍历序列构造二叉树 {

    public static void main(String[] args) {
        L_从前序与中序遍历序列构造二叉树 code = new L_从前序与中序遍历序列构造二叉树();
        TreeNode root = code.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9,3,15,20,7});

        List<Integer> result = TreeNode.levelOrder(root);
        System.out.println(result);
    }


    /**
     * 找到根节点，递归处理左右区间（通过先序找到中间节点，再通过中序找到左右区间）
     * @param preorder 先序
     * @param inorder 中序
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        if (preorder.length == 1){
            return root;
        }
        // 查找中间节点在中序数组中的位置
        int index = 0;
        for (index = 0;index<inorder.length;index++){
            if (inorder[index]==rootVal){
                break;
            }
        }
        // 切割中序数组
        int[] leftInorder = Arrays.copyOfRange(inorder,0,index); // 左中序
        int[] rightInorder = Arrays.copyOfRange(inorder,index + 1,inorder.length); // 右中序
        // 切割先序数组
        int[] leftPreorder = Arrays.copyOfRange(preorder,1,leftInorder.length + 1); // 左先序
        int[] rightPreorder = Arrays.copyOfRange(preorder,leftInorder.length + 1,preorder.length); // 右先序

        root.left = buildTree(leftPreorder,leftInorder);
        root.right = buildTree(rightPreorder,rightInorder);
        return root;
    }
}
