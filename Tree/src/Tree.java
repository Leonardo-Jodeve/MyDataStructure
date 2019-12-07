public class Tree<T>
{
    TreeNode<T> root;

    public Tree()
    {
        this.root=null;
    }

    TreeNode node=null;
    public TreeNode<T> search(T key)
    {
        if(key==null)
            throw new NullPointerException();
        node=null;
        return search(this.root,key);
    }

    public TreeNode<T> search(TreeNode<T> temp,T key)
    {
        if (temp!=null)
        {
            if(temp.data.equals(key))
                return node=temp;
            search(temp.child,key);
            search(temp.sibling,key);
        }
        return node;
    }

    /*public boolean equals(Object obj)
    {
        if(this==obj)
            return true;
        if(!(obj instanceof Tree))
            return false;
        else
        {
            Tree tree=(Tree)obj;
            TreeNode<T> thisnode=this.root, treenode=tree.root;
            return true;
        }
    }

    public boolean equals(TreeNode<T> node1, TreeNode<T> node2)
    {
        if(node1==null&&node2==null)
            return true;
        if(node1==null || node2==null)
            return false;
        if(node1.data.equals(node2.data))
            return true;
        else
            return false;
    }*/
}
