public class ValidateBst {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> dfs=new ArrayList<Integer>();
        inOrder(root,dfs);
        if(dfs.size()==0){
            return true;
        }
        int last=dfs.get(0);
        for(int i=1;i<dfs.size();i++){
            if(dfs.get(i)<=last){
                return false;
            }
            last=dfs.get(i);
        }
        return true;
    }

    public void inOrder(TreeNode root,ArrayList<Integer> dfs){
        if(root!=null){
            if(root.left!=null){
                inOrder(root.left,dfs);
            }
            dfs.add(root.val);
            if(root.right!=null){
                inOrder(root.right,dfs);
            }
        }
    }
}
