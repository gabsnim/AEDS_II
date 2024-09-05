class sort
{

    public static boolean isPar (int x)
    {
        boolean r = true;
        if(x % 2 != 0)
        {
            r = false;
        }
        return r;
    }

    public static int[] swap (int[] array, int i, int j)
    {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        return array;
    }

    public static int[] sort (int n, int m, int array[])
    {

        for(int i = 0; i < n - 1; i++)
        {
            int menor = i;

            for(int j = (i + 1); j < n; j++)
            {
                if(array[menor] % m > array[j] % m)
                {
                    if(array[menor] % m == array[j] % m)
                    {
                        
                    }
                    menor = j;
                }
            }
            array = swap(array, menor, i);
        }
        return array;
    }

    public static void main (String[] args)
    {
        int n;
        int m;

        n = MyIO.readInt();
        m = MyIO.readInt();

        int[] array = new int[n];

        for(int i = 0; i < n; i++)
        {
            array[i] = MyIO.readInt();
        }

        for(int i = 0; i < n; i++)
        {
            System.out.print(" "+   array[i]);
        }
        System.out.println("");
        array = sort(n,m,array);

        for(int i = 0; i < n; i++)
        {
            System.out.print(" "+   array[i]);
        }
    }
}   