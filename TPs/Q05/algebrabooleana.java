

class algebrabooleana
{   

    /* ============================================================================== */
    /*                               AUXILIARES                                       */

    public static boolean isDigit(char c)
    {
        boolean r = false;
        if(c >= '0' && c <= '9')
        {
            r = true;
        }
        return r;
    }

    public static boolean isLetra(char c)
    {
        boolean r = false;
        if(c >= 'a' && c <= 'z')
        {
            r = true;
        }
        return r;
    }

    // public static char[] setValues (String str)
    // {
    //     int n = str.length();
    //     char[] auxarray = new char[n];
    //     int x = (int)(str.charAt(0) - 47);
    //     char[] array = new char[n - x];


    //     for(int i = 0; i < n; i++)
    //     {
    //        auxarray[i] = str.charAt(i);
    //     }

    //     for(int i = 0; i < auxarray.length; i++)
    //     {
    //         if(auxarray[i] == 'A')
    //         {
    //             auxarray[i] = auxarray[1];
    //         }
    //         else if(auxarray[i] == 'B')
    //         {
    //             auxarray[i] = auxarray[2];
    //         }
    //         else if(auxarray[i] == 'C')
    //         {
    //             auxarray[i] = auxarray[3];
    //         }
    //     }

    //     for(int i = 0; i < array.length; i++)
    //     {
    //         array[i] = auxarray[i+x];
    //     }

    //     return array;
    // }

    public static char[] toArray (String str)
    {
        char [] array =  new char[str.length()];

        for(int i = 0; i < str.length(); i++)
        {
            array[i] = (char)(str.charAt(i));
        }

        return array;
    }


    public static String aux1 (String str) //remover espacos E digitos
    {
        String newstr = "";

        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) != ' ' && !isDigit(str.charAt(i)))
            {
                newstr += (char)(str.charAt(i));
            }
        }
        return newstr;
    }

    /* ============================================================================ */
    /*                                 OPERADORES                                   */
    public static char NOT (char c)
    {
        if(c  == '0')
        {
            return '1';
        }
        return '0';
    }

    public static char AND (char c, char z)
    {
        if(c == '1' && z == '1')
        {
            return '1';
        }
        return '0';
    }

    public static char OR (char c, char z)
    {
        if(c == '0' && z == '0')
        {
            return '0';
        }
        return '1';
    }

    /* =========================================================================== */

    public static char[] onlyOperandos (String str)
    {
        int x = (int)(str.charAt(0) - 48);
        char[] array = new char[x];

        if(x > 2)
        {
            array[0] = str.charAt(2);
            array[1] = str.charAt(4);
            array[2] = str.charAt(6);
        }
        else
        {
            array[0] = str.charAt(2);
            array[1] = str.charAt(4);
        }

        return array;
    }

    public static void operacao (String str, char[] array)
    {
        // System.out.println(""+str);
        // for (char i : array)
        // {
        //     System.out.print(i);
        // }
        String newstr = "";

        for(int i = str.length() - 1; i >= 0; i--)
        {
            if(str.charAt(i) == '(')
            {
                if(str.charAt(i-1) == 't')
                {
                    if(str.charAt(i+1) == 'A')
                    {
                        newstr += (char)(NOT(array[0]));
                    }
                    else if(str.charAt(i+1) == 'B')
                    {
                        newstr += (char)(NOT(array[1]));
                    }
                    else if(str.charAt(i+1) == 'C')
                    {
                        newstr += (char)(NOT(array[2]));
                    }
                }
            }
        }

        System.out.println(""+newstr);
    }
    public static void main (String[] args)
    {
        String teste = "2 0 0 and(not(A) , not(B))";
        char [] array = null;
        array = onlyOperandos(teste);

        operacao(aux1(teste), array);
    }
}