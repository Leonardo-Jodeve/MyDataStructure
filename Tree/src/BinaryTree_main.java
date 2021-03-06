public class BinaryTree_main
{

    public static void main(String[] args)
    {
        String[] str1={"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"},
            str2={"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"},
            str3={"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","X"},
            str4={"A","B","D",null,"G",null,null,"X","C","E",null,null,"F","H","I","J"},
        str5={},
        str6={};
        BinaryTree<String> tree1=new BinaryTree<String>(str1),
                tree2=new BinaryTree<String>(str2),
                tree3=new BinaryTree<String>(str3),
                tree4=new BinaryTree<String>(str4),
                tree5=new BinaryTree<String>(str5),
                tree6=new BinaryTree<String>(str6);
        System.out.println(tree1.equals(tree2));
        System.out.println(tree1.equals(tree3));
        System.out.println(tree1.equals(tree4));
        System.out.println(tree5.equals(tree6));
    }
}
