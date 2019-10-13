public class SortedSinglyList<T extends Comparable<? super T>> extends SinglyList<T>
{
    boolean sortmode;
    public SortedSinglyList()
    {
        super();
    }
    public Node<T> insert(T data)
    {
        Node<T> node=new Node<T>(data,null);
        Node<T> front=this.head,succ=this.head.next;
        if(this.sortmode)
            while (succ!=null && data.compareTo(succ.data)>0)           //寻找插入位置
        {
            front=succ;
            succ=succ.next;
        }
        front.next = new Node<T>(data,succ);

        return node;
    }

    public SortedSinglyList(SinglyList<T> list, boolean sortmode)
    {
        Node<T> rare=list.head.next;
        this.sortmode=sortmode;
        while (rare!=null)
        {
            this.insert(rare.data);
            rare=rare.next;
        }
    }
}
