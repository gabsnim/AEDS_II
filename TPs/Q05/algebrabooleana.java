/**
 * Gabriel Xavier Borges - Q05
 */

class algebrabooleana
{   

    /**
     * Funcao para verificar condicao de parada
     * @param String
     * @return boolean
     */
    public static boolean isEnd(String str)
    {
        boolean r = false;

        if(str.length() == 1 && str.charAt(0) == '0')
        {
            r = true;
        } 

        return r;
    }

    /* ============================================================================== */
    /*                               AUXILIARES                                       */

    /**
     * Funcao para verificar se caracter e digito
     * @param char
     * @return boolean
     */
    public static boolean isDigit(char c)
    {
        boolean r = false;
        if(c >= '0' && c <= '9')
        {
            r = true;
        }
        return r;
    }

    /**
     * Funcao para verificar se caracter e letra
     * @param char
     * @return boolean
     */
    public static boolean isLetra(char c)
    {
        boolean r = false;
        if(c >= 'a' && c <= 'z')
        {
            r = true;
        }
        return r;
    }

    /**
     * Funcao para setar valor as variaveis
     * @param String
     * @return String
     */
    public static String setValues (String str)
    {
        String aux = "";

        for(int i = 0; i < str.length(); i++)
        {
            if(!isDigit(str.charAt(i)) && str.charAt(i) != ' ')
            {
                if(str.charAt(i) == 'A')
                {
                    aux += (char)(str.charAt(2));
                }
                else if(str.charAt(i) == 'B')
                {
                    aux += (char)(str.charAt(4));
                }
                else if(str.charAt(i) == 'C')
                {
                    aux += (char)(str.charAt(6));
                }
                else
                {
                    aux += (char)(str.charAt(i));
                }
            }
        }

        return aux;
    }

    /**
     * Funcao para transformar string em array
     * @param String
     * @return char[]
     */
    public static char[] toArray (String str) //remover espacos E digitos
    {
        String aux = "";
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == 'd')
            {
                aux += (char)(str.charAt(i));
            }
            else if(str.charAt(i) == 't')
            {
                aux += (char)(str.charAt(i));
            }
            else if(str.charAt(i) == 'r')
            {
                aux += (char)(str.charAt(i));
            }
            else if(isDigit(str.charAt(i)))
            {
                aux += (char)(str.charAt(i));
            }
        }

        char[] array = new char[aux.length()];

        for(int i = 0; i < aux.length(); i++)
        {
            array[i] = (char)(aux.charAt(i));
        }
        return array;
    }

    /* ============================================================================ */
    /*                                 OPERADORES                                   */

    /**
     * Funcao para operar a pilha com o operador NOT
     * @param pilha, int i
     * @return char[] pilha operada
     */
    public static char[] NOT (char[] pilha, int i)
    {
        if(pilha[i+1] == '1')
        {
            pilha[i+1] = '*';
            pilha[i] = '0';
        }
        else if(pilha[i+1] == '0')
        {
            pilha[i+1] = '*';
            pilha[i] = '1';
        }

        for(int n = i + 1; n < pilha.length; n++)   //uma opcao e concatenar com string e retonar um toArray
        {
            if(!isDigit(pilha[n]))
            {
                pilha[n] = ' ';
            }
        }   
        return pilha;
    }

    /**
     * Funcao para operar a pilha com o operador AND
     * @param pilha, int i
     * @return char[] pilha operada
     */
    public static char[] AND (char[] pilha, int i)
    {
        for(int n = i; n < pilha.length; n++)
        {
            if(isDigit(pilha[n]))
            {
                for(int x = n+1; x < pilha.length; x++)
                {
                    if(isDigit(pilha[x]))
                    {
                        if(pilha[n] == '0' || pilha[x] == '0')
                        {
                            pilha[n] = '*';
                            pilha[x] = '*';
                            pilha[i] = '0';
                        }
                        else
                        {
                            pilha[n] = '*';
                            pilha[x] = '*';
                            pilha[i] = '1';
                        }
                        x = pilha.length;
                    }
                }
                n = pilha.length;
            }
        }

        for(int j = i+1; j < pilha.length; j++)
        {
            if(!isDigit(pilha[j]))
            {
                pilha[j] = ' ';
            }
        }
        return pilha;
    }

    /**
     * Funcao para operar a pilha com o operador OR
     * @param pilha, int i
     * @return char[] pilha operada
     */
    public static char[] OR (char[] pilha, int i)
    {
        for(int n = i; n < pilha.length; n++)
        {
            if(isDigit(pilha[n]))
            {
                for(int x = n+1; x < pilha.length; x++)
                {
                    if(isDigit(pilha[x]))
                    {
                        if(pilha[n] == '1' || pilha[x] == '1')
                        {
                            pilha[n] = '*';
                            pilha[x] = '*';
                            pilha[i] = '1';
                        }
                        else
                        {
                            pilha[n] = '*';
                            pilha[x] = '*';
                            pilha[i] = '0';
                        }
                        x = pilha.length;
                    }
                }
                n = pilha.length;
            }
        }

        for(int j = i+1; j < pilha.length; j++)
        {
            if(!isDigit(pilha[j]))
            {
                pilha[j] = ' ';
            }
        }

        return pilha;
    }

    /* =========================================================================== */

    /**
     * Metodo para operar a pilha de tras para frente
     * @param char[] pilha
     */
    public static void operacao (char[] pilha)
    {

        // for(char c: pilha)
        // {
        //     System.out.print(""+c);
        // }
        // System.out.println("");

        for(int i = pilha.length - 1; i >= 0; i--)
        {
            if(pilha[i] == 't')
            {
                pilha = NOT(pilha, i);
                // for(char c: pilha)
                // {
                //     System.out.print(""+c);
                // }
                // System.out.println("");
            }
            else if(pilha[i] == 'd')
            {
                pilha = AND(pilha, i);
                // for(char c: pilha)
                // {
                //     System.out.print(""+c);
                // }
                // System.out.println("");
            }
            else if(pilha[i] == 'r')
            {
                pilha = OR(pilha, i);
                // for(char c: pilha)
                // {
                //     System.out.print(""+c);
                // }
                // System.out.println("");
            }
        }

        System.out.println(""+pilha[0]);
    }

    /**
     * Funcao princial
     * @param String[] args
     */
    public static void main (String[] args) //objetivo: tratar tudo como array an0n0
    {
    
        //System.out.println(""+aux);
        String str;
        // str = MyIO.readLine();
        // String aux = setValues(str);
        char[] array = null;
        // array = toArray(aux);
        // operacao(array);

        for(int i = 1; i <= 104; i++)
        {
            str = MyIO.readLine();
            String aux = setValues(str);
            array = toArray(aux);
            operacao(array);
        }
    }
}