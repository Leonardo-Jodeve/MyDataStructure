public class SortedSinglyList_main
{
    public static void main(String[] args)
    {
        Integer[] numbers1={1,2,3,4,5,6},
        numbers2={1,4,7,8,10},
        numbers3={2,6,9,12};

        SinglyList singlyList=new SinglyList<>(numbers1);
        SortedSinglyList sortedSinglyList=new SortedSinglyList<>(singlyList,false);
        System.out.println("降序排列："+sortedSinglyList);
        SortedSinglyList sortedSinglyList1=new SortedSinglyList<>(singlyList,true);
        System.out.println("升序排列："+sortedSinglyList1);
        System.out.println();

        SinglyList singlyList2=new SinglyList<>(numbers2);
        SinglyList singlyList3=new SinglyList<>(numbers3);
        SortedSinglyList sortedSinglyList2=new SortedSinglyList<>(singlyList2,true);
        SortedSinglyList sortedSinglyList3=new SortedSinglyList<>(singlyList3,true);

        System.out.println("排序数列①"+sortedSinglyList2);
        System.out.println("排序数列②"+sortedSinglyList3);
        sortedSinglyList2.addAll2(sortedSinglyList3);
        System.out.println("①②组合数列"+sortedSinglyList2);


    }
}