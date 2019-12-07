public class TreeNode<T>
{
    public T data;
    public TreeNode<T> parent, child, sibling;
    public int level;

    public TreeNode(T data,int level,TreeNode<T> parent,TreeNode<T> child,TreeNode<T> sibling)
    {
        this.data = data;
        this.level = level;
        this.parent = parent;
        this.child = child;
        this.sibling = sibling;
    }

    public TreeNode(T data, int level)
    {
        this(data, level, null, null, null);
    }
    public String toString()
    {
        return this.data.toString();
    }

    public boolean isLeaf()
    {
        return this.child==null;
    }

}
