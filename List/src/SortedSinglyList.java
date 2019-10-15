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
        Node<T> front=this.head, succ=this.head.next;
        int i=-1;
        if(this.sortmode)
            i=1;
        while (succ!=null && data.compareTo(succ.data)==i)           //寻找插入位置
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

    public void addAll(SortedSinglyList<T> list)            //O(n^2)
    {
        Node<T> rare = list.head.next;
        while(rare!=null)
        {
            this.insert(rare.data);
            rare=rare.next;
        }
    }

    public void addAll2(SortedSinglyList<T> list)           //O(n)
    {
        if(this.sortmode!=list.sortmode)
            this.addAll(list);
        else
        {
            int i=-1;
            if(this.sortmode)
                i=1;
            Node<T> thisfront=this.head, thissucc=this.head.next;
            Node<T> rare=list.head.next, point=rare;
            while(rare!=null)
            {
                while (thissucc != null && thissucc.data.compareTo(rare.data) != i)
                {
                    thisfront = thisfront.next;
                    thissucc = thissucc.next;
                }
                thisfront.next=rare;
                thisfront=rare;
                point=point.next;
                rare.next=thissucc;
                rare=point;
            }
        }
    }

}