

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

    public static boolean isLetra(char c)
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

    public static String onlyOperadores (char [] array)
    {
        String str = "";

        for(int i = 0; i < array.length; i++)
        {
            if(isLetra(array[i]))
            {
                str += (char)(array[i]);
            }
        }

        return str;
    }

    public static String onlyOperandos (char [] array)
    {
        String str = "";

        for(int i = 0; i < array.length; i++)
        {
            if(isDigit(array[i]))
            {
                str += (char)(array[i]);
            }
        }

        return str;
    }

    public static void operaracao (char[] operandos, char[] operadores) //obs: mudar para char[] 
    {
        char[] pilha = new char[operandos.length + operadores.length];
        int x = 0;
        
        for(int i = operadores.length - 1, n = operandos.length -1; i >= 0 && n >= 0; i--, n--)
        {
            if(operadores[i] == 't')
            {
                pilha[x] = NOT(operandos[n]); 
            }
            else if(operadores[i] == 'd')
            {
                pilha[x] = AND(operandos[n], operandos[n-1]);
            }
            else if(operadores[i] == 'r')
            {
                pilha[x] = OR(operandos[n], operandos[n-1]);
            }
            x++;
        }

        for (char i : pilha) 
        {
            System.out.print(i);
        }
    }

    public static void main (String[] args)
    {
        String teste = aux1("2 0 0 and(not(A) , not(B))");
        char[] array = toArray(teste);
        
        for (char i : array) 
        {
            System.out.print(i);
        }

        String operadores = onlyOperadores(array);
        char[] operadoresarray = toArray(operadores); 
        System.out.println("\n"+operadores);

        String operandos = onlyOperandos(array);
        char[] operandossarray = toArray(operandos); 
        System.out.println("="+operandos);

        operaracao(operandossarray, operadoresarray);
    }
}