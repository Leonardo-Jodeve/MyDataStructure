public class SeqList<T>
{
    protected Object[] element;
    protected int n;

    public SeqList(int length)
    {
        this.element = new Object[length];
        this.n = 0;
    }
    public SeqList()
    {
        this(64);
    }

    public SeqList(T[] values)
    {
        this(values.length);
        for (int i=0; i<values.length; i++)
            this.element[i] = values[i];
        this.n = element.length;
    }

    public boolean isEmpty()
    {
        return this.n==0;
    }

    public int size()
    {
        return this.n;
    }

    public T get(int i)
    {
        if (i>=0 && i<this.n)
            return (T)this.element[i];
        return null;
    }

    public void set(int i, T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");
        if (i>=0 && i<this.n)
            this.element[i] = x;
        else throw new java.lang.IndexOutOfBoundsException(i+"");
    }

    public String toString()
    {
        String str=this.getClass().getName()+"(";
        if (this.n>0)
            str += this.element[0].toString();
        for (int i=1; i<this.n; i++)
            str += ", "+this.element[i].toString();
        return str+") ";
    }

    public int insert(int i, T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");
        if (i<0)       i=0;
        if (i>this.n)  i=this.n;
        Object[] source = this.element;
        if (this.n==element.length)
        {
            this.element = new Object[source.length*2];
            for (int j=0; j<i; j++)
                this.element[j] = source[j];
        }
        for (int j=this.n-1; j>=i; j--)
            this.element[j+1] = source[j];
        this.element[i] = x;
        this.n++;
        return i;
    }
    public int insert(T x)
    {
        return this.insert(this.n, x);
    }


    public T remove(int i)
    {
        if (this.n>0 && i>=0 && i<this.n)
        {
            T old = (T)this.element[i];
            for (int j=i; j<this.n-1; j++)
                this.element[j] = this.element[j+1];
            this.element[this.n-1]=null;
            this.n--;
            return old;
        }
        return null;
    }
    public void clear()                                    //删除线性表所有元素
    {
        this.n=0;                                          //设置长度为0，未释放数组空间
    }

    public int search(T key)
    {
        for (int i=0; i<this.n; i++)
        {
            if (key.equals(this.element[i]))
                return i;
        }
        return -1;
    }

    public boolean contains(T key)
    {
        return this.search(key)!=-1;
    }

    public T remove(T key)
    {
        return this.remove(this.search(key));
    }

    public SeqList(SeqList<? extends T> list)
    {
        this.n = list.n;
        this.element = new Object[list.element.length];    //申请一个数组
        for (int i=0; i<list.n; i++)
            this.element[i] = list.element[i];
    }
    //第5版
/*    public SeqList(SeqList<? extends T> list)            //拷贝构造方法，深拷贝，复制list
    {
        this(list.element.length);                         //构造空顺序表
        for (int i=0; i<list.n; i++)                       //复制list所有元素，O(n)
            this.insert((T)list.element[i]);               //尾插入，this.n++
//也可        this.addAll(list);
//          this.element[i] = new T(list.element[i]);    //语法错，因为Java没有提供默认拷贝构造方法
//      this.element[i] = new Object(list.element[i]);    //语法错，因为Object没有提供拷贝构造方法，且构造方法不能继承 
    }*/

    public boolean equals(Object obj)
    {
        if (this==obj)
            return true;
        if (obj instanceof SeqList<?>)
        {
            SeqList<T> list = (SeqList<T>)obj;
            if (this.n==list.n)
            {
                for (int i=0; i<this.n; i++)
                    if (!(this.get(i).equals(list.get(i))))
                        return false;
                return true;
            }
        }
        return false;
    }

    public boolean isDifferent()
    {
        for (int i=0; i<this.n; i++)
            for (int j=0; j<i; j++)
                if (this.element[j].equals(this.element[i]))
                    return false;
        return true;
    }

    public void removeAll(T key)
    {
        int i=0;
        while (i<this.n)
            if (key.equals(this.element[i]))
                this.remove(i);
            else i++;
    }

    public void replaceFirst(T key, T x)
    {
        if (key!=null && x!=null)
        {
            int i = this.search(key);
            if (i!=-1)
                this.element[i] = x;
        }
    }
    public void replaceAll(T key, T x)
    {
        if (key!=null && x!=null)
            for (int i=0; i<this.n; i++)
                if (key.equals(this.element[i]))
                    this.element[i] = x;
    }

    public int searchLast(T key)
    {
        for (int i=this.n-1; i>=0; i--)
            if (key.equals(this.element[i]))
                return i;
        return -1;
    }

    public <T extends java.lang.Comparable<? super T>> boolean isSorted()
    {
        for (int i=0; i<this.n; i++)
            if (((T)this.element[i]).compareTo((T)this.element[i+1])>0)
                return false;
        return true;
    }

    public void addAll(SeqList<? extends T> list)
    {
        for (int i=0; i<list.n; i++)
            this.insert(list.get(i));               //运行时多态，顺序表尾插入；排序顺序表按值插入
        //this.insert((T)list.element[i]);               //运行时多态，顺序表尾插入；排序顺序表按值插入
    }
//如果  public void addAll(SeqList<T> list)          //则不接受T的子类
//如果  public void addAll(SeqList<?> list)          //则调用this.insert(x)，编译错
//如果  public void insert(SeqList<T> list)          //重载，调用时，当参数为null时，编译错，无法识别重载方法中的哪一个


/*  //子类不支持
    public void insert(int i,SeqList<T> list)             //将list所有元素添加到当前顺序表最后//顺序表连接，首尾相接
    {
        for (int j=0; j<list.n; j++) 
            this.insert(i,list.get(j));                    //运行时多态，顺序表尾插入；排序顺序表按值插入
    }*/

    //【思考题2-4】习题解答
    public SeqList<T> union(SeqList<? extends T> list)     //返回在this顺序表之后连接list的顺序表，不改变this和list
    {
        SeqList<T> result = new SeqList<T>(this);          //深拷贝this，无法创建子类实例   //反射?
        result.addAll(list);                               //顺序表合并连接，尾插入
        return result;                                     //只能返回SeqList<T>对象

//不行        return new SeqList<T>(this).addAll(list);
    }
    //9.5.1 子类mergeAll合并、归并，不用，不声明

    boolean containsAll(SeqList<? extends T> list)  //判断是否包含set的所有元素（是否子集）
    {
        for (int i=0; i<list.n; i++)
            if (!this.contains(list.get(i)))
                return false;
        return true;
    }
//不能    boolean containsAll(SeqList<?> list)

    boolean removeAll(SeqList<? extends T> list)           //删除也包含在set的元素，集合差
    {
        T old=null;
        for (int i=0; i<list.n; i++)
            old=this.remove(list.get(i));
        return old!=null;
    }
    boolean retainAll(SeqList<? extends T> list)           //仅保留那些也包含在set的元素，集合差
    {
        return false;
    }

    //返回从begin～end元素组成的子表。意为返回T的某个子类
//    SeqList<? extends T> subList(int begin, int end)   //不需要该语法 
    SeqList<T> subList(int begin, int end)             //返回从begin～end组成的子表。含义与上同   
    {
        SeqList<T> list = new SeqList<T>();
        for (int i=begin; i<end; i++)
            list.insert(this.get(i));
        return list;
    }


    //第10章迭代器
    //10.2.1   提供迭代器对象
    //1.  顺序表类提供迭代器

    public java.util.Iterator<T>  iterator()               //返回Java迭代器对象
    {   return new SeqIterator();
    }
    private class SeqIterator  implements java.util.Iterator<T>//私有内部类，实现迭代器接口
    {
        int index=-1, succ=0;                              //当前元素和后继元素序号
        public boolean hasNext()                           //若有后继元素，返回true
        {
            return this.succ<SeqList.this.n;               //SeqList.this.n是外部类当前实例的成员变量
        }
        public T next()                                    //返回后继元素，若没有后继元素，返回null
        {
            T value = SeqList.this.get(this.succ);         //调用外部类SeqList当前实例的成员方法
            if (value!=null)
            {   this.index = this.succ++;
                return value;
            }
            throw new java.util.NoSuchElementException();  //抛出无此元素异常
        }
        public void remove()                               //删除迭代器对象表示的集合当前元素
        {
            if (this.index>=0 && this.index<SeqList.this.n)
            {   SeqList.this.remove(this.index);           //调用外部类SeqList当前实例的成员方法
                //删除第index个元素，长度SeqList.this.n-1
                if (this.succ>0)
                    this.succ--;
                this.index=-1;                             //设置不能连续删除
            }
            else throw new java.lang.IllegalStateException(); //抛出无效状态异常
        }
    }//SeqIterator内部类结束


    //【思考题10-3】顺序表类提供列表迭代器。
    public java.util.ListIterator<T> listIterator()        //返回Java列表迭代器对象
    {
        return new SeqListIterator(0);
    }
    public java.util.ListIterator<T> listIterator(final int index) //返回Java列表迭代器对象
    {
        if (index>=0 && index<this.n)
            return new SeqListIterator(index);
        else throw new IndexOutOfBoundsException("Index: "+index);
    }

    //私有内部类，继承实现迭代器接口的SeqIterator内部类，实现列表迭代器接口
    private class SeqListIterator extends SeqIterator implements java.util.ListIterator<T>
    {
        public SeqListIterator(int index)
        {
            this.succ=index;
        }
        public boolean hasPrevious()                       //若有前驱元素，返回true
        {
            return this.succ!=0;
        }

        public T previous()                                //返回前驱元素
        {
            T value = SeqList.this.get(this.succ-1);
            if (value!=null)
            {
                this.index = this.succ--;
                return value;
            }
            throw new java.util.NoSuchElementException();  //抛出无此元素异常
        }

        public int nextIndex()                             //返回后继元素序号
        {
            return this.succ;
        }
        public int previousIndex()                         //返回前驱元素序号
        {
            return this.succ-1;
        }

        public void set(T x)                               //将集合当前元素替换为x
        {
            if (this.index>=0 && this.index<SeqList.this.n)
                SeqList.this.set(this.index, x);           //调用外部类当前实例的成员方法
            else throw new java.lang.IllegalStateException(); //抛出无效状态异常
        }
        public void add(T x)                               //增加元素x
        {
            SeqList.this.insert(this.succ, x);             //调用外部类当前实例的成员方法
            this.succ++;                                   //插入元素为当前元素
        }
    }//SeqListIterator内部类结束
}
//@author：Yeheya。2015-4-19


/*
 * 以下未上网。
程序设计说明如下。
    
    public SeqList(int length, T x)                        //构造顺序表，length个元素初值为x，x!=null，构造方法重载
    {
        this(length);                                      //创建容量为length的空表
        if (x==null)
            throw new java.lang.NullPointerException("x==null"); //抛出空对象异常，程序停止运行
        for (int i=0; i<length; i++)
            this.element[i] = x;                           //对象引用赋值
        this.n = length;
    }//5.2.2节矩阵行的单链表，不能用，因为x为同一条单链表对象，实际需要多条单链表对象，
     //并查集也不能用，x不能为int，需要-1。C++可用
    //@author：Yeheya。2014-8-5
 
*/
//第2章4. 顺序查找
/*    //从start（0≤start<n）开始查找首次出现的与key相等元素，返回元素序号i，0≤i<n；
  //若查找不成功返回-1。若key==null，Java抛出空对象异常NullPointerException
  public int indexOf(T key, int start)
  {
//      System.out.print(this.getClass().getName()+".indexOf("+key+","+start+")，");
      for (int i=start; i<this.n; i++)
      {
//        System.out.print(this.element[i]+"？");
          if (key.equals(this.element[i]))     //执行T类的equals(Object)方法，运行时多态
          return i;
      }
      return -1;                               //空表或未找到时
  }
      
  public int indexOf(T key)                    //查找首次出现的与key相等元素，返回元素序号
  {
      return this.indexOf(key, 0);             //从0开始查找
  }
  public int search(T key)                       //顺序查找，返回首次出现的与key相等元素；若查找不成功返回null
  {
//      int find=this.indexOf(key,0);
//      return find==-1 ? null : (T)this.element[find];

//    System.out.print(this.getClass().getName()+".indexOf("+key+","+start+")，");
      for (int i=0; i<this.n; i++)
      {
//        System.out.print(this.element[i]+"？");
          if (key.equals(this.element[i]))     //执行T类的equals(Object)方法，运行时多态
          return i;
      }
      return -1;                               //空表或未找到时
  }
  public T remove(T key)                       //删除首次出现的与key相等元素，返回被删除元素；查找不成功返回null
  {
//      return this.remove(this.indexOf(key,0));
      return this.remove(this.search(key));
  }    

  
  //实验2 顺序查找习题
  public void insertUnrepeatable(T x)          //插入不重复元素
  {
      if (this.indexOf(x)==-1)                 //查找不成功时，尾插入
          this.insert(x);
  }    
  public int lastIndexOf(T key)                //返回元素key最后出现位置，若未找到返回-1
  {
      if (key!=null)
          for (int i=this.n-1; i>=0; i--)
              if (key.equals(this.element[i]))
                  return i;
      return -1;                               //空表、key为空对象或未找到时
  }

  public void removeAll(T key)                 //删除所有与key相等元素，O(n)。？？改进，移动一次
  {
      if (key!=null)
      {
          int i=0;
          while (i<this.n)
              if (key.equals(this.element[i]))
                  this.remove(i);              //删除元素，this.n减1，i不变
              else i++;
      }
  }
  
  public void replace(T key, T x)              //将首次出现的与key相等元素替换为x，O(n)
  {
      if (key!=null && x!=null)
      {
          int i = this.indexOf(key);           //查找key首次出现位置
          if (i==-1)
          this.element[i] = x;
      }
  }
  public void replaceAll(T key, T x)           //将所有与key相等元素替换为x，O(n)
  {
      if (key!=null && x!=null)
          for (int i=0; i<this.n; i++)
              if (key.equals(this.element[i]))
                  this.element[i] = x;
  }

  //实验2
  //判断当前顺序表是否排序（升序）。T或其某个祖先类必须实现Comparable<T>接口
  public <T extends java.lang.Comparable<? super T>> boolean isSorted()
  {
      for (int i=0; i<this.n; i++)
          if (((T)this.element[i]).compareTo((T)this.element[i+1])>0)
              return false;
      return true;
  }

/*
可行，效率同上
    public String toString() 
    {
        String str="(";
        if (this.n()!=0)
        {
            for(int i=0; i<this.n()-1; i++)
                str += this.get(i).toString()+", ";
            str += this.get(this.n()-1).toString();
        }
        return str+")";
    }
*/
//author：Yeheya。2014-7-3

/*？？   //第10章
//顺序查找指定元素，若查找成功返回首次出现位置，否则返回-1
//在已按升序排列的value对象数组中折半查找关键字为key的元素，由比较器对象comparator指定对象比较大小的规则
public int indexOf(T key, java.util.Comparator<? super T> comparator)
{
    if (key!=null)
        for (int i=0; i<this.n; i++)
            if (this.element[i].equals(key))  //对象采用equals()方法比较是否相等
                return i;
    return -1;                               //空表、x为空对象或未找到时
}
}
*/