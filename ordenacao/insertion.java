class insertion
{
    public static void swap (int[] array, int i, int j)
    {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static int binarySearch(int array[], int right, int key)
    {
        int left = 0;
        while (left <= right)
        {
            int middle = (left + right) / 2;
            if (array[middle] == key)
            {
                return middle + 1;
            }
            else if (array[middle] > key)
            {
                right = middle - 1;
            }
            else 
            {
                left = middle + 1;
            }
        }
        return left;
    }

    public static void optinsertionSort(int array[])
    {
        for (int i = 1; i < array.length; i++)
        {
            int tmp = array[i];
            int j = i - 1;
            int locate = binarySearch(array, i, array[i]);
            while (j >= locate)
            {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = tmp;
        }
    }

    // O (N²)
    public static void insertionSort(int array[])
    {
        for (int i = 1; i < array.length; i++)
        {
            int tmp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > tmp)
            {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = tmp;
        }
    }

    public static void main(String[] args)
    {
        int[] array = {9,8,7,6,5,3,1,5,2};

        insertionSort(array);    
    }
}