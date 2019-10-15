import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

public class SinglyList<T>
{
    public Node<T> head;

    public SinglyList()
    {
        this.head=new Node<T>();
    }

    public SinglyList(T[] values)
    {
        this();
        Node<T> rear=this.head;
        for (int i = 0; i < values.length; i++)
        {
            T value = values[i];
            rear.next = new Node<T>(value, null);
            rear = rear.next;
        }
    }

    public SinglyList(SinglyList<T> list)                   //深拷贝构造方法
    {
        this();
        Node<T> rear=this.head;
        for (Node<T> p=list.head.next;  p!=null;  p=p.next)
        {
            rear.next = new Node<T>(p.data, null);
            rear = rear.next;
        }
    }

    public boolean isEmpty()
    {
        return this.head.next==null;
    }

    public String toString()
    {
        String string=this.getClass().getName()+"(";
        for(Node<T> p=this.head.next; p!=null; p=p.next)
        {
            string+=p.data.toString();
            if(p.next!=null)
                string+=",";
        }
        return string+")";
    }

    public T get(int i)
    {
        Node<T> p=this.head.next;
        for(int j=0;p!=null&&j<i;j++)
        {
            p=p.next;
        }
        return (i>=0&&p!=null)?p.data:null;                 //判断i是否为负数，且指针p非空（tail.next==null）
    }

    public void insert(int i,T data)
    {
        Node<T> front=this.head;
        for(int j=0;front!=null&&j<i;j++)
            front=front.next;
        front.next=new Node<T>(data,front.next);
    }

    public void addAll(int i, SinglyList<T> list)
    {
        if(list.head.next==null)
            throw new NullPointerException();
        SinglyList<T> copy= new SinglyList<>(list);          //深拷贝不影响

        Node<T> p=this.head,
                tail=copy.head.next;                         //遍历this，找到插入点
        for(int j=0;j<i&&p!=null;j++)
            p=p.next;

        while (tail.next!=null)                             //遍历list，找尾巴
            tail=tail.next;
        tail.next=p.next;
        p.next=copy.head.next;
    }

    public boolean equals(Object obj)
    {
        if(this==obj)
            return true;
        if(obj instanceof SinglyList<?>)
        {
            SinglyList<T> compare=(SinglyList<T>)obj;
            Node<T> rare1=this.head.next,
                    rare2=compare.head.next;
            while (rare1!=null&&rare2!=null)
            {
                if(rare1.data.equals(rare2.data))
                {
                    rare1=rare1.next;
                    rare2=rare2.next;
                }
                else
                    return false;
            }
            if(rare1!=null||rare2!=null)
                return false;
            return true;
        }
        else
            return false;
    }

    public SinglyList<T> subList(int i, int n)
    {
        if(n<i)
            throw new NumberFormatException();
        SinglyList<T> copy=new SinglyList<>(this);
        Node<T> beginnode=copy.head;
        for(int j=0;j<i;j++)
        {
            beginnode=beginnode.next;
        }
        Node<T> finalnode=beginnode;
        for(int j=0;j<n-i&&finalnode!=null;j++)
        {
            finalnode=finalnode.next;
        }
        copy.head.next=beginnode;
        if(finalnode!=null)
            finalnode.next=null;
        return copy;
    }
}
