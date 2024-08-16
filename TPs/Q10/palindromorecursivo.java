/**
 * Gabriel Xavier Borges - 805347 - Q10 a
 */

public class palindromorecursivo
{
    /**
     * Funcao para verificar condicao de parada
     * @param str
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
     * Funcao auxiliar para dar valor inicial a funcao isPalindromo(str,i,j)
     * @param str
     * @return str, index(i), index(j)
     */
    public static boolean isPalindromo (String str)
    {
        return isPalindromo(str, 0, str.length()-1);
    }

    /**
     * Funcao para verificar se e um palindromo
     * Obs: Nao consegui fazer com apenas um retorno
     * @param str, i, j
     * @return boolean
     */
    public static boolean isPalindromo (String str, int i, int j)
    {
        if(i < str.length()/2)
        {
            if(str.charAt(i) != str.charAt(j))
            {
                return false;
            }
            else
            {
                return isPalindromo(str, i+1, j-1);
            }
        }
        return true;
    }

    /**
     * Funcao principal
     * @param agrs
    */
    public static void main (String[] args)
    {
        MyIO.setCharset("UTF-8"); //setCharset pois o padrao nao identifica alguns caracteres
        //US-ASCII funciona

        String str;
        str = MyIO.readLine("");

        do 
        { 
            if(isPalindromo(str))
            {
                MyIO.println("SIM");
            }
            else
            {
                MyIO.println("NAO");
            }
            str = MyIO.readLine("");
        }while (!isEnd(str));
    }
}
