import com.sun.deploy.security.SelectableSecurityManager;

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

    public boolean equals(Object obj)
    {
        BinaryTree<T> tree;
        BinaryNode<T> thisnode, treenode;
        LinkedStack<BinaryNode<T>> thisstack=new LinkedStack<BinaryNode<T>>(),
                treestack=new LinkedStack<BinaryNode<T>>();
        boolean result=true;
        if(this==obj)
            return true;
        if(!(obj instanceof BinaryTree))
            return false;
        else
        {
            tree=(BinaryTree<T>)obj;
            thisnode=this.root;
            treenode=tree.root;
        }

        try
        {
            while((thisnode!=null || !thisstack.isEmpty()) || (treenode!=null || !treestack.isEmpty()))
            {
                if(thisnode!=null || treenode!=null)
                {
                    result = equals(thisnode, treenode);
                    if (!result)
                        return result;
                    thisstack.push(thisnode);
                    treestack.push(treenode);
                    thisnode = thisnode.left;
                    treenode = treenode.left;
                }
                else
                {
                    thisnode=thisstack.pop();
                    thisnode=thisnode.right;
                    treenode=treestack.pop();
                    treenode=treenode.right;
                }
            }
        }
        catch (NullPointerException ex)
        {
            return false;
        }
        return result;
    }

    public BinaryTree(BinaryTree<T> bittree)
    {
        this();
    }

    public boolean equals(BinaryNode<T> node1, BinaryNode<T> node2)
    {
        if(node1==node2)
            return true;
        if((node1==null && node2!=null)||(node1!=null && node2==null))
            return false;
        if(node1!=null && node2!=null)
            return node1.data.equals(node2.data);
        return true;
    }

    private int i=0;
    public BinaryNode<T> create(T[] prelist)
    {
        BinaryNode<T> node=null;
        if(i<prelist.length)
        {
            T data=prelist[i];
            i++;
            if(data!=null)
            {
                node=new BinaryNode<T>(data);
                node.left=create(prelist);
                node.right=create(prelist);
            }
        }
        return node;
    }

    public BinaryTree(T[] prelist)
    {
        this.root=create(prelist);
    }
}
