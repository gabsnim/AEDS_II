class sort
{


    public static int[] sort (int n, int m, int array[])
    {

        for(int i = 1; i < n; i++)
        {
            
        }
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

        sort(n,m,array);
    }
}