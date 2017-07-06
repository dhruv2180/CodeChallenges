public List<List<Integer>> levelOrder(TreeNode root) {

     List<List<Integer>> toReturn =new ArrayList<List<Integer>>();
     Queue<TreeNode> bfsQueue=new LinkedList<TreeNode>();
     HashMap<TreeNode,Integer> level=new HashMap<TreeNode,Integer>();

    if(root!=null){
        bfsQueue.add(root);
        level.put(root,0);
    }
    List<Integer> temp;
    temp=new ArrayList<Integer>();
    int currlevel;

    while(bfsQueue.peek()!=null){

      root=bfsQueue.remove();
      currlevel=level.get(root);

     //System.out.println(root.val+" "+currlevel);
     if(currlevel<toReturn.size()){
         temp=toReturn.get(currlevel);
         temp.add(root.val);
         toReturn.set(currlevel,temp);
     }else if(currlevel>=toReturn.size()){
         temp=new ArrayList<Integer>();
         temp.add(root.val);
         toReturn.add(currlevel,temp);
     }
      if(root.left!=null){
          bfsQueue.add(root.left);
          level.put(root.left,currlevel+1);
      }
      if(root.right!=null){
          bfsQueue.add(root.right);
          level.put(root.right,currlevel+1);
      }
    }
      return toReturn;
}
