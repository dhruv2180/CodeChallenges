public TreeNode traverse(TreeNode root, TreeNode p, TreeNode q){
        
        //if root is equal to p or q , root is lca
        if(root==null || root==p || root==q){
                return root;
        }   
        //otherwise find p or q in left and right subtree
        TreeNode leftNode=traverse(root.left,p,q);
        TreeNode rightNode=traverse(root.right,p,q);
        
        //if p or q both found in left or right subtree, then root is the lca
        if(leftNode!=null && rightNode!=null){
            return root;
        }
        //if p or q found in right child but nothing in left child then other child is also present
        //in the right subtree so lca is right child
        if(leftNode==null && rightNode!=null){
            return rightNode;
        }//if p or q found in left subtree but nothing in right child then other child is also present
        //in the left subtree so lca is left child
        else if(leftNode!=null && rightNode==null){
            return leftNode;
        }
        return null;
        
    }