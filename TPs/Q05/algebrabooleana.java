class algebrabooleana
{   
    public static boolean isDigit(char c)
    {
        boolean r = false;
        if(c >= '0' && c <= '9')
        {
            r = true;
        }
        return r;
    }

    public static boolean isOperador(char c)
    {
        boolean r = false;
        if(c >= 'a' && c <= 'z')
        {
            r = true;
        }
        return r;
    }

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

    public static char operador (char c, char z) //C = variavel && Z = operador
    {
        if(z == 't')
        {
            return NOT(c);
        }
        else if(z == 'd')
        {
            return AND(c, z);
        }
        else
        {
            return OR(c, z);
        }
    }

    public static void operaracao (char[] pilha) //obs: mudar para char[] 
    {
        int n = pilha.length;
        int count = 0;
        int j = 0;
        char[] pilhaorganizada = new char[n];
        //System.out.println("xd"+n);
        char c;
        for(int i = n-1; i >= 0; i--)
        {
            if(isDigit(pilha[i]))
            {
                j = i;
                while(j > 0)
                {
                    if(isOperador(pilha[j]))
                    {
                        pilhaorganizada[count] = operador(pilha[i], pilha[j]);
                        count++;
                        j = 0;
                    }
                    j--;
                }
            }
        }
    }

    public static void main (String[] args)
    {
        //String line;
        String teste = "2 0 1 and(not(A) , not(B))";
        //line = MyIO.readLine();
        System.out.println(toArray(aux1(teste)));
        System.out.println(""+operaracao(toArray(aux1(teste))));

    }
}