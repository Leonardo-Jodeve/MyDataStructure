import java.util.Random;

public class Sort
{
    public static int getRandomInt(int min,int max)
    {
        Random random=new Random();
        return min+random.nextInt(max-min);
    }

    public static int[] generateRandomArray(int length, int min, int max)
    {
        int[] random_array=new int[length];
        for(int i=0;i<length;i++)
        {
            random_array[i]=getRandomInt(min, max);
        }
        return random_array;
    }

    public static void printArray(int[] keys)
    {
        String string="(";
        for(int i=0; i<keys.length; i++)
        {
            string += keys[i];
            if(i!=keys.length-1)
                string += ",";
        }
        string += ")";
        System.out.println(string);
    }

    public static void advancedQuickSort(int[] keys, int begin, int end)
    {
        if(begin>=0 && end>0 && end<keys.length && begin<end)
        {
            int i=begin, j=end, temp;
            int vot=keys[(i+j)/2];
            while(i!=j)
            {
                while(keys[i]<vot && i<j)
                    i++;
                while(keys[j]>vot && j>i)
                    j--;
                if(keys[i]!=keys[j])
                {
                    temp = keys[i];
                    keys[i] = keys[j];
                    keys[j] = temp;
                }
                else if(i!=j)
                {
                    j--;
                }
                System.out.print("下标"+i+"～"+j+"， vot="+vot+"，  ");
                printArray(keys);
                if(j==i)
                {
                    advancedQuickSort(keys, begin, i);
                    advancedQuickSort(keys, j+1, end);
                }
                if(keys[i]==keys[j] && i==j-1)
                {
                    advancedQuickSort(keys, begin, i);
                    advancedQuickSort(keys, j, end);
                }
            }
        }
    }

    public static void advancedQuickSort(int[] keys)
    {
        advancedQuickSort(keys, 0, keys.length-1);
        System.out.print("升序排序结果为：");
        printArray(keys);
    }

    public static void advancedQuickSort(int[] keys, boolean sortmode)
    {
        advancedQuickSort(keys);
        if(!sortmode)
        {
            int[] temp=new int[keys.length];
            for(int i=keys.length-1; i>=0; i--)
            {
                temp[keys.length-i-1] = keys[i];
            }
            for(int i=0; i<temp.length; i++)
            {
                keys[i]=temp[i];
            }
        }
        System.out.print("降序排序结果为：");
        printArray(keys);
    }

    public static void main(String[] args)
    {
        int[] raw=generateRandomArray(getRandomInt(10,15),0,20);
        printArray(raw);
        advancedQuickSort(raw,false);
    }
}


//    public static void classicQuickSort(int[] keys, int begin, int end)
//    {
//        if (begin>=0 && end>=0 && end<keys.length && begin<end)
//        {
//            int i=begin, j=end;
//            int vot=keys[i];
//            while (i!=j)
//            {
//                while (i<j && keys[j]>=vot)
//                    j--;
//                if (i<j)
//                    keys[i++]=keys[j];
//
//                while (i<j && keys[i]<=vot)
//                    i++;
//                if (i<j)
//                    keys[j--]=keys[i];
//            }
//            keys[i]=vot;
//            System.out.print("下标"+begin+"～"+end+"， vot="+vot+"，  ");
//            printArray(keys);
//            classicQuickSort(keys, begin, j-1);
//            classicQuickSort(keys, i+1, end);
//        }
//    }

//    public static void classicQuickSort(int[] keys)
//    {
//        classicQuickSort(keys, 0, keys.length-1);
//    }