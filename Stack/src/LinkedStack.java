public final class LinkedStack<T> implements Stack<T>
{
    private SinglyList<T> list=new SinglyList<>();
    @Override
    public boolean isEmpty()
    {
        return this.list.isEmpty();
    }

    @Override
    public void push(T data)
    {
        this.list.insert(0,data);
    }

    @Override
    public T peek()
    {
        return this.list.get(0);
    }

    @Override
    public T pop()
    {
        return this.list.remove(0);
    }
}
