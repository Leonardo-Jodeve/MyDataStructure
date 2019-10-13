public class SortedSinglyList_main
{
    public static void main(String[] args)
    {
        Integer[] numbers1={1,2,3,4,5,6};
        SinglyList singlyList=new SinglyList<>(numbers1);
        SortedSinglyList sortedSinglyList=new SortedSinglyList<>(singlyList,false);
        System.out.println("降序排列："+sortedSinglyList);
        SortedSinglyList sortedSinglyList1=new SortedSinglyList<>(singlyList,true);
        System.out.println("升序排列："+sortedSinglyList1);
    }
}
