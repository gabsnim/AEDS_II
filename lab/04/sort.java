/**
 * Gabriel Xavier Borges - 805347 - LAB04
 */

class sort
{
    /**
     * Funcao auxiliar para saber se numero e impar
     * @param int x
     * @return boolean
     */
    public static boolean isImpar (int x)
    {
        boolean r = false;
        if(x % 2 != 0)
        {
            r = true;
        }
        return r;
    }

    /**
     * Ordenar com o algortimo insercao mas usando as restricoes;
     * @param array, int m
     * @return array ordenado 
     */
    public static int[] ordenar (int[] array, int m)
    {
        for (int i = 1; i < array.length; i++)
        {
            int aux = array[i];
            int j = i - 1;

            while (j >= 0 && cmp(array[j], aux, m))
            {
                array[j+1] = array[j];
                j--;
            }

            array[j+1] = aux;
        }
        return array;
    }

    /**
     * Funcao auxiliar para ajudar a ordenacao de acordo com enunciado
     * @param int x, int y, int m
     * @return boolean
     */
    public static boolean cmp (int x, int y, int m)
    {
        int modx = x % m;
        int mody = y % m;

        if(modx != mody)
        {
            return modx > mody;
        }

        if (isImpar(x) && !isImpar(y))
        {
            return false; 
        }
        if (!isImpar(x) && isImpar(y))
        {
            return true; 
        }

        if (isImpar(x) && isImpar(y))
        {
            return x < y;
        }

        return x > y;
    }

    /**
     * Funcao principal
     * @param String[] args
     */
    public static void main(String[] args)
    {
        int n = MyIO.readInt();
        int m = MyIO.readInt();

        do
        {

            int [] array = new int [n];

            for(int i = 0; i < n; i++)
            {
                array[i] = MyIO.readInt();
            }    

            array = ordenar(array, m);

            System.out.println(n + " " + m);

            for(int x : array)
            {
                System.out.println(x);
            }

            n = MyIO.readInt();
            m = MyIO.readInt();

            if(n == 0 && m == 0)
            {
                System.out.print(n + " " + m);
            }

        }while(n != 0 && m != 0);

    }
}