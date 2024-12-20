package leetcode100.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
     public static TreeNode createBT(Integer[] arr){
         if(arr.length == 0){
             return null;
         }
         TreeNode root = new TreeNode(arr[0]);
         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);

         boolean isLeft = true;//是左子树
         for(int i = 1; i< arr.length; i++){
             TreeNode node = queue.peek(); //peek()获取第一个元素，不移除
             if(isLeft){
                 if(arr[i] != null){
                     node.left = new TreeNode(arr[i]);
                     queue.offer(node.left); //offer(E e) 在队列尾部添加一个元素，并返回是否成功
                 }
                 isLeft = false;
             } else {
                 if(arr[i] != null){
                     node.right = new TreeNode(arr[i]);
                     queue.offer(node.right);
                 }
                 //右节点加入队列尾部，删除第一个元素，保证队列里保存的是根节点
                 queue.poll(); //poll()  删除队列中第一个元素，并返回该元素的值,
                 isLeft = true;
             }
         }
         return root;
     }

    // 层次遍历二叉树，返回结果数组
    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result; // 如果根节点为空，直接返回空列表
        }

        Queue<TreeNode> queue = new LinkedList<>(); // 创建队列
        queue.offer(root); // 将根节点放入队列

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll(); // 从队列中取出节点
            result.add(currentNode.val); // 将节点值添加到结果中
            // 将当前节点的左子节点和右子节点加入队列
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }

        return result; // 返回层次遍历的结果
    }
 }
