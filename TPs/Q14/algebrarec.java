/**
 * Gabriel Xavier Borges - 805347 - Q14;
 */

class algebrarec
{   

    // public static boolean isEnd(String str)
    // {
    //     return (str.length() == 1 && str.charAt(0) == '0');
    // }

    /* ============================================================================== */
    /*                               AUXILIARES                                       */

    public static boolean isDigit(char c)
    {
        return (c >= '0' && c <= '9');
    }

    public static boolean isLetra(char c)
    {
        return (c >= 'a' && c <= 'z');
    }

    public static String setValues(String str)
    {
        return setValuesRecursive(str, 0, "");
    }

    /**
     * Funcao para setar os valores das variaveis
     * @param String str, int i, String aux
     */
    public static String setValuesRecursive(String str, int i, String aux)
    {
        if (i >= str.length())
        {
            return aux;
        }

        if (!isDigit(str.charAt(i)) && str.charAt(i) != ' ') {
            if (str.charAt(i) == 'A')
            {
                aux += str.charAt(2);
            }
            else if (str.charAt(i) == 'B')
            {
                aux += str.charAt(4);
            } 
            else if (str.charAt(i) == 'C')
            {
                aux += str.charAt(6);
            }
            else 
            {
                aux += str.charAt(i);
            }
        }
        return setValuesRecursive(str, i + 1, aux);
    }

    public static char[] toArray(String str)
    {
        return toArrayRecursive(str, 0, "");
    }

    /**
     * Funcao auxiliar para transformar string em array
     */
    public static char[] toArrayRecursive(String str, int i, String aux)
    {
        if (i >= str.length())
        {
            return aux.toCharArray();
        }

        if (str.charAt(i) == 'd' || str.charAt(i) == 't' || str.charAt(i) == 'r' || isDigit(str.charAt(i)))
        {
            aux += str.charAt(i);
        }

        return toArrayRecursive(str, i + 1, aux);
    }

    /* ============================================================================ */
    /*                                 OPERADORES                                   */

    /**
     * Funcao recursiva para operar a pilha com operador NOT
     * @param char[] pilha, int i
     * @return pilha[]
     */
    public static char[] NOT(char[] pilha, int i)
    {
        pilha[i+1] = (pilha[i+1] == '1') ? '0' : '1';
        pilha[i] = pilha[i+1];
        pilha[i+1] = '*';

        return removeNonDigits(pilha, i + 2);
    }

    public static char[] AND(char[] pilha, int i)
    {
        return ANDRecursive(pilha, i, i);
    }

    /**
     * Funcao recursiva para operar a pilha com operador AND
     * @param char[] pilha, int i, int n
     * @return pilha[]
     */
    public static char[] ANDRecursive(char[] pilha, int i, int n)
    {
        if (n >= pilha.length) 
        {
            return removeNonDigits(pilha, i + 1);
        }

        if (isDigit(pilha[n]))
        {
            for (int x = n + 1; x < pilha.length; x++)
            {
                if (isDigit(pilha[x]))
                {
                    pilha[i] = (pilha[n] == '0' || pilha[x] == '0') ? '0' : '1';
                    pilha[n] = pilha[x] = '*';
                    return removeNonDigits(pilha, i + 1);
                }
            }
        }

        return ANDRecursive(pilha, i, n + 1);
    }

    public static char[] OR(char[] pilha, int i)
    {
        return ORRecursive(pilha, i, i);
    }

    /**
     * Funcao recursiva para operar a pilha com operador OR
     * @param char[] pilha, int i, int n
     * @return pilha[]
     */
    public static char[] ORRecursive(char[] pilha, int i, int n)
    {
        if (n >= pilha.length)
        {
            return removeNonDigits(pilha, i + 1);
        }

        if (isDigit(pilha[n]))
        {
            for (int x = n + 1; x < pilha.length; x++)
            {
                if (isDigit(pilha[x]))
                {
                    pilha[i] = (pilha[n] == '1' || pilha[x] == '1') ? '1' : '0';
                    pilha[n] = pilha[x] = '*';
                    return removeNonDigits(pilha, i + 1);
                }
            }
        }

        return ORRecursive(pilha, i, n + 1);
    }


    /**
     * Funcao auxiliar para remover caracteres inuteis da pilha
     */
    public static char[] removeNonDigits(char[] pilha, int i)
    {
        if (i >= pilha.length)
        {
          return pilha;  
        } 

        if (!isDigit(pilha[i]))
        {
            pilha[i] = ' ';
        }

        return removeNonDigits(pilha, i + 1);
    }

    /* =========================================================================== */

    /**
     * Metodo auxiliar para chamar o metodo recursivo operacaoRecursive
     */
    public static void operacao(char[] pilha)
    {
        operacaoRecursive(pilha, pilha.length - 1);
        System.out.println("" + pilha[0]);
    }

    /**
     * Metodo recursivo para operar a pilha
     * @param char[] pilha
     * @param int i
     */
    public static void operacaoRecursive(char[] pilha, int i)
    {
        if (i < 0) return;

        if (pilha[i] == 't')
        {
            pilha = NOT(pilha, i);
        }
        else if (pilha[i] == 'd')
        {
            pilha = AND(pilha, i);
        }
        else if (pilha[i] == 'r')
        {
            pilha = OR(pilha, i);
        }

        operacaoRecursive(pilha, i - 1);
    }

    /**
     * Funcao principal
     * @param String []args
     */
    public static void main(String[] args)
    {
        String str;
        char[] array;

        for(int i = 1; i <= 104; i++)
        {
            str = MyIO.readLine();
            String aux = setValues(str);
            array = toArray(aux);
            operacao(array);
        }
    }
}