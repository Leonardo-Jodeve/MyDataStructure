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
                    thisfront = thisfront.next;             //因为两个排序链表排序模式相同，所以指针只需要单向移动即可
                    thissucc = thissucc.next;               //即使移动到 this 的尾部，也没有跳出 58 行的 while(rare!=null)
                }
                thisfront.next=rare;
                thisfront=rare;
                point=point.next;                           // point 指针作为 rare 的“备份”，因为 rare 最终会被接到 this 链表上
                rare.next=thissucc;                         // point 会保证待连接的链表 list 不丢失
                rare=point;                                 // rare 指针从“备份”中恢复
            }
        }
    }

}