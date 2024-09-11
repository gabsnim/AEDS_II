class selection
{
    public static void swap (int[] array, int i, int j)
    {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    //  O(n²)
    public static void selectionSort (int[] array)
    {
        for ( int i = 0; i < array.length - 1; i++ )
        {
            int lowest = i;
            for ( int j = i + 1; j < array.length; j++ )
            {
                if ( array[lowest] > array[j] )
                {
                    lowest = j;
                }
            }
            swap(array, i, lowest);
        }
    }

    //  O(n²)
    public static void optSelectionSort(int array[], int length)
    {   
        int left = 0;
        int right = length;

        while (left < right)
        {
            int lowest = left;
            int max = left;

            for (int i = left; i < right; i++)
            {
                if (array[i] < array[lowest]) lowest = i;
                if (array[i] > array[max]) max = i;
            }

            swap(array, lowest, left);
            
            // Se o valor máximo estiver na posição 'left', ajustar o índice 'max' para não trocar incorretamente
            if (max == left)
            { 
                max = lowest;
            }

            swap(array, max, right - 1);

            left++;
            right--;
        }

    }
    public static void main(String[] args)
    {
        int[] array = {9,8,7,6,5,3,1,5,2};

        selectionSort(array);    
    }
}