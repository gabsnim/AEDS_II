/**
 * Gabriel Xavier Borges - 805347 - Q14;
 */

class algebrarec
{   
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

    public static String setValuesRecursive(String str, int i, String aux)
    {
        if (i >= str.length())
        {
            return aux;
        }

        if (!isDigit(str.charAt(i)) && str.charAt(i) != ' ' && str.charAt(i) != '(' && str.charAt(i) != ')' && str.charAt(i) != ',')
        {
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

    public static char[] toArrayRecursive(String str, int i, String aux)
    {
        if (i >= str.length())
        {
            return aux.toCharArray();
        }

        if (str.charAt(i) == 'd' || str.charAt(i) == 't' || str.charAt(i) == 'r' || isDigit(str.charAt(i)) || str.charAt(i) == '(' || str.charAt(i) == ')')
        {
            aux += str.charAt(i);
        }

        return toArrayRecursive(str, i + 1, aux);
    }

    public static char[] NOT(char[] pilha, int i)
    {
        if (i + 1 < pilha.length) { // Check bounds before accessing
            pilha[i + 1] = (pilha[i + 1] == '1') ? '0' : '1';
            pilha[i] = pilha[i + 1];
            pilha[i + 1] = '*';
        }
        return removeNonDigits(pilha);
    }

    public static char[] AND(char[] pilha, int i)
    {
        return ANDRecursive(pilha, i, i);
    }

    public static char[] ANDRecursive(char[] pilha, int i, int n)
    {
        if (n >= pilha.length) 
        {
            return removeNonDigits(pilha);
        }

        if (isDigit(pilha[n]))
        {
            for (int x = n + 1; x < pilha.length; x++)
            {
                if (isDigit(pilha[x]))
                {
                    pilha[i] = (pilha[n] == '0' || pilha[x] == '0') ? '0' : '1';
                    pilha[n] = pilha[x] = '*';
                    return removeNonDigits(pilha);
                }
            }
        }

        return ANDRecursive(pilha, i, n + 1);
    }

    public static char[] OR(char[] pilha, int i)
    {
        return ORRecursive(pilha, i, i);
    }

    public static char[] ORRecursive(char[] pilha, int i, int n)
    {
        if (n >= pilha.length)
        {
            return removeNonDigits(pilha);
        }

        if (isDigit(pilha[n]))
        {
            for (int x = n + 1; x < pilha.length; x++)
            {
                if (isDigit(pilha[x]))
                {
                    pilha[i] = (pilha[n] == '1' || pilha[x] == '1') ? '1' : '0';
                    pilha[n] = pilha[x] = '*';
                    return removeNonDigits(pilha);
                }
            }
        }

        return ORRecursive(pilha, i, n + 1);
    }

    public static char[] removeNonDigits(char[] pilha)
    {
        StringBuilder sb = new StringBuilder();
        for (char c : pilha)
        {
            if (isDigit(c))
            {
                sb.append(c);
            }
        }
        return sb.toString().toCharArray();
    }

    public static void operacao(char[] pilha)
    {
        pilha = removeNonDigits(pilha); // Remove non-digits before processing
        operacaoRecursive(pilha, pilha.length - 1);
        if (pilha.length > 0) {
            System.out.println("" + pilha[0]);
        }
    }

    public static void operacaoRecursive(char[] pilha, int i)
    {
        if (i < 0) return;

        if (i < pilha.length) { // Ensure index is within bounds
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
        }

        operacaoRecursive(pilha, i - 1);
    }

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
