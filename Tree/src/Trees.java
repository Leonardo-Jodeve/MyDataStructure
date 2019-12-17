public class Trees
{
    public static Tree<String> create(String[] prelist)
    {
        Tree<String> tree=new Tree<String>();
        if(prelist.length==0)
            return tree;
        tree.root=new TreeNode<String>(prelist[0],1);
        TreeNode<String> temp=tree.root;
        for(int i=1; i<prelist.length; i++)
        {
            int n=0;
            while(n<prelist.length && prelist[i].charAt(n)=='\t')
                n++;
            String string=prelist[i].substring(n);
            if(n==temp.level)
            {
                temp.child=new TreeNode<String>(string, n+1, temp,null,null);
                temp=temp.child;
            }
            else
            {
                while(n<temp.level-1)
                    temp=temp.parent;
                temp.sibling=new TreeNode<String>(string, temp.level, temp.parent, null, null);
                temp=temp.sibling;
            }

        }
        return tree;
    }

    public static void main(String[] args)
    {
        String prelist1[]={"A","\tB","\t\tE","\t\tF","\tC","\t\tG","\t\t\tK","\t\t\tL","\tD","\t\tH","\t\tI","\t\tJ"},
                prelist2[]={"A","\tB","\t\tE","\t\tF","\tC","\t\tG","\t\t\tK","\t\t\tL","\tD","\t\tH","\t\tI","\t\tJ"},
                prelist3[]={"A","\tB","\t\tE","\t\tF","\tC","\t\tG","\t\t\tK","\t\t\tL","\tD","\t\tH","\t\tX","\t\tJ"};

        Tree<String> tree1 = Trees.create(prelist1);
//                tree2 = Trees.create(prelist2),
//                tree3=Trees.create(prelist3);

        System.out.println(tree1.search("X"));
        System.out.println(tree1.search("D"));
        System.out.println(tree1.search("G"));

    /*    System.out.println(tree1.equals(tree2));
        System.out.println(tree1.equals(tree3));*/


    }

}
