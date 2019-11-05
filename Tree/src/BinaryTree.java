public class BinaryTree<T>
{
    public BinaryNode<T> root;

    public BinaryTree()
    {
        this.root=null;
    }

    public boolean isEmpty()
    {
        return this.root==null;
    }

    public BinaryNode<T> insert(BinaryNode<T> parent, T data, boolean leftchild)
    {
        if(data==null)
            return null;
        if(leftchild)
            return parent.left=new BinaryNode<T>(data, parent.left, null);
        else
            return parent.right=new BinaryNode<T>(data, null, parent.right);
    }

    public BinaryNode<T> insert(T data)
    {
        return this.insert(this.root, data, true);
    }

    public void remove(BinaryNode<T> parent, boolean leftchild)
    {
        if(leftchild)
            parent.left=null;
        else
            parent.right=null;
    }

    public void clear()
    {
        this.root=null;
    }

    public void preorder(BinaryNode<T> node)
    {
        if (node!=null)
        {
            System.out.println(node.data.toString()+" ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void preorder()
    {
        preorder(this.root);
        System.out.println();
    }

    private String toString(BinaryNode<T> node)
    {
        if (node==null)
            return "∧";
        return node.data.toString()+" " + toString(node.left) + toString(node.right);
    }

    public String toString()
    {
        return toString(this.root);
    }

    public void inorder(BinaryNode<T> node)
    {
        if (node!=null)
        {
            inorder(node.left);
            System.out.println(node.data.toString()+" ");
            inorder(node.right);
        }
    }

    public void inorder()
    {
        inorder(this.root);
        System.out.println();
    }

    public void postorder(BinaryNode<T> node)
    {
        if (node!=null)
        {
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.data.toString()+" ");
        }
    }

    public void postorder()
    {
        postorder(this.root);
        System.out.println();
    }
}
