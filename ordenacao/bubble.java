class bubble
{
    public static void swap (int[] array, int i, int j)
    {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    // Bubble O(N²)
    public static void bubbleSort(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    // Bubble opt
    public static void optBubbleSort(int[] array)
    {
        int last_swap = array.length - 1;
        for (int i = 0; i < array.length - 1; i++)
        {
            int new_last_swap = 0;
            for (int j = 0; j < last_swap; j++)
            {
                if (array[j] > array[j + 1])
                {
                    swap(array, j, j + 1);
                    new_last_swap = j;
                }
            }
            if (new_last_swap == 0)
            {
                i = array.length;
            }
            else
            {
                last_swap = new_last_swap;
            }
        }
    }


    public static void main(String[] args)
    {
        int[] array = {9,8,7,6,5,3,1,5,2};

        bubbleSort(array);
    }
}