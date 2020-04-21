//Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
class Solution {
  //递归
 public boolean isSymmetricTree(TreeNode root){
    if(root==null)return true;
    return checkSymmetricTree(root.left,root.right);
 }
 
 public boolean checkSymmetricTree(TreeNode nodeL, TreeNode R){
    if(nodeL==null&&nodeR==null)return true;
    if(nodeL==null||nodeR==null)return false;
    
    return (nodeL.val==nodeR.val)&&(checkSymmetricTree(nodeL.left,nodeR.right))&&(checkSymmetricTree(nodeL.right,nodeR.left));
 }
 
 //迭代
 public boolean isSymmetricTree(TreeNode root){
    if(root==null)return true;
    java.util.Stack<TreeNode> s= new java.util.Stack<TreeNode>();
    s.push(root.left);
    s.push(root.right);
    while(!s.empty()){
    
      TreeNode nodeR=s.pop();
      TreeNode nodeL=s.pop();
      
      if(nodeR==null||nodeL==null)return false;
      if(nodeR.val!=nodeL.val)return false;
      if(nodeR==null&&nodeL==null)continue;
      
      s.push(nodeR.right);
      s.push(nodeL.left);
      s.push(nodeR.left);
      s.push(nodeL.right);
      
    }
    
 }
 
 
}
