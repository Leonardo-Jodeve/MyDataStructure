public class SinglyList_main
{
    public static void main(String[] args)
    {
        Integer[] numbers1={1,2,3,4,5},numbers2={6,7,8,9,10},
        numbers3={1,2,3,4},numbers4={1,2,3,4,5},
        numbers5={1,2,3,5},numbers6={1,2,3,4},
        numbers7={1,2,3,4,5,6,7,8,9,10};

        SinglyList<Integer> integerSinglyList1=new SinglyList<>(numbers1),
                integerSinglyList2=new SinglyList<>(numbers2),
                integerSinglyList3=new SinglyList<>(numbers3),
                integerSinglyList4=new SinglyList<>(numbers4),
                integerSinglyList5=new SinglyList<>(numbers5),
                integerSinglyList6=new SinglyList<>(numbers6),
                integerSinglyList7=new SinglyList<>(numbers7);

        System.out.println("链表1源表是："+integerSinglyList1);
        System.out.println("链表2源表是："+integerSinglyList2);
        System.out.println("");
        integerSinglyList1.addAll(1,integerSinglyList2);
        System.out.println("链表1经过addAll(1,链表2)变为："+integerSinglyList1);
        System.out.println("链表2保持不变："+integerSinglyList2+",深拷贝成功。");
        System.out.println("");
        System.out.println(integerSinglyList3.equals(integerSinglyList4));
        System.out.println(integerSinglyList3.equals(integerSinglyList5));
        System.out.println(integerSinglyList3.equals(integerSinglyList6));
        System.out.println("");
        System.out.println(integerSinglyList7.subList(2,5));
        System.out.println(integerSinglyList7.subList(2,200));
        System.out.println(integerSinglyList7);
    }
}
