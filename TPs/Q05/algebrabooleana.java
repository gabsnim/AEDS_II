class algebrabooleana
{
    public static char[] toArray (String str)
    {
        int n = str.length();
        char[] auxarray = new char[n];
        int x = (int)(str.charAt(0) - 47);
        char[] array = new char[n - x];


        for(int i = 0; i < n; i++)
        {
           auxarray[i] = str.charAt(i);
        }

        for(int i = 0; i < auxarray.length; i++)
        {
            if(auxarray[i] == 'A')
            {
                auxarray[i] = auxarray[1];
            }
            else if(auxarray[i] == 'B')
            {
                auxarray[i] = auxarray[2];
            }
            else if(auxarray[i] == 'C')
            {
                auxarray[i] = auxarray[3];
            }
        }

        for(int i = 0; i < array.length; i++)
        {
            array[i] = auxarray[i+x];
        }

        return array;
    }


    public static String aux1 (String str) //remover espacos
    {
        String newstr = "";

        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) != ' ')
            {
                newstr += (char)(str.charAt(i));
            }
        }
        return newstr;
    }

    /* ===================================================== */

    public static boolean NOT (char c)
    {
        boolean r = false;
        if(c == 0)
        {
            r = true;
        }
        return r;
    }

    public static void main (String[] args)
    {
        //String line;
        String teste = "3 0 0 0 and(or(A , B) , not(and(B , C)))";
        //line = MyIO.readLine();
        System.out.println(toArray(aux1(teste)));

    }
}