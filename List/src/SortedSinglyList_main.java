public class SortedSinglyList_main
{
    public static void main(String[] args)
    {
        Integer[] numbers1={1,2,3,4,5,6};
        SinglyList singlyList=new SinglyList(numbers1);
        SortedSinglyList sortedSinglyList=new SortedSinglyList(singlyList,false);
        System.out.println(sortedSinglyList);
    }
}
