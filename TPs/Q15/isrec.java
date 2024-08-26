/*
 * Gabriel Xavier Borges - 805347 - Q15
*/

class isrec
{

    /*
     * Funcao para verificar condicao de parada
     * @param string
     * @return boolean
    */
    public static boolean isEnd (String str)
    {
        boolean r = false;
        if(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M')
        {
            r = true;
        }
        return r;
    }

    /**
     * Funcao para verificar se caracter e vogal
     * @param char
     * @return boolean
     */
    public static boolean isVogal (char c)
    {
        boolean r = false;
        if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
        {
            r = true;
        }
        return r;
    }

    /**
     * Funcao para verificar se caracter e digito
     * @param char
     * @return boolean
     */
    public static boolean isDigit (char c)
    {
        boolean r = false;
        if(c >= '0' && c <= '9')
        {
            r = true;
        }
        return r;
    }


    /**
     * Funcao para verificar se uma string so tem vogais
     * @param String, int
     * @return boolean
     */
    public static boolean Vogal (String str, int i)
    {
        if(i < str.length())
        {
            if(!isVogal(str.charAt(i)))
            {
                return false;
            }
            else
            {
                return Vogal(str, i + 1);
            }
        }
        return true;
    }

    /**
     * Funcao auxiliar para chamar a funcao vogal (string str, int i)
     * @param string
     * @return boolean
     */
    public static boolean Vogal (String str)
    {
        return Vogal(str, 0);
    }

    /**
     * Funcao para verificar se uma string so tem digitos
     * @param String, int
     * @return boolean
     */
    public static boolean Digit (String str, int i)
    {
        if(i < str.length())
        {
            if(!isDigit(str.charAt(i)))
            {
                return false;
            }
            else
            {
                return Digit(str, i + 1);
            }
        }
        return true;
    }

    /**
     * Funcao auxiliar para chamar a funcao Digit (string str, int i)
     * @param string
     * @return boolean
     */
    public static boolean Digit (String str)
    {
        return Digit (str, 0);
    }

    /**
     * Funcao para verificar se uma string so tem Consoantes
     * @param String, int
     * @return boolean
     */
    public static boolean Consoante (String str, int i)
    {
        if(i < str.length())
        {
            if(!isVogal(str.charAt(i)) && !isDigit(str.charAt(i)))
            {
                return Consoante(str, i + 1);
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Funcao auxiliar para chamar a funcao Consoante (string str, int i)
     * @param string
     * @return boolean
     */
    public static boolean Consoante (String str)
    {
        return Consoante (str, 0);
    }

    /**
     * Funcao para verificar se uma string e um double/real
     * @param String, int
     * @return boolean
     */
    public static boolean Real (String str, int i, int ponto)
    {
        if(i < str.length())
        {
            if(isDigit(str.charAt(i)) || str.charAt(i) == ',' || str.charAt(i) == '.')
            {
                if(isDigit(str.charAt(i)))
                {
                    return Real(str, i + 1, ponto);
                }
                else if(str.charAt(i) == ',' || str.charAt(i) == '.')
                {
                    return Real(str, i + 1, ponto + 1);
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            if(ponto <= 1)
            {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Funcao auxiliar para chamar a funcao Real (string str, int i)
     * @param string
     * @return boolean
     */
    public static boolean Real (String str)
    {
        return Real (str, 0, 0);
    }

    
    public static void main (String[] args)
    {
        String str = MyIO.readLine();

        do
        {
            if(Vogal(str))
            {
                System.out.print("SIM ");
            }
            else
            {
                System.out.print("NAO ");
            }

            if(Consoante(str))
            {
                System.out.print("SIM ");
            }
            else
            {
                System.out.print("NAO ");
            }


            if(Digit(str))
            {
                System.out.print("SIM ");
            }
            else
            {
                System.out.print("NAO ");
            }

            if(Real(str))
            {
                System.out.println("SIM");
            }
            else
            {
                System.out.println("NAO");
            }
            str = MyIO.readLine();
        }while(!isEnd(str));
    }
}