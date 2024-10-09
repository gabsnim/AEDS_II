/**
 * Gabriel Xavier Borges - 805347
 * Lab 06 
 * Variacoes do QuickSort com menu de escolhas
 */

import java.util.*;

class quick
{
    static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static void QuickSortFirstPivot(int[] array, int left, int right)
    {
        int i = left, j = right;
        int pivo = array[left];  
        while (i <= j)
        {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j)
            {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (left < j) QuickSortFirstPivot(array, left, j);
        if (i < right) QuickSortFirstPivot(array, i, right);
    }

    static void QuickSortLastPivot(int[] array, int left, int right)
    {
        int i = left, j = right;
        int pivo = array[right];  
        while (i <= j)
        {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j)
            {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (left < j) QuickSortLastPivot(array, left, j);
        if (i < right) QuickSortLastPivot(array, i, right);
    }

    static void QuickSortRandomPivot(int[] array, int left, int right)
    {
        int i = left, j = right;
        int random = left + (int) (Math.random() * (right - left + 1));
        int pivo = array[random];  
        while (i <= j)
        {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j)
            {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (left < j) QuickSortRandomPivot(array, left, j);
        if (i < right) QuickSortRandomPivot(array, i, right);
    }

    static void QuickSortMedianOfThree(int[] array, int left, int right)
    {
        int i = left, j = right;

        int mid = (left + right) / 2;
        int pivo = medianOfThree(array, left, mid, right);

        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j)
            {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (left < j) QuickSortMedianOfThree(array, left, j);
        if (i < right) QuickSortMedianOfThree(array, i, right);
    }

    static int medianOfThree(int[] array, int left, int mid, int right)
    {
        if (array[left] > array[mid]) swap(array, left, mid);
        if (array[left] > array[right]) swap(array, left, right);
        if (array[mid] > array[right]) swap(array, mid, right);
        return array[mid]; 
    }


    static int[] createOrderedArray(int size)
    {
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
        {
            array[i] = i;
        }
        return array;
    }


    static int[] createNearlyOrderedArray(int size)
    {
        int[] array = createOrderedArray(size);
        Random random = new Random();

        for (int i = 0; i < size / 10; i++)
        {
            int idx1 = random.nextInt(size);
            int idx2 = random.nextInt(size);
            swap(array, idx1, idx2);
        }
        return array;
    }


    static int[] createRandomArray(int size)
    {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
        {
            array[i] = random.nextInt(size * 10);  
        }
        return array;
    }

    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose QuickSort method:");
        System.out.println("1 - QuickSort with First Pivot");
        System.out.println("2 - QuickSort with Last Pivot");
        System.out.println("3 - QuickSort with Random Pivot");
        System.out.println("4 - QuickSort with Median of Three Pivot");

        int option = scanner.nextInt();

        System.out.println("Choose array type:");
        System.out.println("1 - Ordered");
        System.out.println("2 - Nearly Ordered");
        System.out.println("3 - Random");

        int arrayType = scanner.nextInt();

        System.out.println("Choose array size:");
        System.out.println("1 - 100");
        System.out.println("2 - 1000");
        System.out.println("3 - 10000");

        int arraySize = scanner.nextInt();
        int size = arraySize == 1 ? 100 : arraySize == 2 ? 1000 : 10000;

        int[] array;
        switch (arrayType)
        {
            case 1:
                array = createOrderedArray(size);
                break;
            case 2:
                array = createNearlyOrderedArray(size);
                break;
            case 3:
                array = createRandomArray(size);
                break;
            default:
                array = createRandomArray(size); 
                break;
        }

        long startTime = System.nanoTime();

        switch (option)
        {
            case 1:
                QuickSortFirstPivot(array, 0, array.length - 1);
                break;
            case 2:
                QuickSortLastPivot(array, 0, array.length - 1);
                break;
            case 3:
                QuickSortRandomPivot(array, 0, array.length - 1);
                break;
            case 4:
                QuickSortMedianOfThree(array, 0, array.length - 1);
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }

        // System.out.println(Arrays.toString(array));

        long endTime = System.nanoTime();  

        long duration = endTime - startTime;  
        System.out.println("nanoseconds: " + duration);
        System.out.println("milliseconds: " + duration / 1_000_000);

        scanner.close();
    }
}
